package com.nicebody.pojo;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Coach
 * @Author Hassan
 * %@Date 2019/9/16 21:41
 */
public class Coach {
    private Integer coachId;    //教练ID
    private Integer userId;     //对应用户Id
    private Integer tagId;      //对应标签Id
    private Date createTime;    //教练激活时间
    private Date updateTime;    //教练修改信息时间

    private User user;         //教练对应的用户信息

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
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
}
