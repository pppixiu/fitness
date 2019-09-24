package com.nicebody.service.impl;

import com.nicebody.pojo.UserProfile;
import com.nicebody.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void insertUserTest() {
        UserProfile userProfile = new UserProfile();
        userProfile.setUserName("魏大勋");
        int effects = userService.insertUser(userProfile);
        System.out.println(effects);
    }


}
