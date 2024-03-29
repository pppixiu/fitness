package com.nicebody.mapper;

import com.nicebody.pojo.Blog;
import com.nicebody.pojo.BlogImage;
import com.nicebody.pojo.BlogLike;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author 曹钲
 * @since 2019/09/16 20:43
 */

/**
 * 用户博客
 */
@Repository
public interface BlogMapper {

    /**
     * 按博客ID查询用户博客
     *
     * @return
     */
    Blog queryUserBlogByBlogId(int blogId);

    /**
     *  通过博客ID和用户ID
     *  查询博客点赞状态
     * @param blogId
     * @param userId
     * @return
     */
    String queryLikeActive(@Param("blogId") int blogId,@Param("userId") int userId);

    /**
     *  按用户Id查新用户博客
     * @param
     * @return
     */
    List<Blog> queryUserBlogByUserId(@Param("rowIndex") int rowIndex,
                                     @Param("pageSize") int pageSize,
                                     @Param("userBlogCondition") Blog userBlogCondition);

    /**
     *  查询浏览人数
     * @param
     * @return
     */
    int queryViewCount(@Param("userBlogCondition") Blog userBlogCondition);

    /**
     *  查询点赞次数
     * @param
     * @return
     */
    int queryLikeCount(@Param("userBlogCondition") Blog userBlogCondition);

    /**
     *  通过用户Id查找用户博客
     *  或者通过博客内容模糊查找博客信息
     *  或者查询全部博客
     * @param userBlogCondition
     * @return
     */
    List<Blog> queryUserBlogByUserIdOrContentLike(@Param("rowIndex") int rowIndex,
                                                  @Param("pageSize") int pageSize,
                                                  @Param("userBlogCondition") Blog userBlogCondition);


    /**
     * 用户添加博客
     *
     * @param userBlog
     * @return
     */
    int insertUserBlog(Blog userBlog);

    /**
     *  添加博客图片信息
     * @param blogImage
     * @return
     */
    int insertUserBlogImage(BlogImage blogImage);

    /**
     *  添加用户点赞状态
     * @return
     */
    int insertUserBlogActive(@Param("blogId") int blogId, @Param("userId") int userId);

    /**
     *  按照博客Id更新浏览数
     * @param
     * @return
     */
    int updateViewCount(@Param("userBlogCondition") Blog userBlogCondition);

    /**
     *  根据用户博客点赞状态
     *  更新点赞数
     * @return
     */
    int updateLikeCount(@Param("blogId") int blogId,@Param("likeJudge") int likeJudge);

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

    /**
     *  按照博客Id删除博客点赞
     * @param blogId
     * @return
     */
    int deleteBlogLike(@Param("blogId") int blogId, @Param("userId") int userId);

}
