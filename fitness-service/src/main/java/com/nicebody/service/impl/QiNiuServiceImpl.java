package com.nicebody.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.nicebody.service.QiNiuService;
import com.nicebody.util.FileUtil;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.io.InputStream;


@Service
public class QiNiuServiceImpl implements QiNiuService, InitializingBean {
    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    // 从application-dev.yml文件中获取注册的七牛云信息
    private String accessKey = "j_2BGkC7mtUqlxU8FTuOcxi02byvx9GxpaBPL9bp";
    private String secretKey = "rsIe54f9DVXiqj5HRhdoAMu5YuHrz4Udhbzx8eIH";
    private String bucket = "nicebody";
    private String path = "http://pxwqui3qb.bkt.clouddn.com/";

    // 构建一个带指定Zone对象的配置类，不同的七牛云存储区域调用不同的zone，zone2华南机房
    Configuration cfg = new Configuration(Zone.zone2());

    // 构建一个七牛上传工具实例
    UploadManager uploadManager  = new UploadManager(cfg);

    // 认证信息实例
    Auth auth = Auth.create(accessKey,secretKey);

    // 构建七牛空间管理实例
    BucketManager bucketManager = new BucketManager(auth, cfg);

    private StringMap putPolicy;

    @Override
    public Response uploadFile(File file) throws QiniuException {
        Response response = this.uploadManager.put(file, null, getUploadToken());
        int retry = 0;
        while (response.needRetry() && retry < 3){
            response = this.uploadManager.put(file, null, getUploadToken());
            retry++;
        }
        return response;
    }

    @Override
    public Response uploadFile(InputStream inputStream) throws QiniuException {
        Response response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
        int retry = 0;
        while (response.needRetry() && retry < 3){
            response = this.uploadManager.put(inputStream, null, getUploadToken(), null, null);
            retry++;
        }
        return response;
    }

    @Override
    public Response delete(String key) throws QiniuException {
        Response response = bucketManager.delete(this.bucket, key);
        int retry = 0;
        while (response.needRetry() && retry++ <3) {
            response = bucketManager.delete(this.bucket, key);
        }
        return response;
    }

    @Override
    public String uploadMulFile(MultipartFile multipartFile) {
        int dotPos = multipartFile.getOriginalFilename().lastIndexOf(".");
        if (dotPos < 0) {
            return null;
        }
        String fileExt = multipartFile.getOriginalFilename().substring(dotPos + 1).toLowerCase();
        // 判断是否是合法的文件后缀
        if (!FileUtil.isFileAllowed(fileExt)) {
            return null;
        }

        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileExt;
        // 调用put方法上传
        try {
            Response response = uploadManager.put(multipartFile.getBytes(),fileName, getUploadToken());
            // 重新上传次数
            int retry = 0;
            while (response.needRetry() && retry < 3){
                response = this.uploadManager.put(multipartFile.getBytes(),fileName, getUploadToken());
                retry++;
            }
            // 打印返回的信息
            if (response.isOK() && response.isJson()) {
                // 返回存储文件的地址
                return path + JSONObject.parseObject(response.bodyString()).get("key");
            } else {
                logger.error("七牛异常：" + response.bodyString());
                return null;
            }
        } catch (IOException e) {
            // 请求失败时打印的异常信息
            logger.error("七牛异常：" + e.getMessage());
            return null;
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.putPolicy = new StringMap();
        putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\"," +
                "\"width\":$(imageInfo.width),\"height\":\"$(imageInfo.height)\",\"age\",$(x:age)}");
    }

    /**
     *  获取上传凭证
     * @return
     */
    private String getUploadToken(){
        return this.auth.uploadToken(bucket);
    }

}
