package com.nicebody.dao;

import com.nicebody.mapper.OnlineOrderMapper;
import com.nicebody.pojo.OnlineCourse;
import com.nicebody.pojo.OnlineOrder;
import com.nicebody.vo.OnlineOrderVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OnlineOrderMapperTest
 * @Author sensu
 * @Date 2019/9/24 15:59
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineOrderMapperTest {
    @Autowired
    private OnlineOrderMapper onlineOrderMapper;

    @Test
    public void queryOnlineOrderList(){
        List<OnlineOrderVO> onlineOrderVOList = onlineOrderMapper.queryOnlineOrderList(10);
        Assert.assertEquals(2, onlineOrderVOList.size());
    }

    @Test
    public void insertOnlineOrder(){
        OnlineOrder onlineOrder = new OnlineOrder();
        onlineOrder.setCoachId(5);
        onlineOrder.setUserId(10);
        onlineOrder.setTimeBucket("16|17|18");
        onlineOrder.setCreateTime(new Date());
        onlineOrder.setUpdateTimme(new Date());
        onlineOrder.setStartTime(new Date());
        onlineOrder.setEndTime(new Date());
        onlineOrder.setPersistTime(0);
        onlineOrder.setOrderCode("1125632554");
        onlineOrder.setOrderStatus(0);
        onlineOrder.setTotalMoney(new BigDecimal(0));

        onlineOrderMapper.insertOnlineOrder(onlineOrder);

        Assert.assertEquals(4, (long)onlineOrder.getOrderId());
    }

    @Test
    public void insertOnlineCourse(){
        OnlineCourse onlineCourse = new OnlineCourse();
        onlineCourse.setCoachId(1);
        onlineCourse.setOrderId(1);
        onlineCourse.setCreateTime(new Date());

        onlineOrderMapper.insertOnlineCourse(onlineCourse);
        Assert.assertEquals(3, (long)onlineCourse.getOnlineId());
    }
}
