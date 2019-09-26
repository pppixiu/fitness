package com.nicebody.service.impl;

import com.nicebody.mapper.BlogMapper;
import com.nicebody.pojo.Blog;
import com.nicebody.pojo.BlogImage;
import com.nicebody.pojo.BlogLike;
import com.nicebody.service.BlogService;
import com.nicebody.util.PageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
        Blog blog = userBlogMapper.queryUserBlogByBlogId(blogId);
        return blog;
    }

    @Override
    public BlogLike getLikeActive(int blogId, int userId) {
        return userBlogMapper.queryLikeActive(blogId, userId);
    }

    @Override
    public List<Blog> getUserBlogByUserId(int pageIndex, int pageSize, Blog userBlogCondition) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        List<Blog> userBlogList = userBlogMapper.queryUserBlogByUserId(rowIndex, pageSize, userBlogCondition);
        return userBlogList;
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
    public List<Blog> getUserBlogByUserIdOrContentLike(int pageIndex, int pageSize, Blog userBlogCondition) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        List<Blog> userBlogList = userBlogMapper.queryUserBlogByUserIdOrContentLike(rowIndex, pageSize, userBlogCondition);
        return userBlogList;
    }

    @Override
    @Transactional
    public int addUserBlog(Blog userBlog) {
        return userBlogMapper.insertUserBlog(userBlog);
    }

    @Override
    @Transactional
    public int addUserBlogImage(BlogImage blogImage) {
        return userBlogMapper.insertUserBlogImage(blogImage);
    }

    @Override
    @Transactional
    public int addUserBlogActive(BlogLike blogLike) {
        return userBlogMapper.insertUserBlogActive(blogLike);
    }

    @Override
    @Transactional
    public int modifyViewCount(Blog userBlogCondition) {
        return userBlogMapper.updateViewCount(userBlogCondition);
    }

    @Override
    @Transactional
    public int modifyLikeCount(BlogLike blogLike, Blog userBlogCondition) {
        return userBlogMapper.updateLikeCount(blogLike ,userBlogCondition);
    }

    @Override
    public int deleteUserBlogByBlogIdAndUserId(int userId, int blogId) {
        return userBlogMapper.deleteUserBlogByBlogIdAndUserId(userId,blogId);
    }

    @Override
    public int deleteUserBlogImgByBlogId(int blogId) {
        return userBlogMapper.deleteUserBlogImgByBlogId(blogId);
    }

    @Override
    public int deleteBlogLike(int blogId) {
        return userBlogMapper.deleteBlogLike(blogId);
    }
}
