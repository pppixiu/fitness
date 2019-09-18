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

    @Autowired
    private UserBlogService userBlogService;

    /**
     *  查询所有博客
     * @return
     */
    @RequestMapping("/getuserblog")
    public Map<String, Object> getUserBlog(){
        Map<String, Object> map = new HashMap<>();
        List<UserBlog> userBlogList = userBlogService.getUserBlog();
        map.put("success", true);
        map.put("userBlogList", userBlogList);
        return map;
    }

    /**
     *  按博客ID查询博客信息
     * @param blogId
     * @return
     */
    @RequestMapping("/getuserblogbyblogid")
    public Map<String, Object> getUserBlogByBlogId(int blogId){
        Map<String, Object> map = new HashMap<>();
        UserBlog userBlog = userBlogService.getUserBlogByBlogId(blogId);
        map.put("success", true);
        map.put("userBlog", userBlog);
        return map;
    }

    /**
     *  通过用户Id查找用户博客
     *  或者通过博客内容模糊查找博客信息
     * @param userBlogCondition
     * @return
     */
    @RequestMapping("getuserblogbyuseridorcontentlike")
    public Map<String,Object> getUserBlogByUserIdOrContentLike(UserBlog userBlogCondition){
        Map<String, Object> map = new HashMap<>();
        List<UserBlog> userBlogList = userBlogService.getUserBlogByUserIdOrContentLike(userBlogCondition);
        map.put("success", true);
        map.put("userBlogList", userBlogList);
        return map;
    }

    /**
     *  添加博客信息
     * @param userBlog
     * @return
     */
    @RequestMapping("/adduserblog")
    public Map<String,Object> addUserBlog(UserBlog userBlog){
        Map<String,Object> map = new HashMap<>();
        int count = userBlogService.addUserBlog(userBlog);
        map.put("success",true);
        map.put("count",count);
        return map;
    }

}
