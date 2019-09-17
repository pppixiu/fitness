package com.nicebody.dao;
import com.nicebody.mapper.UserBlogMapper;
import com.nicebody.pojo.UserBlog;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author 曹钲
 * @since 2019/09/17 11:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBlogMapperTest {
    @Autowired
    private UserBlogMapper userBlogMapper;

    /**
     *  测试按用户id查询该用户博客
     */
    @Test
    @Ignore
    public void testqueryUserBlogByUserId(){
        List<UserBlog> userBlogList = userBlogMapper.queryUserBlogByUserId(2);
        System.out.println(userBlogList.size());
    }

    /**
     *  测试查询所有博客
     */
    @Test
    @Ignore
    public void testqueryUserBlog(){
        List<UserBlog> userBlogList = userBlogMapper.queryUserBlog();
        System.out.println(userBlogList.size());
    }

    /**
     *  测试按博客id查询该博客信息
     */
    @Test
    @Ignore
    public void testqueryUserBlogByBlogId(){
        List<UserBlog> userBlogList = userBlogMapper.queryUserBlogByBlogId(1);
        System.out.println(userBlogList.size());
    }

    /**
     *  添加用户博客
     */
    @Test
    @Ignore
    public void testinsertUserBlog(){
        UserBlog userBlog = new UserBlog();
        userBlog.setUserId(5);
        userBlog.setViewCount(23);
        userBlog.setLikeCount(23);
        userBlog.setBlogContent("测试添加");
        userBlog.setCreateTime(new Date());
        userBlog.setUpdateTime(new Date());
        int count = userBlogMapper.insertUserBlog(userBlog);
        System.out.println(count);
    }

    /**
     *  按照用户Id和博客Id删除该博客
     */
    @Test
    @Ignore
    public void testdeleteUserBlogByBlogIdAndUserId(){
        int count = userBlogMapper.deleteUserBlogByBlogIdAndUserId(2,1);
        System.out.println(count);
    }

    /**
     *  按照博客Id删除博客图片
     */
    @Test
    @Ignore
    public void testdeleteUserBlogImgByBlogId(){
        int count = userBlogMapper.deleteUserBlogImgByBlogId(1);
        System.out.println(count);
    }

    /**
     *  按照博客内容模糊查询博客
     */
    @Test
    public void testqueryUserBlogByContentLike(){
        List<UserBlog> userBlogList = userBlogMapper.queryUserBlogByContentLike("添");
        System.out.println(userBlogList.size());
        System.out.println(userBlogList);
    }
}