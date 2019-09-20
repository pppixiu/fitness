package com.nicebody.dto;

import com.nicebody.enums.UserCenterInfoEnum;
import com.nicebody.pojo.Blog;

import java.util.List;

/**
 * @ClassName UserBlogExecution
 * @Author sensu
 * @Date 2019/9/20 8:40
 **/
public class UserBlogExecution {
    private String msg;
    private int code;
    Blog blog;
    List<Blog> blogList;


    public UserBlogExecution() {
    }

    /** 失败时候的构造函数 */
    public UserBlogExecution(UserCenterInfoEnum userCenterInfoEnum) {
        this.msg = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
    }

    /** 单体文件操作构造函数 */
    public UserBlogExecution(UserCenterInfoEnum userCenterInfoEnum, Blog blog) {
        this.msg = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
        this.blog = blog;
    }

    /** 群体查询构造函数 */
    public UserBlogExecution(UserCenterInfoEnum userCenterInfoEnum, List<Blog> blogList) {
        this.msg = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
        this.blogList = blogList;
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

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}
