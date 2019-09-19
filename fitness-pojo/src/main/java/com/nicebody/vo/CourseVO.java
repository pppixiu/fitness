package com.nicebody.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nicebody.pojo.UserProfile;
import jdk.nashorn.internal.objects.annotations.Property;

import java.math.BigDecimal;

/**
 * 课程VO
 * Create by cx
 * 2019-09-19 7:45
 */
public class CourseVO {

    @JsonProperty("title")
    private String courseTitle;
    @JsonProperty("desc")
    private String courseDesc;
    @JsonProperty("url")
    private String imageUrl;
    @JsonProperty("nowprice")
    private BigDecimal courseNowPrice;
    @JsonProperty("preprice")
    private BigDecimal coursePrePrice;
    @JsonProperty("level")
    private int courseLevel;
    @JsonProperty("count")
    private Long studyCount;

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

    public int getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(int courseLevel) {
        this.courseLevel = courseLevel;
    }

    public Long getStudyCount() {
        return studyCount;
    }

    public void setStudyCount(Long studyCount) {
        this.studyCount = studyCount;
    }
}
