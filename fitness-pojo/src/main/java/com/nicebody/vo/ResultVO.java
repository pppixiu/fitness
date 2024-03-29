package com.nicebody.vo;

public class ResultVO <T>{

    /** 错误码*/
    private Integer code;
    /** 提示信息*/
    private String msg;
    /** 返回的具体内容*/
    private T data;
    private String isNo;

    public String getIsNo() {
        return isNo;
    }

    public void setIsNo(String isNo) {
        this.isNo = isNo;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
