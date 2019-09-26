package com.nicebody.util;

import java.util.Random;

/**
 * @ClassName OrderUtil
 * @Author sensu
 * @Date 2019/9/24 14:12
 **/
public class OrderUtil {

    public static synchronized String getUniqueKey() {
        Random random = new Random();

        long time = System.currentTimeMillis();

        int number = random.nextInt(900000) + 100000;

        return String.valueOf(time + number);
    }

    public static synchronized String getProductId() {
        Random random = new Random();

        int number = random.nextInt(900) + 100;

        return String.valueOf("100" + number);
    }

    public static synchronized String getSellerId() {
        Random random = new Random();
        int number = random.nextInt(90) + 10;
        return String.valueOf("100" + number);
    }
}
