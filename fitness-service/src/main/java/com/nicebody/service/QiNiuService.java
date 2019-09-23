package com.nicebody.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

/**
 * @author 曹钲
 * @since 2019/09/20 15:03
 *
 *  七牛云服务
 */
public interface QiNiuService {
    /**
     *  以文件的形式上传
     * @param file
     * @return
     * @throws QiniuException
     */
    Response uploadFile(File file) throws QiniuException;

    /**
     *  以流的形式上传
     * @param inputStream
     * @return
     * @throws QiniuException
     */
    Response uploadFile(InputStream inputStream) throws QiniuException;

    /**
     *  删除七牛云里的图片
     * @param key
     * @return
     * @throws QiniuException
     */
    Response delete(String key) throws QiniuException;

    /**
     *  后台上传文件
     * @param multipartFile
     * @return
     */
    public String uploadMulFile(MultipartFile multipartFile);
}
