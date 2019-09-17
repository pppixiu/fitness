package com.nicebody.pojo;

public class UserProfile {
    private Integer userId;
    private String userName;

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

    @Override
    public String toString() {
        return "UserProfile{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
