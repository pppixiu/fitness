package com.nicebody.service.impl;

import com.alipay.api.AlipayApiException;
import com.nicebody.alipay.AlipayBean;
import com.nicebody.aliPay.Alipay;
import com.nicebody.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName PayServiceImpl
 * @Author Hassan
 * %@Date 2019/9/23 16:54
 */
@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private Alipay alipay;

    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }
}
