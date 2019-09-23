package com.nicebody.dao;

import com.nicebody.mapper.PhoneMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneTest {
    @Autowired
    PhoneMapper phoneMapper;

    public void queryAuthNumberTest(){

    }



}
