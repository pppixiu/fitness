package com.nicebody.service.impl;

import com.nicebody.mapper.UserMapper;
import com.nicebody.pojo.UserProfile;
import com.nicebody.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(UserProfile userProfile) {
        return userMapper.insertUser(userProfile);
    }
}
