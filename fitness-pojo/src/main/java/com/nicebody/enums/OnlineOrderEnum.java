package com.nicebody.enums;

/**
 * @ClassName OnlineOrderEnum
 * @Author sensu
 * @Date 2019/9/25 9:44
 **/
public enum  OnlineOrderEnum {
    CREATE_SUCCESS(1, "创建成功"),
    CREATE_FAILED(2, "创建失败");

    private int code;
    private String msg;

    OnlineOrderEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
