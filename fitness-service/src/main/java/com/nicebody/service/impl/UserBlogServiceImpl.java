package com.nicebody.service.impl;

import com.nicebody.mapper.UserBlogMapper;
import com.nicebody.pojo.UserBlog;
import com.nicebody.service.UserBlogService;
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
public class UserBlogServiceImpl implements UserBlogService {

    @Autowired
    private UserBlogMapper userBlogMapper;

    @Override
    public List<UserBlog> getUserBlog() {
        return userBlogMapper.queryUserBlog();
    }

    @Override
    public List<UserBlog> getUserBlogByBlogId(int blogId) {
        return userBlogMapper.queryUserBlogByBlogId(blogId);
    }

    @Override
    public List<UserBlog> getUserBlogByUserId(int userId) {
        return userBlogMapper.queryUserBlogByUserId(userId);
    }

    @Override
    public List<UserBlog> getUserBlogByContentLike(String blogContent) {
        return userBlogMapper.queryUserBlogByContentLike(blogContent);
    }

    @Override
    public int addUserBlog(UserBlog userBlog) {
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
