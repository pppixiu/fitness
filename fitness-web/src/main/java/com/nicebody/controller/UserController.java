package com.nicebody.controller;


import com.nicebody.pojo.Blog;
import com.nicebody.service.BlogService;
import com.nicebody.util.ResultVOUtil;
import com.nicebody.vo.ResultVO;
import com.nicebody.vo.UserBlogVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Author sensu
 * @Date 2019/9/19 9:54
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private BlogService userBlogService;

    @RequestMapping("/bloglist")
    public ResultVO getBlogList(){
        List<UserBlogVO> blogVOList = new ArrayList<>();
        //权限管理改为session
        //TODO
        Blog userBlogCondition = new Blog();
        userBlogCondition.setUserId(2);
        //取出blog集合
        List<Blog> blogList = userBlogService.getUserBlogByUserIdOrContentLike(0,1,userBlogCondition);
        //填值
        for(Blog userBlog : blogList){
            UserBlogVO userBlogVO = new UserBlogVO();
            BeanUtils.copyProperties(userBlog, userBlogVO);
            userBlogVO.setImageUrl(userBlog.getUserBlogImage().getImageUrl());
            blogVOList.add(userBlogVO);
        }
        //通过公共方法返回
        return ResultVOUtil.success(blogVOList);
    }
}
