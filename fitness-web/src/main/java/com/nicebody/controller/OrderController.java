package com.nicebody.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.nicebody.alipay.AlipayBean;
import com.nicebody.pojo.OnlineOrder;
import com.nicebody.service.OnlineOrderService;
import com.nicebody.service.PayService;
import com.nicebody.util.ResultVOUtil;
import com.nicebody.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 订单接口
 *
 * @ClassName OrderController
 * @Author Hassan
 * %@Date 2019/9/23 16:50
 */
@RestController()
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private PayService payService;
    @Autowired
    private OnlineOrderService onlineOrderService;

    /**
     * 阿里支付
     *
     * @return
     * @throws AlipayApiException
     */
    @PostMapping(value = "alipay")
    public String alipay(String outTradeNo, String subject, String totalAmount, String body) throws AlipayApiException {
        System.out.println(outTradeNo + "  " + subject + "  " + totalAmount + "  " + body);
        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(outTradeNo);
        alipayBean.setSubject(subject);
        alipayBean.setTotal_amount(totalAmount);
        alipayBean.setBody(body);
        return payService.aliPay(alipayBean);
    }

    @PostMapping("/createonlineorder")
    public ResultVO createOnlineOrder(OnlineOrder onlineOrder) throws AlipayApiException {
        if (onlineOrder != null) {
            int userId = 1;
            onlineOrder.setUserId(userId);
            String result = null;
            onlineOrderService.createOnlineOrder(onlineOrder);
            if(onlineOrder.getOrderId() != null && onlineOrder.getOrderCode() != null){
                AlipayBean alipayBean = new AlipayBean();
                alipayBean.setOut_trade_no(onlineOrder.getOrderCode());
                alipayBean.setSubject("nicebody");
                alipayBean.setTotal_amount(onlineOrder.getTotalMoney().toString());
                result = payService.aliPay(alipayBean);
            }
             return ResultVOUtil.success(result);
        } else {
            return ResultVOUtil.error(10, "添加失败");
        }
    }
}
