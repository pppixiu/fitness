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
public class BlogController {

    @Autowired
    private BlogService userBlogService;

    /**
     *  按博客ID查询博客信息
     * @param blogId
     * @return
     */
    @RequestMapping("/getuserblogbyblogid")
    public ResultVO getUserBlogByBlogId(int blogId){
        //取出blog集合
        Blog blogList = userBlogService.getUserBlogByBlogId(blogId);
        return ResultVOUtil.success(blogList);
    }

    /**
     *  查询用户博客总浏览数
     * @param userBlogCondition
     * @return
     */
    @RequestMapping("/getviewcount")
    public ResultVO getViewCount(Blog userBlogCondition){
        int viewCount = userBlogService.getViewCount(userBlogCondition);
        return ResultVOUtil.success(viewCount);
    }

    /**
     *  查询用户博客总点赞数
     * @param userBlogCondition
     * @return
     */
    @RequestMapping("/getlikecount")
    public ResultVO getLikeCount(Blog userBlogCondition){
        int likeCount = userBlogService.getLikeCount(userBlogCondition);
        return ResultVOUtil.success(likeCount);
    }

    /**
     *  通过用户Id查找用户博客
     *  或者通过博客内容模糊查找博客信息
     *  或者查询全部博客
     * @param userBlogCondition
     * @return
     */
    @RequestMapping("/getuserblogbyuseridorcontentlike")
    public ResultVO getUserBlogByUserIdOrContentLike(int rowIndex,
                                                     int pageSize,
                                                     Blog userBlogCondition){

        List<UserBlogVO> blogVOList = new ArrayList<>();
        //取出blog集合
        List<Blog> blogList = userBlogService.getUserBlogByUserIdOrContentLike(rowIndex,pageSize,userBlogCondition);
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



    /**
     *  添加博客信息
     * @param userBlog
     * @return
     */
    @RequestMapping("/adduserblog")
    public Map<String,Object> addUserBlog(Blog userBlog){
        Map<String,Object> map = new HashMap<>();
        int count = userBlogService.addUserBlog(userBlog);
        map.put("success",true);
        map.put("count",count);
        return map;
    }

}
