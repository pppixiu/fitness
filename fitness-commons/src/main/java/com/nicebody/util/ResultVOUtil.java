package com.nicebody.util;


import com.nicebody.enums.UserCenterInfoEnum;
import com.nicebody.vo.ResultVO;


/**
 * @ClassName UserController
 * @Author sensu
 * @Date 2019/9/19 9:54
 **/
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(message);
        return resultVO;
    }

    public static ResultVO none(UserCenterInfoEnum userCenterInfoEnum){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(userCenterInfoEnum.getState());
        resultVO.setMsg(userCenterInfoEnum.getStateInfo());
        return resultVO;
    }

}
