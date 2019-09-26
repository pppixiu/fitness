package com.nicebody.dao;

import com.nicebody.mapper.LoginMapper;
import com.nicebody.pojo.PhoneAuth;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneDaoTest {
    @Autowired
    LoginMapper loginMapper;

    @Test
    @Ignore
    public void queryAuthNumberTest(){
        String phone = "123456789";
        PhoneAuth phoneAuth = loginMapper.queryAuthNumber(phone);
        System.out.println(phoneAuth.getAuthNumber());


    }

    @Test
    public void updateAuthNumberTest(){
        PhoneAuth phoneAuth = new PhoneAuth();
        phoneAuth.setPhoneNumber("123456789");
        phoneAuth.setAuthNumber("5678");
        int effect = loginMapper.updatePhoneAuth(phoneAuth);
        System.out.println(effect);

    }
    @Test
    public void insertAuthNumberTest(){
        PhoneAuth phoneAuth = new PhoneAuth();
        phoneAuth.setPhoneNumber("000000000");
        phoneAuth.setAuthNumber("7890");
        int effect = loginMapper.insertPhoneAuth(phoneAuth);
        System.out.println(effect);
    }





}
