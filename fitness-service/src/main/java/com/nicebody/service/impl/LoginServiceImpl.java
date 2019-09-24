package com.nicebody.service.impl;

import com.nicebody.mapper.LoginMapper;
import com.nicebody.pojo.PhoneAuth;
import com.nicebody.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;


    @Override
    public PhoneAuth getAuthNumber(String phone) {
        return loginMapper.queryAuthNumber(phone);
    }

    @Override
    public int updatePhoneAuth(PhoneAuth phoneAuth) {
        return loginMapper.updatePhoneAuth(phoneAuth);
    }

    @Override
    public int insertPhoneAuth(PhoneAuth phoneAuth) {
        return loginMapper.insertPhoneAuth(phoneAuth);
    }
}
