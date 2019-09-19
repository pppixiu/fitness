package com.nicebody.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @ClassName UserBlogVO
 * @Author sensu
 * @Date 2019/9/19 10:08
 **/
public class UserBlogVO {
    @JsonProperty("title")
    private String blogContent;
    @JsonProperty("desc")
    private String likeCount;
    @JsonProperty("url")
    private String viewCount;
    @JsonProperty("imageUrl")
    private String imageUrl;

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
