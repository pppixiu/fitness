package com.nicebody.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName CoachInfo
 * @Author Hassan
 * %@Date 2019/9/17 10:59
 */
public class CoachInfo {
    /** 教练Id */
    private Integer coachId;
    /** 用户Id */
    private Integer userId;
    /** 标签Id */
    private Integer tagId;
    /** 用户简介 */
    private String coachDesc;
    /** 教练推荐码 */
    private String recommendCode;
    /** 教练昵称 */
    private String coachName;
    /** 教练价格 */
    private BigDecimal coachPrice;
    /** 教练图片 */
    private String coachImageUrl;
    /** 收藏数 */
    private Integer likeCount;
    /** 图片创建时间 */
    private Date createTime;
    /** 图片修改时间 */
    private Date updateTIme;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

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

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
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

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTIme() {
        return updateTIme;
    }

    public void setUpdateTIme(Date updateTIme) {
        this.updateTIme = updateTIme;
    }
}
