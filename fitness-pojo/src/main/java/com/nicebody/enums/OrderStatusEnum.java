package com.nicebody.enums;

/**
 * @ClassName OrderStatusEnum
 * @Author sensu
 * @Date 2019/9/25 9:53
 **/
public enum OrderStatusEnum {
    WAITING_PAYING(0, "等待支付"),
    PAYING_SUCCESS(1, "已支付"),
    CANCEL(2, "已取消");

    private int code;
    private String status;

    OrderStatusEnum(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
