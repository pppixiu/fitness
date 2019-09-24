package com.nicebody.service;

import com.alibaba.fastjson.JSONObject;

public interface CodeService {

    /*
    * 发送短信验证码
    * */
   JSONObject Code(String phone);

}
