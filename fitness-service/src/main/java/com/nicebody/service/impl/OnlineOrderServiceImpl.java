package com.nicebody.service.impl;

import com.nicebody.dto.CourseOrderDTO;
import com.nicebody.enums.OnlineOrderEnum;
import com.nicebody.enums.OrderStatusEnum;
import com.nicebody.exception.OnlineOrderException;
import com.nicebody.mapper.OnlineOrderMapper;
import com.nicebody.pojo.OnlineCourse;
import com.nicebody.pojo.OnlineOrder;
import com.nicebody.service.OnlineOrderService;
import com.nicebody.util.OrderUtil;
import com.nicebody.vo.OnlineOrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @ClassName OnlineOrderServiceImpl
 * @Author sensu
 * @Date 2019/9/24 16:04
 **/
@Service
public class OnlineOrderServiceImpl implements OnlineOrderService {

    @Autowired
    private OnlineOrderMapper onlineOrderMapper;

    @Override
    public List<OnlineOrderVO> getOnlineOrderList(Integer userId) {
        return onlineOrderMapper.queryOnlineOrderList(userId);
    }

    @Override
    @Transactional
    public OnlineOrder createOnlineOrder(OnlineOrder onlineOrder) {
        if (verifyOnlineOrder(onlineOrder)) {
            onlineOrder.setCreateTime(new Date());
            onlineOrder.setUpdateTime(new Date());
            onlineOrder.setStartTime(new Date());
            onlineOrder.setEndTime(new Date());
            onlineOrder.setOrderCode(OrderUtil.getUniqueKey());
            onlineOrder.setOrderStatus(OrderStatusEnum.WAITING_PAYING.getCode());
            try {
                onlineOrderMapper.insertOnlineOrder(onlineOrder);
                OnlineCourse onlineCourse = new OnlineCourse();
                BeanUtils.copyProperties(onlineOrder, onlineCourse);

                onlineOrderMapper.insertOnlineCourse(onlineCourse);
            } catch (Exception e) {
                throw new OnlineOrderException(OnlineOrderEnum.CREATE_FAILED);
            }

        } else {
            throw new OnlineOrderException(OnlineOrderEnum.CREATE_FAILED);
        }
        return onlineOrder;

    }

    @Override
    public int updateOnlineOrder(String orderCode, Integer orderStatus) {
        return onlineOrderMapper.updateOnlineOrderStatus(orderCode, orderStatus);
    }

    @Override
    public OnlineOrder createCourseOrder(OnlineOrder courseOrder) {
        if (verifyCourseOrder(courseOrder)) {
            courseOrder.setCreateTime(new Date());
            courseOrder.setUpdateTime(new Date());
            courseOrder.setOrderCode(OrderUtil.getUniqueKey());
            courseOrder.setOrderStatus(OrderStatusEnum.WAITING_PAYING.getCode());
            try {
                onlineOrderMapper.insertCourseOrder(courseOrder);
            } catch (Exception e) {
                throw new OnlineOrderException(OnlineOrderEnum.CREATE_FAILED);
            }

        } else {
            throw new OnlineOrderException(OnlineOrderEnum.CREATE_FAILED);
        }
        return courseOrder;
    }

    @Override
    public CourseOrderDTO getCourseOrderId(String orderCode) {
        return onlineOrderMapper.queryOrderByCode(orderCode);
    }

    /**
     * 验证在线订单
     *
     * @param onlineOrder
     * @return
     */
    private boolean verifyOnlineOrder(OnlineOrder onlineOrder) {
        if (onlineOrder.getTimeBucket() == null || "".equals(onlineOrder.getTimeBucket())) {
            return false;
        }
        //TODO  查询用户信息
        if (onlineOrder.getUserId() == null) {
            return false;
        }
        if (onlineOrder.getTotalMoney() == null) {
            return false;
        }
        if (onlineOrder.getCoachId() == null) {
            return false;
        }
        if (onlineOrder.getPersistTime() == null) {
            return false;
        }
        return true;
    }

    /**
     * 验证课程订单
     *
     * @param courseOrder
     * @return
     */
    private boolean verifyCourseOrder(OnlineOrder courseOrder) {
        if (courseOrder.getTotalMoney() == null) {
            return false;
        }
        if (courseOrder.getUserId() == null) {
            return false;
        }
        if (courseOrder.getCourseId() == null) {
            return false;
        }
        return true;
    }
}
