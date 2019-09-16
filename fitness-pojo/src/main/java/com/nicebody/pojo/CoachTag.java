package com.nicebody.pojo;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;

public class CoachTag {
    private Integer tag_id; //标签Id
    private String tag_name; //标签名
    private Date creat_time; //创建时间
    private Date update_time; //修改时间

    @Override
    public String toString() {
        return "CoachTag{" +
                "tag_id=" + tag_id +
                ", tag_name='" + tag_name + '\'' +
                ", creat_time=" + creat_time +
                ", update_time=" + update_time +
                '}';
    }

    public Integer getTag_id() {
        return tag_id;
    }

    public void setTag_id(Integer tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
