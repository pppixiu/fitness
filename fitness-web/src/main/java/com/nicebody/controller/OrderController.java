package com.nicebody.controller;

import com.alibaba.fastjson.JSONObject;
import com.nicebody.aliPay.Alipay;
import com.alipay.api.AlipayApiException;
import com.nicebody.alipay.AlipayBean;
import com.nicebody.dto.AliReturnDTO;
import com.nicebody.interceptor.LoginRequired;
import com.nicebody.pojo.OnlineOrder;
import com.nicebody.pojo.UserProfile;
import com.nicebody.service.OnlineOrderService;
import com.nicebody.service.PayService;
import com.nicebody.util.ResultVOUtil;
import com.nicebody.vo.ResultVO;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 订单接口
 *
 * @ClassName OrderController
 * @Author Hassan
 * %@Date 2019/9/23 16:50
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private PayService payService;
    @Autowired
    private OnlineOrderService onlineOrderService;
    @Autowired
    private Alipay alipay;

    /**
     * 阿里支付
     *
     * @return
     * @throws AlipayApiException
     */
    @PostMapping(value = "alipay")
    @ResponseBody
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
    @LoginRequired
    @ResponseBody
    public String createOnlineOrder(OnlineOrder onlineOrder, HttpServletRequest request) throws AlipayApiException {
        if (onlineOrder != null) {
            UserProfile userProfile = (UserProfile) request.getSession().getAttribute("userprofile");
            int userId = userProfile.getUserId();
            onlineOrder.setUserId(userId);
            String result = null;
            onlineOrderService.createOnlineOrder(onlineOrder);
            if (onlineOrder.getOrderId() != null && onlineOrder.getOrderCode() != null) {
                AlipayBean alipayBean = new AlipayBean();
                alipayBean.setOut_trade_no(onlineOrder.getOrderCode());
                alipayBean.setSubject("nicebody");
                alipayBean.setTotal_amount(onlineOrder.getTotalMoney().toString());
                result = payService.aliPay(alipayBean);
            }
            return result;
        } else {
            return "index";
        }
    }

    @RequestMapping(value = "/alipayreturnpost")
    @ResponseBody
    public String returnPay(HttpServletResponse response, AliReturnDTO returnPay, HttpServletRequest request)
            throws IOException {
        response.setContentType("type=text/html;charset=UTF-8");
        if (!alipay.checkSign(request)) {
//            response.getWriter().write("failture");
//            return;
        }
        if (returnPay == null) {
//            response.getWriter().write("success");
//            return;
            return "success";
        }
        if (returnPay.getTrade_status().equals("TRADE_SUCCESS")) {
//            tbPaymentRecordsService.aliPaySuccess(returnPay);
        }
//        response.getWriter().write("success");
        return "success";
    }

    @RequestMapping(value = "/alipayreturnget", method = {RequestMethod.GET})
    public String returnPayGet(HttpServletResponse response, AliReturnDTO returnPay, HttpServletRequest request)
            throws IOException {
        if (!alipay.checkSign(request)) {
            return "redirect:index";
        }
        if (returnPay == null) {
            return "redirect:index";
        }
        writeCookie(response, "paysuc", "success");
        onlineOrderService.updateOnlineOrder(returnPay.getOut_trade_no(), 1);
        return "redirect:/index";
    }

    public static void writeCookie(HttpServletResponse response, String cookieName,String value){
        Cookie cookie = new Cookie(cookieName,value);
        cookie.setPath("/");
        cookie.setMaxAge(500);
        response.addCookie(cookie);
    }

}
