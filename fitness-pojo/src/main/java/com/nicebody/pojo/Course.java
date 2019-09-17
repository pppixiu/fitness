package com.nicebody.pojo;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

/**
 * @ClassName Course
 * @Author sensu
 * @Date 2019/9/15 19:59
 **/
public class Course {
    private Integer courseId;
    private Integer coachId;
    private Integer tagId;
    private String courseTitle;
    private String courseDesc;
    private String imageUrl;
    private String courseNowPrice;
    private String coursePrePrice;
    private String courseLevel;
    private Long studyCount;
    private Date createTime;
    private Date updateTime;
    private  CoachTag coachTag;
    private User user;
    private CourseLesson courseLesson;

    public CourseLesson getCourseLesson() {
        return courseLesson;
    }

    public void setCourseLesson(CourseLesson courseLesson) {
        this.courseLesson = courseLesson;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CoachTag getCoachTag() {
        return coachTag;
    }

    public void setCoachTag(CoachTag coachTag) {
        this.coachTag = coachTag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCourseNowPrice() {
        return courseNowPrice;
    }

    public void setCourseNowPrice(String courseNowPrice) {
        this.courseNowPrice = courseNowPrice;
    }

    public String getCoursePrePrice() {
        return coursePrePrice;
    }

    public void setCoursePrePrice(String coursePrePrice) {
        this.coursePrePrice = coursePrePrice;
    }

    public Long getStudyCount() {
        return studyCount;
    }

    public void setStudyCount(Long studyCount) {
        this.studyCount = studyCount;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", coachId=" + coachId +
                ", tagId=" + tagId +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseDesc='" + courseDesc + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", courseNowPrice='" + courseNowPrice + '\'' +
                ", coursePrePrice='" + coursePrePrice + '\'' +
                ", courseLevel='" + courseLevel + '\'' +
                ", studyCount=" + studyCount +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", coachTag=" + coachTag +
                ", user=" + user +
                ", courseLesson=" + courseLesson +
                '}';
    }
}
