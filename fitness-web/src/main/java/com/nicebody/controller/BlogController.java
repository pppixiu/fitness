package com.nicebody.controller;

import com.nicebody.interceptor.LoginRequired;
import com.nicebody.pojo.Blog;
import com.nicebody.pojo.BlogImage;
import com.nicebody.pojo.BlogLike;
import com.nicebody.pojo.UserProfile;
import com.nicebody.service.BlogService;
import com.nicebody.service.QiNiuService;
import com.nicebody.util.ResultVOUtil;
import com.nicebody.util.WangEditor;
import com.nicebody.vo.BlogVo;
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
//    @RequestMapping("/getlikeactive")
//    public ResultVO getLikeActive(int blogId,HttpSession session){
//        // session用来取登录的用户id
//        int userId = 5;
//        BlogLike blogLike = userBlogService.getLikeActive(blogId,userId);
//        if (blogLike == null){
//            return ResultVOUtil.success(0);
//        } else {
//            return ResultVOUtil.success(1);
//        }
//
//    }

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
    @LoginRequired
    @ResponseBody
    public ResultVO addUserBlog(Blog blog, HttpServletRequest request){
        String content = blog.getBlogContent();
        // 筛选多余img标签
        Pattern pattern = Pattern.compile("\\<+img.*?\\>");
        Matcher matcher = pattern.matcher(content);
        String blogContent = matcher.replaceAll(" ");

        UserProfile userProfile = new UserProfile();
        HttpSession session = request.getSession();
        userProfile = (UserProfile) session.getAttribute("userProfile");

        blog.setUserId(userProfile.getUserId());
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

//    @RequestMapping("/adduserblogactive")
//    @ResponseBody
//    public int addUserBlogActive(@Param("blogLike") BlogLike blogLike){
//        int count = userBlogService.addUserBlogActive(blogLike);
//        return count;
//    }

    /**
     *  上传文件到七牛云
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload")
    @ResponseBody
    @LoginRequired
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
     * @return
     */
    @RequestMapping("/modifylikecount")
    @ResponseBody
    @LoginRequired
    public ResultVO modifyLikeCount(@RequestParam(name = "blogId") Integer blogId,
                                    HttpServletRequest request) {
       // 判断值
        int judge = 0;
        int likeJudge = 0;

        UserProfile userProfile = new UserProfile();
        HttpSession session = request.getSession();
        userProfile = (UserProfile) session.getAttribute("userProfile");
        int userId = userProfile.getUserId();
        //先查询关联表里有没有该用户信息，有返回值为blogId,没有为null
        String blogLikeJudge = userBlogService.getLikeActive(blogId,userId);
       if(blogLikeJudge == null) {
           likeJudge = 1;
           // 没有该关联，向表中添加信息
           int addLikeInfo = userBlogService.addUserBlogActive(blogId,userId);
           if(addLikeInfo == 1) {
               //如果修改成功，则修改点赞数，并返回
               judge = userBlogService.modifyLikeCount(blogId,1);
           }
       } else {
           likeJudge = 0;
           //如果表中有该关联，则删除该表关联，点赞数-1
           int delLikeInfo = userBlogService.deleteBlogLike(blogId,userId);
           if(delLikeInfo == 1) {
               judge = userBlogService.modifyLikeCount(blogId,-1);
           }
       }

       // 判断是否修改成功
        if(judge == 1) {
            Blog blog = new Blog();
            BlogVo blogVo = new BlogVo();
            Blog blogCondition = new Blog();
            blogCondition.setUserId(userId);
            blogCondition.setBlogId(blogId);
            List<Blog> blogList = userBlogService.getUserBlogByUserIdOrContentLike(0,1,blogCondition);
            blog = blogList.get(0);
            BeanUtils.copyProperties(blog,blogVo);
            blogVo.setLikeJudge(likeJudge);
            return ResultVOUtil.success(blogVo);
        }else {
            return null;
        }
    }

}
