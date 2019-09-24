package com.nicebody.service;

import com.nicebody.pojo.UserProfile;

public interface UserService {
    /**
     * 添加用户
     * @param userProfile
     * @return
     */
    int insertUser(UserProfile userProfile);

}
