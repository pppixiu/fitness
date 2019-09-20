package com.nicebody.dto;

import com.nicebody.enums.UserCenterInfoEnum;
import com.nicebody.pojo.UserBlog;

import java.util.List;

/**
 * @ClassName UserBlogExecution
 * @Author sensu
 * @Date 2019/9/20 8:40
 **/
public class UserBlogExecution {
    private String msg;
    private int code;
    UserBlog userBlog;
    List<UserBlog> userBlogList;


    public UserBlogExecution() {
    }

    /** 失败时候的构造函数 */
    public UserBlogExecution(UserCenterInfoEnum userCenterInfoEnum) {
        this.msg = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
    }

    /** 单体文件操作构造函数 */
    public UserBlogExecution(UserCenterInfoEnum userCenterInfoEnum, UserBlog userBlog) {
        this.msg = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
        this.userBlog = userBlog;
    }

    /** 群体查询构造函数 */
    public UserBlogExecution(UserCenterInfoEnum userCenterInfoEnum, List<UserBlog> userBlogList) {
        this.msg = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
        this.userBlogList = userBlogList;
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

    public UserBlog getUserBlog() {
        return userBlog;
    }

    public void setUserBlog(UserBlog userBlog) {
        this.userBlog = userBlog;
    }

    public List<UserBlog> getUserBlogList() {
        return userBlogList;
    }

    public void setUserBlogList(List<UserBlog> userBlogList) {
        this.userBlogList = userBlogList;
    }
}
