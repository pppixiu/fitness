package com.nicebody.dao;

import com.nicebody.mapper.TagMapper;
import com.nicebody.pojo.Tag;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.List;

/**
 * @ClassName TagDaoTest
 * @Author sensu
 * @Date 2019/9/18 11:12
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TagDaoTest {
    @Autowired
    private TagMapper tagMapper;

    @Test
    public void queryTag(){
        List<Tag> tagList = tagMapper.queryTag();
        Assert.assertEquals(9, tagList.size());
    }
}
