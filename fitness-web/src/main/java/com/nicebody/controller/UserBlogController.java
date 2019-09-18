package com.nicebody.controller;

import com.nicebody.pojo.Course;
import com.nicebody.pojo.UserBlog;
import com.nicebody.service.UserBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 曹钲
 * @since  2019/09/17 23:51
 *
 *  UserBlog的控制层
 */

@RestController
@RequestMapping("/blog")
public class UserBlogController {

//    @Autowired
//    private UserBlogService userBlogService;
//
//    @RequestMapping("/getuserblog")
//    public Map<String, Object> getUserBlog(){
//        Map<String, Object> map = new HashMap<>();
//        List<UserBlog> userBlogList = userBlogService.getUserBlog();
//        map.put("success", true);
//        map.put("userBlogList", userBlogList);
//        return map;
//    }
//
//    @RequestMapping("/getuserblogbyblogid")
//    public Map<String, Object> getUserBlogByBlogId(int blogId){
//        Map<String, Object> map = new HashMap<>();
//        List<UserBlog> userBlogList = userBlogService.getUserBlogByBlogId(blogId);
//        map.put("success", true);
//        map.put("userBlogList", userBlogList);
//        return map;
//    }
//
//    @RequestMapping("/getuserblogbyuserid")
//    public Map<String,Object> getUserBlogByUserId(int userId){
//        Map<String, Object> map = new HashMap<>();
//        List<UserBlog> userBlogList = userBlogService.getUserBlogByUserId(userId);
//        map.put("success", true);
//        map.put("userBlogList", userBlogList);
//        return map;
//    }
//
//    @RequestMapping("/getuserblogbycontentlike")
//    public Map<String,Object> getUserBlogByContentLike(String blogContent){
//        Map<String, Object> map = new HashMap<>();
//        List<UserBlog> userBlogList = userBlogService.getUserBlogByContentLike(blogContent);
//        map.put("success", true);
//        map.put("userBlogList", userBlogList);
//        return map;
//    }
//
//    @RequestMapping("/adduserblog")
//    public Map<String,Object> addUserBlog(UserBlog userBlog){
//        Map<String,Object> map = new HashMap<>();
//        int count = userBlogService.addUserBlog(userBlog);
//        map.put("success",true);
//        map.put("count",count);
//        return map;
//    }

}
