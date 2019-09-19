package com.nicebody.service;

import com.nicebody.pojo.UserBlog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 曹钲
 * @since 2019/09/17 22:15
 *
 */

public interface UserBlogService {

    /**
     *  按博客ID查询用户博客
     * @return
     */
    public UserBlog getUserBlogByBlogId(int blogId);

    /**
     *  通过用户Id查找用户博客
     *  或者通过博客内容模糊查找博客信息
     *  或者查询全部博客
     * @return
     */
    public List<UserBlog> getUserBlogByUserIdOrContentLike(@Param("rowIndex") int rowIndex,
                                                           @Param("pageSize") int pageSize,
                                                           @Param("userBlogCondition") UserBlog userBlogCondition);

    /**
     *  用户添加博客
     * @param userBlog
     * @return
     */
    public int addUserBlog(UserBlog userBlog);

    /**
     *  按照博客ID和用户ID删除博客
     * @param blogId
     * @return
     */
    public int deleteUserBlogByBlogIdAndUserId(@Param("userId") int userId, @Param("blogId")int blogId);

    /**
     *  按照博客ID删除博客照片
     * @param blogId
     * @return
     */
    public int deleteUserBlogImgByBlogId(int blogId);
}
