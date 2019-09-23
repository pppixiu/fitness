package com.nicebody.util;

import java.io.Serializable;
import java.util.Arrays;

public class WangEditor implements Serializable {

    private Integer errno; // 错误代码， 0表示没有错误。
    private String[] data; //已上传的图片路径

    public WangEditor(){
        super();
    }

    public WangEditor(String[] data){
        super();
        this.errno = 0;
        this.data = data;
    }

    public Integer getError() {
        return errno;
    }

    public void setError(Integer error) {
        this.errno = error;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WangEditor{" +
                "errno=" + errno +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    // wangEditor图片上传返回数据
    public static class ResultUtil{
        // 上传成功
        public static WangEditor success(String[] object) {
            WangEditor result = new WangEditor();
            result.setError(0);
            result.setData(object);
            return result;
        }

        // 上传失败
        public static WangEditor success(){
            return null;
        }
    }

}
