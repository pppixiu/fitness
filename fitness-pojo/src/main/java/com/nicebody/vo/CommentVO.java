package com.nicebody.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * @ClassName CommentVO
 * @Author sensu
 * @Date 2019/9/23 14:07
 **/
public class CommentVO {
    @JsonProperty("id")
    private Integer commentId;
    @JsonProperty("content")
    private String commentContent;
    @JsonProperty("likeCount")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer likeCount;
    @JsonProperty("time")
    private Date createTime;
    @JsonProperty("user")
    private UserProfileVO userProfileVO;
    @JsonProperty("child")
    private List<CommentVO> child;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
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

    public UserProfileVO getUserProfileVO() {
        return userProfileVO;
    }

    public void setUserProfileVO(UserProfileVO userProfileVO) {
        this.userProfileVO = userProfileVO;
    }

    public List<CommentVO> getChild() {
        return child;
    }

    public void setChild(List<CommentVO> child) {
        this.child = child;
    }
}
