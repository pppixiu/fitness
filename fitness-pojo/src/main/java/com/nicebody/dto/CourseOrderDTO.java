package com.nicebody.dto;

/**
 * @ClassName CourseOrderDTO
 * @Author sensu
 * @Date 2019/9/28 11:23
 **/
public class CourseOrderDTO {
    /** 课程Id */
    private Integer courseId;
    /** 用户Id */
    private Integer userId;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
