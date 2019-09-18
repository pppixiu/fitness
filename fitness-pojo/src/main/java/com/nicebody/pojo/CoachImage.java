package com.nicebody.pojo;

import java.util.Date;

/**
 * @ClassName CoachImage
 * @Author Hassan
 * %@Date 2019/9/17 11:02
 */
public class CoachImage {
    /** 教练id */
    private Integer coachId;
    /** 教练图片id */
    private Integer imageId;
    /** 图片路径 */
    private String imageUrl;
    /** 图片创建时间 */
    private Date createTime;
    /** 图片修改时间 */
    private Date updateTIme;

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
