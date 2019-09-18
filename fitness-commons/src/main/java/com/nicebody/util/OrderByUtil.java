package com.nicebody.util;

/**
 * @ClassName OrderByUtil
 * @Author sensu
 * @Date 2019/9/18 15:19
 **/
public class OrderByUtil {
    public static  String convert2String(int code){
        if(code == 0){
            return "create_time";
        }else if(code == 1){
            return "study_count";
        }else if(code == 2){
            return "course_now_price";
        }
        return "";
    }
}
