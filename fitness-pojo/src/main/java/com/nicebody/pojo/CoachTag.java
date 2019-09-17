package com.nicebody.pojo;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

/**
 *@ClassName
 *@Author Hassan
 %@Date
 */
public class CoachTag {
    private Integer tagId; //标签Id
    private String tagName; //标签名
    private Date creatTime; //创建时间
    private Date updateTime; //修改时间

    private User user;           //教练对应的用户信息
    private CoachInfo coachInfo; //教练信息
    private CoachImage coachImage; //获取教练图片

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CoachInfo getCoachInfo() {
        return coachInfo;
    }

    public void setCoachInfo(CoachInfo coachInfo) {
        this.coachInfo = coachInfo;
    }

    public CoachImage getCoachImage() {
        return coachImage;
    }

    public void setCoachImage(CoachImage coachImage) {
        this.coachImage = coachImage;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
