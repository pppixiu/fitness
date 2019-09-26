package com.nicebody.mapper;

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
     * @return
     */
    List<OnlineOrderVO> queryOnlineOrderList(Integer userId);

    /**
     * 生成订单
     * @param onlineOrder
     * @return
     */
    int insertOnlineOrder(@Param("onlineOrder") OnlineOrder onlineOrder);

    /**
     * 插入教练在线课程信息
     * @param onlineCourse
     * @return
     */
    int insertOnlineCourse(@Param("onlineCourse")OnlineCourse onlineCourse);
}