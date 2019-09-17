package com.nicebody.pojo;

/**
 * @ClassName CoachInfo
 * @Author Hassan
 * %@Date 2019/9/17 10:59
 */
public class CoachInfo {
    private Integer coachId;  //教练Id
    private Integer userId;   //用户Id
    private String coachDesc; //用户简介
    private String recommendCode; //教练推荐码

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCoachDesc() {
        return coachDesc;
    }

    public void setCoachDesc(String coachDesc) {
        this.coachDesc = coachDesc;
    }

    public String getRecommendCode() {
        return recommendCode;
    }

    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode;
    }
}
