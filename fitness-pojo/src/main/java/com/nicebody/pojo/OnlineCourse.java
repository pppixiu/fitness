package com.nicebody.pojo;

import com.fasterxml.jackson.databind.util.PrimitiveArrayBuilder;

import java.util.Date;

/**
 * @ClassName OnlineCourse
 * @Author sensu
 * @Date 2019/9/25 11:20
 **/
public class OnlineCourse {
    private Integer onlineId;
    private Integer coachId;
    private Integer orderId;
    private Date createTime;

    public Integer getOnlineId() {
        return onlineId;
    }

    public void setOnlineId(Integer onlineId) {
        this.onlineId = onlineId;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
