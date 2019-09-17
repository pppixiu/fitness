package com.nicebody.mapper;

import com.nicebody.pojo.UserBlog;

import java.util.List;

/**
 * @author 曹钲
 * @since 2019/09/16 20:43
 */

/**
 *  用户博客
 */
public interface UserBlogDao {

    /**
     *  查询所有博客
     * @return
     */
    List<UserBlog> queryUserBlog();

    /**
     *  按博客ID查询用户博客
     * @return
     */
    List<UserBlog> queryUserBlogByBlogId();

    /**
     *  按用户ID查询用户其它博客
     * @return
     */
    List<UserBlog> queryUserBlogByUserId();

    /**
     *  用户添加博客
     * @param userBlog
     * @return
     */
    int insertUserBlog(UserBlog userBlog);

    /**
     *  按照博客ID删除博客
     * @param blogId
     * @return
     */
    int deleteUserBlogByBlogId(int blogId);
}
