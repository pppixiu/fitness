package com.nicebody.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nicebody.pojo.UserProfile;
import jdk.nashorn.internal.objects.annotations.Property;

import java.math.BigDecimal;
import java.util.List;

/**
 * 课程VO
 * Create by cx
 * 2019-09-19 7:45
 */
public class CourseVO {
    @JsonProperty("id")
    private Integer courseId;
    @JsonProperty("title")
    private String courseTitle;
    @JsonProperty("desc")
    private String courseDesc;
    @JsonProperty("url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imageUrl;
    @JsonProperty("nowprice")
    private BigDecimal courseNowPrice;
    @JsonProperty("preprice")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal coursePrePrice;
    @JsonProperty("level")
    private String courseLevel;
    @JsonProperty("count")
    private Long studyCount;
    @JsonProperty("coursetime")
    private String courseTime;
    @JsonProperty("coursenote")
    private String courseNote;
    @JsonProperty("user")
    private UserProfileVO userProfileVO;
    @JsonProperty("courselesson")
    private List<CourseLessonVO> courseLessonVOList;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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

    public List<CourseLessonVO> getCourseLessonVOList() {
        return courseLessonVOList;
    }

    public void setCourseLessonVOList(List<CourseLessonVO> courseLessonVOList) {
        this.courseLessonVOList = courseLessonVOList;
    }

    public UserProfileVO getUserProfileVO() {
        return userProfileVO;
    }

    public void setUserProfileVO(UserProfileVO userProfileVO) {
        this.userProfileVO = userProfileVO;
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

    public String getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(String courseLevel) {
        this.courseLevel = courseLevel;
    }

    public Long getStudyCount() {
        return studyCount;
    }

    public void setStudyCount(Long studyCount) {
        this.studyCount = studyCount;
    }
}
