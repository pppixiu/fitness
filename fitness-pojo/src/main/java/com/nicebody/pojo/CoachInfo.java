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
    private String coachName; //教练昵称
    private Integer coachPrice; //教练价格

    private CoachImage coachImage; //教练图片
    private UserBlog userBlog; //博客
    private UserBlogImage userBlogImage;//博客图片

    public UserBlog getUserBlog() {
        return userBlog;
    }

    public void setUserBlog(UserBlog userBlog) {
        this.userBlog = userBlog;
    }

    public UserBlogImage getUserBlogImage() {
        return userBlogImage;
    }

    public void setUserBlogImage(UserBlogImage userBlogImage) {
        this.userBlogImage = userBlogImage;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public Integer getCoachPrice() {
        return coachPrice;
    }

    public void setCoachPrice(Integer coachPrice) {
        this.coachPrice = coachPrice;
    }

    public CoachImage getCoachImage() {
        return coachImage;
    }

    public void setCoachImage(CoachImage coachImage) {
        this.coachImage = coachImage;
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
}
