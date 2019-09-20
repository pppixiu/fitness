package com.nicebody.enums;

/**
 * @ClassName UserCenterInfoEnum
 * 个人中心查询状态的枚举类
 * @Author sensu
 * @Date 2019/9/19 19:39
 **/
public enum UserCenterInfoEnum {
    SUCCESS(0, "成功"),
    NO_INFO(1, "查询为空"),
    ERROR(2, "查询失败");

    private int state;
    private String stateInfo;

    UserCenterInfoEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
