package com.nicebody.service;

import com.nicebody.pojo.PhoneAuth;

public interface LoginService {
    /**
     * 根据手机号查询验证码
     * @param phone
     * @return
     */
    PhoneAuth getAuthNumber(String phone);

    /**
     * 修改验证码
     * @param phoneAuth
     * @return
     */
    int updatePhoneAuth(PhoneAuth phoneAuth);

    /**
     * 添加手机号验证码信息
     * @param phoneAuth
     * @return
     */
    int insertPhoneAuth(PhoneAuth phoneAuth);


}
