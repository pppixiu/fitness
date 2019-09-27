package com.nicebody.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class BlogVo {
    @JsonProperty("blogid")
    private Integer blogId;
    @JsonProperty("blogcontent")
    private String blogContent;
    @JsonProperty("viewcount")
    private Integer viewCount;
    @JsonProperty("likecount")
    private Integer likeCount;
    @JsonProperty("createtime")
    private Date createTime;
    @JsonProperty("updatetime")
    private Date updateTime;
    @JsonProperty("userid")
    private Integer userId;
    @JsonProperty("judge")
    private Integer likeJudge;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLikeJudge() {
        return likeJudge;
    }

    public void setLikeJudge(Integer likeJudge) {
        this.likeJudge = likeJudge;
    }
}
