package com.nicebody.service.impl;

import com.nicebody.pojo.UserBlog;
import com.nicebody.service.UserBlogService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author 曹钲
 * @since 2019/09/17 23:15
 *
 *  UserBlogImpl测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBlogImplTest {
//    @Autowired
//    private UserBlogService userBlogService;
//
//    @Test
//    @Ignore
//    public void getUserBlogTest(){
//        List<UserBlog> userBlogList = userBlogService.getUserBlog();
//        System.out.println(userBlogList.size());
//    }
//
//    @Test
//    @Ignore
//    public void getUserBlogByBlogId(){
//        List<UserBlog> userBlogList = userBlogService.getUserBlogByBlogId(8);
//        System.out.println(userBlogList.size());
//    }
//
//    @Test
//    @Ignore
//    public void getUserBlogByUserId(){
//        List<UserBlog> userBlogList = userBlogService.getUserBlogByUserId(2);
//        System.out.println(userBlogList.size());
//    }
//
//    @Test
//    @Ignore
//    public void getUserBlogByContentLike(){
//        List<UserBlog> userBlogList = userBlogService.getUserBlogByContentLike("测");
//        System.out.println(userBlogList.size());
//    }
//
//    @Test
//    @Ignore
//    public void addUserBlog(){
//        UserBlog userBlog = new UserBlog();
//        userBlog.setUserId(5);
//        userBlog.setViewCount(23);
//        userBlog.setLikeCount(23);
//        userBlog.setBlogContent("测试添加");
//        userBlog.setCreateTime(new Date());
//        userBlog.setUpdateTime(new Date());
//        int count = userBlogService.addUserBlog(userBlog);
//        System.out.println(count);
//    }
//
//    @Test
//    @Ignore
//    public void deleteUserBlogByBlogIdAndUserId(){
//        int count = userBlogService.deleteUserBlogByBlogIdAndUserId(5,9);
//        System.out.println(count);
//    }
//
//    @Test
//    public void deleteUserBlogImgByBlogId(){
//        int count = userBlogService.deleteUserBlogImgByBlogId(8);
//        System.out.println(count);
//    }
}
