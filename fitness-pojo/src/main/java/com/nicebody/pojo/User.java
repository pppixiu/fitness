package com.nicebody.pojo;

import java.util.Date;

/**
 * @ClassName User
 * @Author Hassan
 * %@Date 2019/9/17 10:51
 */
public class User {
    private Integer userId;     //用户Id
    private String userName;    //用户姓名
    private Integer userGender; //性别
    private Integer isCoach;    //是否是教练身份
    private Integer userIntegral; //用户积分
    private Integer userHeight;   //用户身高
    private Integer userWeight;  //用户体重
    private Integer userBirthday; //用户生日
    private Date createTime; //用户创建时间
    private Date updateTime; //用户修改时间
    private String userImageUrl; // 用户头像

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }
}
