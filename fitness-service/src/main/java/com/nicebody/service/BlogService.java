package com.nicebody.service;

import com.nicebody.pojo.Blog;
import com.nicebody.pojo.BlogImage;
import com.nicebody.pojo.BlogLike;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
     *  根据博客ID和用户ID
     *  判断bloke
     * @param blogId
     * @param userId
     * @return
     */
    public BlogLike getLikeActive(@Param("blogId") int blogId,@Param("userId") int userId);

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
     *  添加博客图片信息
     * @param blogImage
     * @return
     */
    public int addUserBlogImage(BlogImage blogImage);

    /**
     *  添加用户点赞状态
     * @return
     */
    public int addUserBlogActive(@Param("blogLike") BlogLike blogLike);

    /**
     *  按照博客Id更新浏览数
     * @param
     * @return
     */
    public int modifyViewCount(@Param("userBlogCondition") Blog userBlogCondition);

    /**
     *  根据用户博客点赞状态
     *  更新点赞数
     * @param userBlogCondition
     * @return
     */
    public int modifyLikeCount(@Param("blogLike")BlogLike blogLike,
                               @Param("userBlogCondition") Blog userBlogCondition);


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

    /**
     *  按照博客Id删除博客点赞
     * @param blogId
     * @return
     */
    public int deleteBlogLike(int blogId);
}
