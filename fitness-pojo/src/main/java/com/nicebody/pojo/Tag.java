package com.nicebody.pojo;

import java.util.Date;

/**
 * @ClassName
 * @Author Hassan
 * %@Date
 */
public class Tag {
    /** 标签Id */
    private Integer tagId;
    /** 标签名 */
    private String tagName;
    /** 创建时间 */
    private Date creatTime;
    /** 修改时间 */
    private Date updateTime;


    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
