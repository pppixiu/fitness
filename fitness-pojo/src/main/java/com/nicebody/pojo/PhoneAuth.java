package com.nicebody.pojo;

import java.util.Date;

public class PhoneAuth {
    /** phone_auth_id */
    private Integer phoneAuthId;
    /** 用户的Id */
    private Integer userId;
    /** 手机号 */
    private String phoneNumber;
    /** 验证码*/
    private String authNumber;
    /** 创建时间 */
    private Date createTime;
    /** 升级时间 */
    private Date updateTime;

    public Integer getPhoneAuthId() {
        return phoneAuthId;
    }

    public void setPhoneAuthId(Integer phoneAuthId) {
        this.phoneAuthId = phoneAuthId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAuthNumber() {
        return authNumber;
    }

    public void setAuthNumber(String authNumber) {
        this.authNumber = authNumber;
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

    @Override
    public String toString() {
        return "PhoneAuth{" +
                "phoneAuthId=" + phoneAuthId +
                ", userId=" + userId +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", authNumber='" + authNumber + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
