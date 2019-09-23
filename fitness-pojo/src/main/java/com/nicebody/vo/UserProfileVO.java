package com.nicebody.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProfileVO {

    @JsonProperty("userid")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer userId;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("imgurl")
    private String userImageUrl;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
