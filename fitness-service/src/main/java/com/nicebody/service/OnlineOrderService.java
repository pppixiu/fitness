package com.nicebody.service;

import com.nicebody.dto.OnlineOrderDTO;
import com.nicebody.pojo.OnlineOrder;
import com.nicebody.vo.OnlineOrderVO;

import java.util.List;

/**
 * @ClassName OnlineOrderService
 * @Author sensu
 * @Date 2019/9/24 16:02
 **/
public interface OnlineOrderService {

    /**
     * 根据用户id查询用户的所有订单
     * @param userId
     * @return
     */
    List<OnlineOrderVO> getOnlineOrderList(Integer userId);

    /**
     * 创建新订单
     * @param onlineOrder
     * @return
     */
    OnlineOrder createOnlineOrder(OnlineOrder onlineOrder);
}
