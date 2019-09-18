package com.nicebody.pojo;

import java.util.Date;

/**
 * @ClassName UserProfile
 * @Author Hassan
 * %@Date 2019/9/17 10:51
 */
public class UserProfile {
    /** 用户id */
    private Integer userId;
    /** 用户姓名 */
    private String userName;
    /** 性别 */
    private Integer userGender;
    /** 是否教练0不是1是 */
    private Integer isCoach;
    /** 是否激活0不是1是 */
    private Integer isActive;
    /** 用户积分 */
    private Integer userIntegral;
    /** 用户身高 */
    private Integer userHeight;
    /** 用户体重 */
    private Integer userWeight;
    /** 用户身生日 */
    private Date userBirthday;
    /** 用户头像 */
    private String userImageUrl;
    /** 创建时间 */
    private Date createTime;
    /** 修改时间 */
    private Date updateTime;

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

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
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

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}
