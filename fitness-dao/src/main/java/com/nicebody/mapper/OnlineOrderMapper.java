package com.nicebody.mapper;

import com.nicebody.dto.CourseOrderDTO;
import com.nicebody.pojo.OnlineCourse;
import com.nicebody.pojo.OnlineOrder;
import com.nicebody.vo.OnlineOrderVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName OnlineCourse
 * @Author sensu
 * @Date 2019/9/24 14:45
 **/
@Repository
public interface OnlineOrderMapper {

    /**
     * 根据userid 查询用户信息
     *
     * @return
     */
    List<OnlineOrderVO> queryOnlineOrderList(Integer userId);

    /**
     * 生成订单
     *
     * @param onlineOrder
     * @return
     */
    int insertOnlineOrder(@Param("onlineOrder") OnlineOrder onlineOrder);

    /**
     * 插入教练在线课程信息
     *
     * @param onlineCourse
     * @return
     */
    int insertOnlineCourse(@Param("onlineCourse") OnlineCourse onlineCourse);

    /**
     * 根据订单号更改订单信息
     *
     * @param orderCode
     * @param orderStatus
     * @return
     */
    int updateOnlineOrderStatus(@Param("orderCode") String orderCode,
                                @Param("orderStatus") Integer orderStatus);

    /**
     * 插入课程订单
     *
     * @param courseOrder
     * @return
     */
    int insertCourseOrder(@Param("courseOrder") OnlineOrder courseOrder);

    /**
     * 根据订单号查询订单信息
     *
     * @param orderCode
     * @return
     */
    CourseOrderDTO queryOrderByCode(@Param("orderCode") String orderCode);
}
