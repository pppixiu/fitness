package com.nicebody.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProfileVO {

    @JsonProperty("username")
    private String userName;

    @JsonProperty("imgurl")
    private String userImageUrl;

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
