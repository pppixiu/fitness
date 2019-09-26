package com.nicebody.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @ClassName CoachVO
 * @Author Hassan
 * 教练列表包含内容
 * %@Date 2019/9/19 10:53
 */
public class CoachVO {

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer coachId;

    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String coachName;

    @JsonProperty("count")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer likeCount;

    @JsonProperty("desc")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String coachDesc;

    @JsonProperty("price")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal coachPrice;

    @JsonProperty("imageurl")
    private String coachImageUrl;

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
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

    public String getCoachImageUrl() {
        return coachImageUrl;
    }

    public void setCoachImageUrl(String coachImageUrl) {
        this.coachImageUrl = coachImageUrl;
    }
}
