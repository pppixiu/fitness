package com.nicebody.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CourseLessonVO {
    @JsonProperty("lessontitle")
    private String lessonTitle;
    @JsonProperty("lessondesc")
    private String lessonDesc;
    @JsonProperty("lessonurl")
    private String lessonUrl;

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getLessonDesc() {
        return lessonDesc;
    }

    public void setLessonDesc(String lessonDesc) {
        this.lessonDesc = lessonDesc;
    }

    public String getLessonUrl() {
        return lessonUrl;
    }

    public void setLessonUrl(String lessonUrl) {
        this.lessonUrl = lessonUrl;
    }
}
