package com.nicebody.enums;

public enum OrderByEnum {
    TIME(0, "时间"),
    COUNT(1, "销量"),
    PRICE(2, "价格");

    private int code;
    private String message;

    OrderByEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
