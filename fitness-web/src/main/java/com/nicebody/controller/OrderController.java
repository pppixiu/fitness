package com.nicebody.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.nicebody.alipay.AlipayBean;
import com.nicebody.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 订单接口
 * @ClassName OrderController
 * @Author Hassan
 * %@Date 2019/9/23 16:50
 */
@RestController()
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private PayService payService;

    /**
     * 阿里支付
     * @return
     * @throws AlipayApiException
     */
    @PostMapping(value = "alipay")
    public String alipay(String outTradeNo, String subject, String totalAmount, String body) throws AlipayApiException {
        System.out.println(outTradeNo+"  "+subject+"  "+totalAmount+"  "+body);
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(outTradeNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalAmount);
        alipayBean.setBody(body);
        return payService.aliPay(alipayBean);
    }
}
