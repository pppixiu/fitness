package com.nicebody.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.nicebody.service.CodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeServiceImplTest {
    @Autowired
    CodeService codeService;

    @Test
    public void getCodeTest(){
        String phone = "15776506691";
        JSONObject jsonObject = codeService.Code(phone);
        System.out.println(jsonObject);


    }
}
