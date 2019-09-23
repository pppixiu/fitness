package com.nicebody.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @ClassName Course
 * @Author sensu
 * @Date 2019/9/15 19:59
 **/
public class Course {
    /** 课程id */
    private Integer courseId;
    /** 教练id */
    private Integer coachId;
    /** 标签id */
    private Integer tagId;
    /** 课程名 */
    private String courseTitle;
    /** 课程介绍 */
    private String courseDesc;
    /** 图片路径 */
    private String imageUrl;
    /** 现价 */
    private BigDecimal courseNowPrice;
    /** 原价 */
    private BigDecimal coursePrePrice;
    /** 课程等级 0初级 1中级 2高级 */
    private Integer courseLevel;
    /** 课程时间 */
    private String courseTime;
    /** 课程提示 */
    private String courseNote;
    /** 学习人数 */
    private Long studyCount;
    /** 创建时间 */
    private Date createTime;
    /** 升级时间 */
    private Date updateTime;
    /** 教练id */
    private UserProfile userProfile;
    /** 章节信息 */
    private List<CourseLesson> courseLessonList;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getCourseNowPrice() {
        return courseNowPrice;
    }

    public void setCourseNowPrice(BigDecimal courseNowPrice) {
        this.courseNowPrice = courseNowPrice;
    }

    public BigDecimal getCoursePrePrice() {
        return coursePrePrice;
    }

    public void setCoursePrePrice(BigDecimal coursePrePrice) {
        this.coursePrePrice = coursePrePrice;
    }

    public Integer getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(Integer courseLevel) {
        this.courseLevel = courseLevel;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseNote() {
        return courseNote;
    }

    public void setCourseNote(String courseNote) {
        this.courseNote = courseNote;
    }

    public Long getStudyCount() {
        return studyCount;
    }

    public void setStudyCount(Long studyCount) {
        this.studyCount = studyCount;
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

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public List<CourseLesson> getCourseLessonList() {
        return courseLessonList;
    }

    public void setCourseLessonList(List<CourseLesson> courseLessonList) {
        this.courseLessonList = courseLessonList;
    }
}
