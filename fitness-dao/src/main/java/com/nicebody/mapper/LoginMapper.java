package com.nicebody.mapper;

import com.nicebody.pojo.PhoneAuth;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    /**
     * 根据电话号码查询短信验证码
     * @param phone
     * @return
     */
    PhoneAuth queryAuthNumber(String phone);

    /**
     * 插入一条PhoneAuth数据
     * @param phoneAuth
     * @return
     */
    int insertPhoneAuth(PhoneAuth phoneAuth);

    /**
     * 修改验证码
     * @param phoneAuth
     * @return
     */
    int updatePhoneAuth(PhoneAuth phoneAuth);
}
