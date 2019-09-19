package com.nicebody.dto;

import com.nicebody.enums.UserCenterInfoEnum;

import java.util.List;

/**
 * @ClassName UserCenterExecution
 * @Author sensu
 * @Date 2019/9/19 19:10
 **/
public class UserCenterExecution <T>{
    private String stateInfo;
    private int code;
    T result;
    List<T> resultList;


    public UserCenterExecution() {
    }

    /** 失败时候的构造函数 */
    public UserCenterExecution(UserCenterInfoEnum userCenterInfoEnum) {
        this.stateInfo = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
    }

    /** 单体文件操作构造函数 */
    public UserCenterExecution(UserCenterInfoEnum userCenterInfoEnum, T result) {
        this.stateInfo = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
        this.result = result;
    }

    /** 群体查询构造函数 */
    public UserCenterExecution(UserCenterInfoEnum userCenterInfoEnum, List<T> resultList) {
        this.stateInfo = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
        this.resultList = resultList;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }
}
