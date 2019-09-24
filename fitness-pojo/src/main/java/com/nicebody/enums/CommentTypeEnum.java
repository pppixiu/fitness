package com.nicebody.enums;

/**
 * @ClassName CommentTypeEnum
 * @Author sensu
 * @Date 2019/9/23 9:55
 **/
public enum CommentTypeEnum {
    COACH(1, "教练"),
    BLOG(2, "博客");


    private int code;
    private String type;

    CommentTypeEnum(int code, String type) {
        this.code = code;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
