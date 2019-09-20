package com.nicebody.dto;

/**
 * @author 曹钲
 * @since 2019/09/20 16:51
 *
 *  返回七牛云的结果集
 */
public class QiNiuPutRet {
    public String key;
    public String hash;
    public String bucket;
    public int width;
    public int height;
    public int age;

    @Override
    public String toString() {
        return "QiNiuPutRet{" +
                "key='" + key + '\'' +
                ", hash='" + hash + '\'' +
                ", bucket='" + bucket + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", age=" + age +
                '}';
    }
}
