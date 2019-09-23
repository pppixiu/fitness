package com.nicebody.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.nicebody.service.CodeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
