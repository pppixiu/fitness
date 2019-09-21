package com.nicebody.service.impl;

import com.nicebody.service.QiNiuService;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 *  七牛云上传图片测试
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class QiNiuServiceImplTest {
    @Autowired
    private QiNiuService qiNiuService;
    @Test
    public void testUploadFile() {
        String fileName = "E:\\idea_projects\\nicebody_0917\\fitness\\fitness-app\\src\\main\\resources\\static\\images\\2.jpg";
        File file = new File(fileName);

        Assert.assertTrue(file.exists());
        try {
            Response response = qiNiuService.uploadFile(file);
            Assert.assertTrue(response.isOK());
        } catch (QiniuException e) {
            e.printStackTrace();
        }
    }
}
