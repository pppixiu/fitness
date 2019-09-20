package com.nicebody.controller;

import com.google.gson.Gson;
import com.nicebody.dto.QiNiuPutRet;
import com.nicebody.enums.UserCenterInfoEnum;
import com.nicebody.pojo.Blog;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
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

    @Autowired
    private QiNiuService qiNiuService;
    // 实例化Gson
    Gson gson = new Gson();

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
     *  通过博客内容模糊查找博客信息
     *  或者查询全部博客
     * @param blogContent
     * @return
     */
    @RequestMapping("/getuserblogbyuseridorcontentlike")
    public ResultVO getUserBlogByUserIdOrContentLike(@RequestParam("pageIndex")int pageIndex,
                                                     @RequestParam("pageSize")int pageSize,
                                                     @RequestParam("blogContent") String blogContent){

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
     *  图片上传
     * @param userBlog
     * @return
     */
    @RequestMapping("/adduserblog")
    @ResponseBody
    public Map<String,Object> addUserBlog(Blog userBlog){
        Map<String,Object> map = new HashMap<>();
        int count = userBlogService.addUserBlog(userBlog);
        map.put("success",true);
        map.put("count",count);
        return map;
    }

    @RequestMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public ResultVO uploadPhoto(@RequestParam("file")MultipartFile file,
                                HttpServletRequest request){
        String fileName = file.getOriginalFilename();

        try {
            InputStream inputStream = file.getInputStream();
            Response response = qiNiuService.uploadFile(inputStream);
            if (response.isOK()) {
                QiNiuPutRet ret = gson.fromJson(response.bodyString(), QiNiuPutRet.class);
                return ResultVOUtil.success(ret);
            } else {
                return ResultVOUtil.error(response.statusCode, response.getInfo());
            }
        } catch (QiniuException e) {
            Response response = e.response;
            try {
                return  ResultVOUtil.error(response.statusCode, response.bodyString());
            } catch (QiniuException e1) {
                e1.printStackTrace();
                return ResultVOUtil.none(UserCenterInfoEnum.ERROR);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResultVOUtil.none(UserCenterInfoEnum.ERROR);
        }
    }

}
