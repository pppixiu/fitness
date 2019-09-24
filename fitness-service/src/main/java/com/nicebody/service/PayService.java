package com.nicebody.service;

import com.alipay.api.AlipayApiException;
import com.nicebody.alipay.AlipayBean;

import java.util.Date;

public interface PayService {
    /**
     * 支付宝支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;
}
