package com.nicebody.dao;
import com.nicebody.mapper.BlogMapper;
import com.nicebody.pojo.Blog;
import com.nicebody.pojo.BlogImage;
import com.nicebody.pojo.BlogLike;
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
 * @since 2019/09/17 11:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBlogMapperTest {
    @Autowired
    private BlogMapper userBlogMapper;

    /**
     *  测试按用户id查询该用户博客
     */
//    @Test
//    @Ignore
//    public void testqueryUserBlogByUserId(){
//        List<UserBlog> userBlogList = userBlogMapper.queryUserBlogByUserId(2);
//        System.out.println(userBlogList.size());
//    }

    /**
     *  测试按用户Id查询用户博客或根据博客内容模糊查询博客
     */
    @Test
    @Ignore
    public void testgetUserBlogByUserIdOrContentLike() {
        Blog userBlogCondition = new Blog();
        // userBlogCondition.setUserId(2);
        //userBlogCondition.setBlogContent("添");
        List<Blog> userBlogList = userBlogMapper.queryUserBlogByUserIdOrContentLike(0,10,userBlogCondition);
        System.out.println(userBlogList.size());
    }

    @Test
    @Ignore
    public void testinsertUserBlogImage(){
        BlogImage blogImage = new BlogImage();
        blogImage.setBlogId(19);
        blogImage.setImageUrl("https://img3.mukewang.com/szimg/5d1032ab08719e0906000338.jpg");
        blogImage.setCreateTime(new Date());
        blogImage.setUpdateTime(new Date());
        int count = userBlogMapper.insertUserBlogImage(blogImage);
        System.out.println(count);
    }

    @Test
    @Ignore
    public void testupdateViewAndLikeCount(){
        Blog blogCondition = new Blog();
        blogCondition.setBlogId(8);
        //blogCondition.setViewCount(0);
        blogCondition.setLikeCount(0);
        blogCondition.setUpdateTime(new Date());
        int count = userBlogMapper.updateViewCount(blogCondition);
        System.out.println(count);
    }

//    @Test
//    public void testupdateViewAndLikeCount(){
//        Blog blog = new Blog();
//
//    }

//    @Test
//    public void testgetViewAndLikeCount(){
//        Blog userBlogCondition = new Blog();
//        userBlogCondition.setUserId(5);
//        List<Integer> total = userBlogMapper.queryViewAndLikeCount(userBlogCondition);
//        for (int i = 0; i < total.size(); i++) {
//            System.out.println(total.get(i));
//        }
//    }
//
//    /**
//     *  测试查询所有博客
//     */
    @Test
    @Ignore
    public void testqueryUserBlog(){
        List<Blog> userBlogList = userBlogMapper.queryUserBlogByUserIdOrContentLike(1,2,null);
    }

    @Test
    @Ignore
    public void testInsertUserBlogActive(){
        int count = userBlogMapper.insertUserBlogActive(91,6);
        System.out.println(count);
    }
    @Test
    @Ignore
    public void testDeleteBlogLike(){
        int count = userBlogMapper.deleteBlogLike(91,5);
        System.out.println(count);
    }

    @Test
    public void testUpdateLikeCount(){
        int count = userBlogMapper.updateLikeCount(91,1);
        System.out.println(count);
    }

//    @Test
//    @Ignore
//    public void testqueryLikeActiveByUserIdAndBlogId(){
//        BlogLike blogLike = new BlogLike();
//        blogLike.setBlogId(6);
//        blogLike.setUserId(5);
//        BlogLike isActive = userBlogMapper.queryLikeActive(7,5);
//    }
//
//    /**
//     *  测试按博客id查询该博客信息
//     */
//    @Test
//    @Ignore
//    public void testqueryUserBlogByBlogId(){
//        List<UserBlog> userBlogList = userBlogMapper.queryUserBlogByBlogId(1);
//        System.out.println(userBlogList.size());
//    }
//
//    /**
//     *  添加用户博客
//     */
//    @Test
//    @Ignore
//    public void testinsertUserBlog(){
//        UserBlog userBlog = new UserBlog();
//        userBlog.setUserId(5);
//        userBlog.setViewCount(23);
//        userBlog.setLikeCount(23);
//        userBlog.setBlogContent("测试添加");
//        userBlog.setCreateTime(new Date());
//        userBlog.setUpdateTime(new Date());
//        int count = userBlogMapper.insertUserBlog(userBlog);
//        System.out.println(count);
//    }
//
//    /**
//     *  按照用户Id和博客Id删除该博客
//     */
//    @Test
//    @Ignore
//    public void testdeleteUserBlogByBlogIdAndUserId(){
//        int count = userBlogMapper.deleteUserBlogByBlogIdAndUserId(2,1);
//        System.out.println(count);
//    }
//
//    /**
//     *  按照博客Id删除博客图片
//     */
//    @Test
//    @Ignore
//    public void testdeleteUserBlogImgByBlogId(){
//        int count = userBlogMapper.deleteUserBlogImgByBlogId(1);
//        System.out.println(count);
//    }
//
//    /**
//     *  按照博客内容模糊查询博客
//     */
//    @Test
//    public void testqueryUserBlogByContentLike(){
//        List<UserBlog> userBlogList = userBlogMapper.queryUserBlogByContentLike("添");
//        System.out.println(userBlogList.size());
//        System.out.println(userBlogList);
//    }
}
