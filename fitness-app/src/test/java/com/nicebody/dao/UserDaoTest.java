package com.nicebody.dao;

import com.nicebody.mapper.UserMapper;
import com.nicebody.pojo.UserProfile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserMapper userMapper;

    @Test
    public void insertUserTest(){
        UserProfile userProfile = new UserProfile();
        userProfile.setUserName("白敬亭");
        int effects = userMapper.insertUser(userProfile);
        System.out.println(effects);
    }

    @Test
    public void queryUserById(){
        UserProfile userProfile = userMapper.queryUserById(1);
        Assert.assertEquals(10, (long)userProfile.getUserIntegral());
    }
}
