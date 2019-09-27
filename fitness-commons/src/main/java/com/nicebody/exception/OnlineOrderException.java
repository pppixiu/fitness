package com.nicebody.exception;

import com.nicebody.enums.OnlineOrderEnum;

/**
 * @ClassName OnlineOrderException
 * @Author sensu
 * @Date 2019/9/25 9:42
 **/
public class OnlineOrderException extends RuntimeException {
    public OnlineOrderException(OnlineOrderEnum onlineOrderEnum) {
        super(onlineOrderEnum.getMsg());
    }
}
