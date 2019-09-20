package com.nicebody.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nicebody.pojo.UserProfile;

import java.math.BigDecimal;

/**
 * @ClassName UserBlogVO
 * @Author sensu
 * @Date 2019/9/19 10:08
 **/
public class UserBlogVO {
    @JsonProperty("blogContent")
    private String blogContent;
    @JsonProperty("likeCount")
    private Integer likeCount;
    @JsonProperty("viewCount")
    private Integer viewCount;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("userProfile")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserProfile userProfile;

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
