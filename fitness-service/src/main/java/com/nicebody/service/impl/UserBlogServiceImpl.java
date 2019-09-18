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
    public UserBlog getUserBlogByBlogId(int blogId) {
        return userBlogMapper.queryUserBlogByBlogId(blogId);
    }

    @Override
    public List<UserBlog> getUserBlogByUserIdOrContentLike(UserBlog userBlogCondition) {
        return userBlogMapper.queryUserBlogByUserIdOrContentLike(userBlogCondition);
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
