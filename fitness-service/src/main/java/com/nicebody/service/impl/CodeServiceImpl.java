package com.nicebody.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.nicebody.service.CodeService;
import com.nicebody.util.CodeUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public JSONObject Code(String phone) {
        JSONObject jsonObject=new JSONObject();
        //获取四位随机码
        Random random = new Random();
        String smsCode="";
        for (int i=0;i<4;i++){
            smsCode+=random.nextInt(10);
        }

        Map<String,String> map = new HashMap<>();
        map.put("phone", phone);
        map.put("smsCode", smsCode);
        rabbitTemplate.convertAndSend("exchange-rabbit-monitor", map);
        jsonObject.put("smsCode",smsCode);

//将发送结果转为json对象
//        try {
//           jsonObject = JSONObject.parseObject(CodeUtil.sendSms(CodeUtil.APIKEY,CodeUtil.TEMPLATE+smsCode+CodeUtil.T_LASTCODE,phone));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return jsonObject;
    }
}
