package com.nicebody.dto;

import com.nicebody.enums.UserCenterInfoEnum;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.Blog;

import java.util.List;

/**
 * @ClassName UserCoachExecution
 * @Author sensu
 * @Date 2019/9/20 8:43
 **/
public class UserCoachExecution {
    private String msg;
    private int code;
    CoachInfo coachInfo;
    List<CoachInfo> coachInfoList;


    public UserCoachExecution() {
    }

    /** 失败时候的构造函数 */
    public UserCoachExecution(UserCenterInfoEnum userCenterInfoEnum) {
        this.msg = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
    }

    /** 单体文件操作构造函数 */
    public UserCoachExecution(UserCenterInfoEnum userCenterInfoEnum, CoachInfo coachInfo) {
        this.msg = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
        this.coachInfo = coachInfo;
    }

    /** 群体查询构造函数 */
    public UserCoachExecution(UserCenterInfoEnum userCenterInfoEnum, List<CoachInfo> coachInfoList) {
        this.msg = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
        this.coachInfoList = coachInfoList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CoachInfo getCoachInfo() {
        return coachInfo;
    }

    public void setCoachInfo(CoachInfo coachInfo) {
        this.coachInfo = coachInfo;
    }

    public List<CoachInfo> getCoachInfoList() {
        return coachInfoList;
    }

    public void setCoachInfoList(List<CoachInfo> coachInfoList) {
        this.coachInfoList = coachInfoList;
    }
}
