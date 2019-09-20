package com.nicebody.dto;

import com.nicebody.enums.UserCenterInfoEnum;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.Course;

import java.util.List;

/**
 * @ClassName UserCourseExecution
 * @Author sensu
 * @Date 2019/9/20 8:42
 **/
public class UserCourseExecution {
    private String msg;
    private int code;
    Course course;
    List<Course> courseList;


    public UserCourseExecution() {
    }

    /** 失败时候的构造函数 */
    public UserCourseExecution(UserCenterInfoEnum userCenterInfoEnum) {
        this.msg = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
    }

    /** 单体文件操作构造函数 */
    public UserCourseExecution(UserCenterInfoEnum userCenterInfoEnum, Course course) {
        this.msg = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
        this.course = course;
    }

    /** 群体查询构造函数 */
    public UserCourseExecution(UserCenterInfoEnum userCenterInfoEnum, List<Course> courseList) {
        this.msg = userCenterInfoEnum.getStateInfo();
        this.code = userCenterInfoEnum.getState();
        this.courseList = courseList;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
