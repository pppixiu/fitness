package com.nicebody.mapper;

import com.nicebody.pojo.UserProfile;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 添加用户
     * @param userProfile
     * @return
     */
    int insertUser(UserProfile userProfile);

    UserProfile queryUserById(Integer userId);

}
