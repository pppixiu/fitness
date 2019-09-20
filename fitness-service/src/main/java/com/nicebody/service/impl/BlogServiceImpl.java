package com.nicebody.service.impl;

import com.nicebody.mapper.BlogMapper;
import com.nicebody.pojo.Blog;
import com.nicebody.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 曹钲
 * @since 2019/09/17 22:30
 *
 *  UserBlogService层实现
 */

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper userBlogMapper;

    @Override
    public Blog getUserBlogByBlogId(int blogId) {
        return userBlogMapper.queryUserBlogByBlogId(blogId);
    }

    @Override
    public int getViewCount(Blog userBlogCondition) {
        return userBlogMapper.queryViewCount(userBlogCondition);
    }

    @Override
    public int getLikeCount(Blog userBlogCondition) {
        return userBlogMapper.queryLikeCount(userBlogCondition);
    }


    @Override
    public List<Blog> getUserBlogByUserIdOrContentLike(int rowIndex, int pageSize, Blog userBlogCondition) {
        return userBlogMapper.queryUserBlogByUserIdOrContentLike(rowIndex,pageSize,userBlogCondition);
    }

    @Override
    public int addUserBlog(Blog userBlog) {
        return userBlogMapper.insertUserBlog(userBlog);
    }

    @Override
    public int deleteUserBlogByBlogIdAndUserId(int userId, int blogId) {
        return userBlogMapper.deleteUserBlogByBlogIdAndUserId(userId,blogId);
    }

    @Override
    public int deleteUserBlogImgByBlogId(int blogId) {
        return userBlogMapper.deleteUserBlogImgByBlogId(blogId);
    }
}
