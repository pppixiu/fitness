package com.nicebody.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName OnlineOrder
 * @Author sensu
 * @Date 2019/9/24 14:33
 **/
public class OnlineOrder {
    /** 订单id */
    private Integer orderId;
    /** 用户id */
    private Integer userId;
    /** 教练id */
    private Integer coachId;
    /** 订单号 */
    private String orderCode;
    /** 持续时间 */
    private Integer persistTime;
    /** 订单状态  0未支付1已支付 */
    private Integer orderStatus;
    /** 总金额 */
    private BigDecimal totalMoney;
    /** 时间段 */
    private String timeBucket;
    /** 开始时间 */
    private Date startTime;
    /** 结束时间 */
    private Date endTime;
    /** 创建时间 */
    private Date createTime;
    /** 修改时间 */
    private Date updateTimme;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getPersistTime() {
        return persistTime;
    }

    public void setPersistTime(Integer persistTime) {
        this.persistTime = persistTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getTimeBucket() {
        return timeBucket;
    }

    public void setTimeBucket(String timeBucket) {
        this.timeBucket = timeBucket;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTimme() {
        return updateTimme;
    }

    public void setUpdateTimme(Date updateTimme) {
        this.updateTimme = updateTimme;
    }
}
