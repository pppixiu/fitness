package com.nicebody.util;

import java.util.Arrays;

public class WangEditor {

    private Integer error; // 错误代码， 0表示没有错误。
    private String[] data; //已上传的图片路径

    public WangEditor(){
        super();
    }

    public WangEditor(String[] data){
        super();
        this.error = 0;
        this.data = data;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
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
                "error=" + error +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
