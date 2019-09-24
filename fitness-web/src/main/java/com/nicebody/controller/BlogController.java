package com.nicebody.controller;

import com.google.gson.Gson;
import com.nicebody.dto.QiNiuPutRet;
import com.nicebody.enums.UserCenterInfoEnum;
import com.nicebody.pojo.Blog;
import com.nicebody.pojo.BlogImage;
import com.nicebody.service.BlogService;
import com.nicebody.service.QiNiuService;
import com.nicebody.service.impl.QiNiuServiceImpl;
import com.nicebody.util.ResultVOUtil;
import com.nicebody.util.WangEditor;
import com.nicebody.vo.ResultVO;
import com.nicebody.vo.UserBlogVO;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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

    @Autowired
    private QiNiuService qiNiuService;
    // 实例化Gson
    Gson gson = new Gson();

    // 文件url
    String fileUrl;

    BlogImage blogImage = new BlogImage();
    /**
     *  按博客ID查询博客信息
     * @param blogId
     * @return
     */
    @RequestMapping("/getuserblogbyblogid")
    public ResultVO getUserBlogByBlogId(int blogId){
        //取出blog
        Blog blog = userBlogService.getUserBlogByBlogId(blogId);
        return ResultVOUtil.success(blog);
    }

    /**
     *  按用户ID查询博客信息
     * @param userId
     * @return
     */
    @RequestMapping("/getuserblogbyuserid")
    public ResultVO getUserBlogByUserId(@RequestParam("pageIndex")int pageIndex,
                                        @RequestParam("pageSize")int pageSize,
                                        @RequestParam("userId") int userId){
        List<UserBlogVO> blogVOList = new ArrayList<>();
        Blog userBlogCondition = new Blog();
        userBlogCondition.setUserId(userId);
        //取出blog集合
        List<Blog> blogList = userBlogService.getUserBlogByUserIdOrContentLike(pageIndex,pageSize,userBlogCondition);
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
     *  查询用户博客总浏览数
     * @param
     * @return
     */
    @RequestMapping("/getviewcount")
    public ResultVO getViewCount(@RequestParam("userId") int userId){
        Blog userBlogCondition = new Blog();
        userBlogCondition.setUserId(userId);
        int viewCount = userBlogService.getViewCount(userBlogCondition);
        return ResultVOUtil.success(viewCount);
    }

    /**
     *  查询用户博客总点赞数
     * @param
     * @return
     */
    @RequestMapping("/getlikecount")
    public ResultVO getLikeCount(@RequestParam("userId") int userId){
        Blog userBlogCondition = new Blog();
        userBlogCondition.setUserId(userId);
        int likeCount = userBlogService.getLikeCount(userBlogCondition);
        return ResultVOUtil.success(likeCount);
    }

    /**
     *  通过博客内容模糊查找博客信息
     *  或者查询全部博客
     * @param blogContent
     * @return
     */
    @RequestMapping("/getuserblogbyuseridorcontentlike")
    public ResultVO getUserBlogByUserIdOrContentLike(@RequestParam("pageIndex")int pageIndex,
                                                     @RequestParam("pageSize")int pageSize,
                                                     @RequestParam("blogContent")String blogContent){

        List<UserBlogVO> blogVOList = new ArrayList<>();
        Blog userBlogCondition = new Blog();
        userBlogCondition.setBlogContent(blogContent);
        //取出blog集合
        List<Blog> blogList = userBlogService.getUserBlogByUserIdOrContentLike(pageIndex,pageSize,userBlogCondition);
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
     * @param
     * @return
     */
    @RequestMapping("/adduserblog")
    @ResponseBody
    public int addUserBlog(Blog blog, HttpSession session){
        String content = blog.getBlogContent();
        blog.setUserId(10);
        blog.setBlogContent(content);
        blog.setViewCount(0);
        blog.setLikeCount(0);
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        System.out.println(blog.getBlogId());
        int blogCount = userBlogService.addUserBlog(blog);

        // 通过BlogId添加Blog图片信息
        blogImage.setBlogId(blog.getBlogId());
        System.out.println(blog.getBlogId());
        blogImage.setCreateTime(new Date());
        blogImage.setUpdateTime(new Date());
        int blogImageCount = userBlogService.addUserBlogImage(blogImage);
        return blogCount;
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public WangEditor uploadPhoto(@RequestParam("file")MultipartFile file,
                                HttpServletRequest request){
        if(file.isEmpty()) {
            return null;
        }
        try {
            fileUrl = qiNiuService.uploadMulFile(file);
            blogImage.setImageUrl(fileUrl);
            String[] str = {fileUrl};
            WangEditor we = new WangEditor(str);
            return we;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
