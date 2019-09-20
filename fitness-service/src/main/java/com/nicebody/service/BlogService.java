package com.nicebody.service;

import com.nicebody.pojo.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 曹钲
 * @since 2019/09/17 22:15
 *
 */

public interface BlogService {

    /**
     *  按博客ID查询用户博客
     * @return
     */
    public Blog getUserBlogByBlogId(int blogId);

    /**
     *  按用户ID查询用户博客
     * @return
     */
    public List<Blog> getUserBlogByUserId(@Param("rowIndex") int rowIndex,
                                          @Param("pageSize") int pageSize,
                                          @Param("userBlogCondition") Blog userBlogCondition);

    /**
     *  查询用户博客总浏览人数
     * @param
     * @return
     */
    public int getViewCount(@Param("userBlogCondition") Blog userBlogCondition);

    /**
     *  查询用户博客点赞总数
     */
    public int getLikeCount(@Param("userBlogCondition") Blog userBlogCondition);

    /**
     *  通过用户Id查找用户博客
     *  或者通过博客内容模糊查找博客信息
     *  或者查询全部博客
     * @return
     */
    public List<Blog> getUserBlogByUserIdOrContentLike(@Param("rowIndex") int rowIndex,
                                                       @Param("pageSize") int pageSize,
                                                       @Param("userBlogCondition") Blog userBlogCondition);

    /**
     *  用户添加博客
     * @param userBlog
     * @return
     */
    public int addUserBlog(Blog userBlog);

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
