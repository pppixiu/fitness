package com.nicebody.enums;

/**
 * @ClassName CommentEnum
 * @Author sensu
 * @Date 2019/9/23 16:50
 **/
public enum  CommentEnum {
    SUCCESS(1, "成功"),
    FAIL(2, "添加失败");


    private int code;
    private String msg;

    CommentEnum(int code, String msg) {
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
