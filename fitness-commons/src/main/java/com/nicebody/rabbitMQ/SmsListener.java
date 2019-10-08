package com.nicebody.rabbitMQ;

import com.alibaba.fastjson.JSONObject;
import com.nicebody.util.CodeUtil;
import com.nicebody.vo.ResultVO;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

@Component
@RabbitListener(queues = "exchange-rabbit-monitor")
public class SmsListener {

    @RabbitHandler
    public void sendSms(Map<String,String> map){

        JSONObject jsonObject=null;
        try {
            jsonObject = JSONObject.parseObject(CodeUtil.sendSms(CodeUtil.APIKEY,CodeUtil.T_CODE+map.get("smsCode")+CodeUtil.T_LASTCODE,map.get("phone")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取状态码
        String code = jsonObject.get("code").toString();
        if (code != "0") {
            System.out.println("发送失败");
        }

    }
}
