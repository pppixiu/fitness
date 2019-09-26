package com.nicebody.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nicebody.pojo.CoachImage;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.Blog;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName CoachInfoVO
 * @Author Hassan
 * %@Date 2019/9/19 18:29
 */
public class CoachInfoVO {
    @JsonProperty("userid")
    private Integer userId;

    @JsonProperty("coachname")
    private String coachName;

    @JsonProperty("coachdesc")
    private String coachDesc;

    @JsonProperty("price")
    private BigDecimal coachPrice;

    @JsonProperty("coachurl")
    private String coachUrl;

    @JsonProperty("count")
    private Integer likeCount;

    @JsonProperty("judge")
    private Integer likeJudge;

    public Integer getLikeJudge() {
        return likeJudge;
    }

    public void setLikeJudge(Integer likeJudge) {
        this.likeJudge = likeJudge;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getCoachDesc() {
        return coachDesc;
    }

    public void setCoachDesc(String coachDesc) {
        this.coachDesc = coachDesc;
    }

    public BigDecimal getCoachPrice() {
        return coachPrice;
    }

    public void setCoachPrice(BigDecimal coachPrice) {
        this.coachPrice = coachPrice;
    }

    public String getCoachUrl() {
        return coachUrl;
    }

    public void setCoachUrl(String coachUrl) {
        this.coachUrl = coachUrl;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}
