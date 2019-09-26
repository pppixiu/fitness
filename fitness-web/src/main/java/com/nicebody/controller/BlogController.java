package com.nicebody.controller;

import com.nicebody.pojo.Blog;
import com.nicebody.pojo.BlogImage;
import com.nicebody.pojo.BlogLike;
import com.nicebody.service.BlogService;
import com.nicebody.service.QiNiuService;
import com.nicebody.util.ResultVOUtil;
import com.nicebody.util.WangEditor;
import com.nicebody.vo.ResultVO;
import com.nicebody.vo.UserBlogVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
     *  按博客ID和用户ID
     *  判断博客点赞状态
     * @return
     */
    @RequestMapping("/getlikeactive")
    public ResultVO getLikeActive(int blogId,HttpSession session){
        // session用来取登录的用户id
        int userId = 5;
        BlogLike blogLike = userBlogService.getLikeActive(blogId,userId);
        if (blogLike == null){
            return ResultVOUtil.success(0);
        } else {
            return ResultVOUtil.success(1);
        }

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
    public ResultVO addUserBlog(Blog blog, HttpSession session){
        String content = blog.getBlogContent();
        // 筛选多余img标签
        Pattern pattern = Pattern.compile("\\<+img.*?\\>");
        Matcher matcher = pattern.matcher(content);
        String blogContent = matcher.replaceAll(" ");

        blog.setUserId(10);
        blog.setBlogContent(blogContent);
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
        return ResultVOUtil.success(blogCount);
    }

    @RequestMapping("/adduserblogactive")
    @ResponseBody
    public int addUserBlogActive(@Param("blogLike") BlogLike blogLike){
        int count = userBlogService.addUserBlogActive(blogLike);
        return count;
    }

    /**
     *  上传文件到七牛云
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload")
    @ResponseBody
    public WangEditor uploadPhoto(@RequestParam("file")MultipartFile file,
                                HttpServletRequest request){
        if(file.isEmpty()) {
            return null;
        }
        try {
            // 获取上传到七牛云的文件url
            fileUrl = qiNiuService.uploadMulFile(file);
            blogImage.setImageUrl(fileUrl);
            String[] str = {fileUrl};
            // 将文件的url放入WangEditor中保存
            WangEditor we = new WangEditor(str);
            return we;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  修改博客浏览量
     * @param blog
     * @return
     */
    @RequestMapping(value = "/modifyviewcount")
    @ResponseBody
    public ResultVO modifyViewCount(Blog blog){
        int blogId = blog.getBlogId();
        int viewCount = blog.getViewCount();
        // 将获取到的数据放入blog对象中
        Blog userBlogCondition = new Blog();
        userBlogCondition.setBlogId(blogId);
        userBlogCondition.setViewCount(viewCount);
        userBlogCondition.setUpdateTime(new Date());
        // 根据条件进行更新浏览量操作
        int count = userBlogService.modifyViewCount(userBlogCondition);
        return ResultVOUtil.success(count);
    }

    /**
     *  修改博客点赞量
     * @param blog
     * @param session
     * @return
     */
    @RequestMapping("/modifylikecount")
    @ResponseBody
    public ResultVO modifyLikeCount(Blog blog,HttpSession session) {
        BlogLike blogLike = new BlogLike();
        Blog userBlogCondition = new Blog();
        int countAdd = 0;
        int countUpdate = 0;
        int countDelete = 0;
        int blogId = blog.getBlogId();

        // 将获取到的数据放入blog对象中
        int likeCount = blog.getLikeCount();
        userBlogCondition.setBlogId(blogId);
        userBlogCondition.setLikeCount(likeCount);
        userBlogCondition.setUpdateTime(new Date());
        // session用来取UserId
        int userId = 5;
        // 先取出博客点赞状态，如果为0，说明该用户没点赞该博客，进行添加操作
        // 如果值为1，则进行博客点赞状态表的删除操作
        blogLike = userBlogService.getLikeActive(blogId,userId);

        // 如果在数据库中没有找到对应的状态
        // 向数据库中添加状态
        if (blogLike == null){
            System.out.println(blogLike+"*********");
            blogLike = new BlogLike();
            blogLike.setBlogId(blogId);
            blogLike.setUserId(userId);
        //    countUpdate = userBlogService.modifyLikeCount(blogLike,userBlogCondition);
            countAdd = userBlogService.addUserBlogActive(blogLike);

        } else {
        //    countUpdate = userBlogService.modifyLikeCount(blogLike,userBlogCondition);
            System.out.println(blogLike.getBlogId()+"&&&&&&&&&");
            countDelete = userBlogService.deleteBlogLike(blogId);
        }
        // 根据条件进行更新点赞数操作

        countUpdate = userBlogService.modifyLikeCount(blogLike,userBlogCondition);
        return ResultVOUtil.success(countUpdate);
    }

}
