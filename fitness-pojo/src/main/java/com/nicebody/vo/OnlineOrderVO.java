package com.nicebody.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nicebody.enums.serializer.OnlineOrderStatusSerializer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OrderInfoVO
 * @Author sensu
 * @Date 2019/9/24 14:53
 **/
public class OnlineOrderVO {

    @JsonProperty("id")
    private Integer orderId;
    @JsonProperty("orderCode")
    private String orderCode;
    @JsonProperty("total")
    private BigDecimal totalMoney;
    @JsonProperty("starttime")
    private Date startTime;
    @JsonProperty("endtime")
    private Date endTime;
    @JsonProperty("status")
    @JsonSerialize(using = OnlineOrderStatusSerializer.class)
    private Integer orderStatus;
    @JsonProperty("coach")
    private CoachVO coachVO;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public CoachVO getCoachVO() {
        return coachVO;
    }

    public void setCoachVO(CoachVO coachVO) {
        this.coachVO = coachVO;
    }
}
