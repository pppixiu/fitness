package com.nicebody.service;

import com.nicebody.pojo.UserProfile;

public interface UserService {
    /**
     * 添加用户
     * @param userProfile
     * @return
     */
    int insertUser(UserProfile userProfile);

    /**
     * 通过userId查询user信息
     * @param userId
     * @return
     */
    UserProfile getUserById(int userId);

}
