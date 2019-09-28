package com.nicebody.service.impl;

import com.nicebody.pojo.OnlineOrder;
import com.nicebody.service.OnlineOrderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @ClassName OnlineOrderServiceTest
 * @Author sensu
 * @Date 2019/9/25 16:25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineOrderServiceTest {

    @Autowired
    private OnlineOrderService onlineOrderService;

    @Test
    public void createOnlineOrder(){
        OnlineOrder onlineOrder = new OnlineOrder();
        onlineOrder.setCoachId(6);
        onlineOrder.setUserId(1);
        onlineOrder.setTimeBucket("1|2|3");
        onlineOrder.setTotalMoney(new BigDecimal(123));
        onlineOrder.setPersistTime(3);

        onlineOrderService.createOnlineOrder(onlineOrder);
        Assert.assertEquals(7, (long)onlineOrder.getOrderId());
    }

    @Test
    public void createCourseOrder(){
        OnlineOrder courseOrder = new OnlineOrder();
        courseOrder.setUserId(1);
        courseOrder.setCourseId(438);
        courseOrder.setTotalMoney(new BigDecimal(300));
        onlineOrderService.createCourseOrder(courseOrder);

        Assert.assertEquals(39, (long)courseOrder.getOrderId());
    }
}
