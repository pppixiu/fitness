package com.nicebody.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @ClassName CoachSearch
 * @Author Hassan
 * %@Date 2019/10/8 08:27
 */
@Document(indexName = "coachsearch", type = "coachsearch", shards = 4, replicas = 0)
public class CoachSearch {
    @Id
    private int id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String name; //教练姓名

    @Field(type = FieldType.Keyword)
    private String tag; // 分类

    @Field(type = FieldType.Text)
    private String desc; // 描述

    @Field(type = FieldType.Integer)
    private int count; // 人气

    @Field(type = FieldType.Text)
    private String url; // 图片地址

    @Field(type = FieldType.Double)
    private Double price; // 价格

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CoachSearch(int id, String name, String tag, String desc, int count, String image, Double price) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.desc = desc;
        this.count = count;
        this.url = image;
        this.price = price;
    }

    public CoachSearch() {
    }

    @Override
    public String toString() {
        return "CoachSearch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", desc='" + desc + '\'' +
                ", count=" + count +
                ", image='" + url + '\'' +
                ", price=" + price +
                '}';
    }
}
