package com.nicebody.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.nicebody.service.CodeService;
import com.nicebody.util.CodeUtil;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Random;

@Service
public class CodeServiceImpl implements CodeService {

    @Override
    public JSONObject Code(String phone) {
        JSONObject jsonObject=null;
        //获取四位随机码
        Random random = new Random();
        String smsCode="";
        for (int i=0;i<4;i++){
            smsCode+=random.nextInt(10);
        }
//将发送结果转为json对象
        try {
           jsonObject = JSONObject.parseObject(CodeUtil.sendSms(CodeUtil.APIKEY,CodeUtil.T_CODE+smsCode+CodeUtil.T_LASTCODE,phone));
           jsonObject.put("smsCode",smsCode);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
