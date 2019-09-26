package com.nicebody.pojo;

import java.util.Date;

/**
 * @author 曹钲
 * @since 2019/09/16 20:20
 */

/**
 *  用户博客
 */
public class Blog {
    /** 博客ID */
    private Integer blogId;
    /** 博客内容 */
    private String blogContent;
    /** 博客浏览量 */
    private Integer viewCount;
    /** 博客点赞量 */
    private Integer likeCount;
    /** 博客创造时间 */
    private Date createTime;
    /** 博客修改时间 */
    private Date updateTime;
    /** 博客标题图 */
    //TODO
    private BlogImage userBlogImage;
    /** 用户信息 */
    private UserProfile userProfile;
    /** 判断用户对博客点赞状态*/
    private BlogLike blogLike;
    /** 博客用户ID */
    private Integer userId;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public BlogImage getUserBlogImage() {
        return userBlogImage;
    }

    public void setUserBlogImage(BlogImage userBlogImage) {
        this.userBlogImage = userBlogImage;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public BlogLike getBlogLike() {
        return blogLike;
    }

    public void setBlogLike(BlogLike blogLike) {
        this.blogLike = blogLike;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
