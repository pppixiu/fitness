package com.nicebody.pojo;

import java.util.Date;

/**
 * @ClassName Coach
 * @Author Hassan
 * %@Date 2019/9/16 21:41
 */
public class Coach {
    private Integer coachId;    //教练ID
    private Integer userId;     //对应用户Id
    private Date createTime;    //教练激活时间
    private Date updateTime;    //教练修改信息时间
    private String userName;    //教练姓名
    private Integer userGender; //教练性别
    private Integer isCoach;    //教练身份
    private Integer userIntegral; //教练积分
    private Integer userHeight;   //教练身高
    private Integer userWeight;  //教练体重
    private Integer userBirthday; //教练生日
    private String tagName; //教练类别

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserGender() {
        return userGender;
    }

    public void setUserGender(Integer userGender) {
        this.userGender = userGender;
    }

    public Integer getIsCoach() {
        return isCoach;
    }

    public void setIsCoach(Integer isCoach) {
        this.isCoach = isCoach;
    }

    public Integer getUserIntegral() {
        return userIntegral;
    }

    public void setUserIntegral(Integer userIntegral) {
        this.userIntegral = userIntegral;
    }

    public Integer getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(Integer userHeight) {
        this.userHeight = userHeight;
    }

    public Integer getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(Integer userWeight) {
        this.userWeight = userWeight;
    }

    public Integer getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Integer userBirthday) {
        this.userBirthday = userBirthday;
    }
}
