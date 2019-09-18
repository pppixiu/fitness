package com.nicebody.mapper;

import com.nicebody.pojo.UserBlog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 曹钲
 * @since 2019/09/16 20:43
 */

/**
 * 用户博客
 */
@Repository
public interface UserBlogMapper {

    /**
     * 查询所有博客
     *
     * @return
     */
    List<UserBlog> queryUserBlog();

    /**
     * 按博客ID查询用户博客
     *
     * @return
     */
    List<UserBlog> queryUserBlogByBlogId(int blogId);

    /**
     * 按用户ID查询用户其它博客
     *
     * @return
     */
    List<UserBlog> queryUserBlogByUserId(int userId);

    /**
     * 按博客内容模糊查询
     *
     * @param blogContent
     * @return
     */
    List<UserBlog> queryUserBlogByContentLike(String blogContent);

    /**
     * 用户添加博客
     *
     * @param userBlog
     * @return
     */
    int insertUserBlog(UserBlog userBlog);

    /**
     * 按照博客ID和用户ID删除博客
     *
     * @param blogId
     * @return
     */
    int deleteUserBlogByBlogIdAndUserId(@Param("userId") int userId, @Param("blogId") int blogId);

    /**
     * 按照博客ID删除博客照片
     *
     * @param blogId
     * @return
     */
    int deleteUserBlogImgByBlogId(int blogId);
}
