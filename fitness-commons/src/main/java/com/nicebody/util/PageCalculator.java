package com.nicebody.util;

/**
 * @ClassName PageCalculator
 * @Author sensu
 * @Date 2019/9/9 20:40
 **/
public class PageCalculator {
    /**
     * 根据页码数以及每页数量得到对应的数据库行数
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public static int calculateRowIndex(int pageIndex, int pageSize){
        return (pageIndex > 0) ? (pageIndex - 1) * pageSize : 0;
    }
}
