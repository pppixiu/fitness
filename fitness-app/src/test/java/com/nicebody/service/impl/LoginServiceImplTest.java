package com.nicebody.service.impl;

import com.nicebody.pojo.PhoneAuth;
import com.nicebody.service.LoginService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceImplTest {
    @Autowired
    private LoginService loginService;

    @Test
    @Ignore
    public void getAuthNumberTest(){
        String phone = "123456789";
        PhoneAuth phoneAuth = loginService.getAuthNumber(phone);
        System.out.println(phoneAuth.getAuthNumber());

    }

    @Test
    public void updateAuthNumberTest(){
        PhoneAuth phoneAuth = new PhoneAuth();
        phoneAuth.setPhoneNumber("123456789");
        phoneAuth.setAuthNumber("1234");
        int effect = loginService.updatePhoneAuth(phoneAuth);
        System.out.println(effect);

    }
    @Test
    public void insertAuthNumberTest(){
        PhoneAuth phoneAuth = new PhoneAuth();
        phoneAuth.setPhoneNumber("15776506691");
        phoneAuth.setAuthNumber("2222");
        phoneAuth.setCreateTime(new Date());
        phoneAuth.setUpdateTime(new Date());
        int effect = loginService.insertPhoneAuth(phoneAuth);
        System.out.println(effect);
    }


}
