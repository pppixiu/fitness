package com.nicebody.pojo;

import java.util.Date;

/**
 * @author 曹钲
 * @since 2019/09/16 20:31
 */

/**
 *  用户博客图片
 */
public class UserBlogImage {
    /** 图片ID */
    private Integer imageId;
    /** 博客ID */
    private Integer blogId;
    /** 图片地址 */
    private String imageUrl;
    /** 图片创建时间 */
    private Date createTime;
    /** 图片修改时间 */
    private Date updateTime;

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
}
