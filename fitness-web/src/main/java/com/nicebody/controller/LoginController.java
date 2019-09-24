package com.nicebody.controller;
import com.alibaba.fastjson.JSONObject;
import com.nicebody.interceptor.LoginRequired;
import com.nicebody.pojo.PhoneAuth;
import com.nicebody.pojo.UserProfile;
import com.nicebody.service.CodeService;
import com.nicebody.service.LoginService;
import com.nicebody.service.UserService;
import com.nicebody.util.ResultVOUtil;
import com.nicebody.vo.ResultVO;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.lang.annotation.*;

import static com.yunpian.sdk.util.HttpUtil.post;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private CodeService codeService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    /**
     * 生成验证码
     * @param phone
     * @return
     */
    @RequestMapping("/code")
    @ResponseBody
    public ResultVO produceAuthNumber(@RequestParam("phone") String phone){
        ResultVO  resultVO = new ResultVO();
        JSONObject jsonObject = codeService.Code(phone);
        System.out.println(jsonObject);
        //获取验证码的值
        String smsCode = jsonObject.get("smsCode").toString();
        //获取状态码
        String code = jsonObject.get("code").toString();
        String myphone=null;
        if(code.equals("0")){
            PhoneAuth phoneAuth = new PhoneAuth();
            phoneAuth.setPhoneNumber(phone);
            phoneAuth.setAuthNumber(smsCode);
            PhoneAuth phoneAuth1 = loginService.getAuthNumber(phone);
            if(phoneAuth1!=null){
                myphone = phoneAuth1.getPhoneNumber();
            }
            if(phone.equals(myphone)){
                loginService.updatePhoneAuth(phoneAuth);
            }else {
                loginService.insertPhoneAuth(phoneAuth);
            }
            resultVO.setCode(Integer.parseInt(code));
            resultVO.setMsg("发送成功");
            resultVO.setData(jsonObject);
        }
        else{
            resultVO.setCode(Integer.parseInt(code));
            resultVO.setMsg("发送失败");
            resultVO.setData(jsonObject);
        }
       return resultVO;
    }

    /**
     * 验证码校验
     * @param phone
     * @param smsCode
     * @param request
     * @return
     */
    @RequestMapping("/judge")
    @ResponseBody
    @LoginRequired
    public ResultVO judgeAuthNumber(@RequestParam("phone") String phone,
                                    @RequestParam("smsCode") String smsCode, HttpServletRequest request){
        ResultVO resultVO = new ResultVO();
        //获取到数据库验证码
        PhoneAuth phoneAuth = loginService.getAuthNumber(phone);
        String authNumber = phoneAuth.getAuthNumber();
        System.out.println(authNumber);
        //验证码的校验
        if(smsCode.equals(authNumber)){
            UserProfile userProfile = new UserProfile();
            String userName = "nicebody"+RandomStringUtils.randomAlphanumeric(6).toLowerCase();
            System.out.println(userName);
            userProfile.setUserName(userName);
            userService.insertUser(userProfile);
            int userId = userProfile.getUserId();
            System.out.println(userId);
            //把userId加到对象里去
            phoneAuth.setUserId(userId);
            HttpSession session = request.getSession();
            session.setAttribute("userId",userId);
            loginService.updatePhoneAuth(phoneAuth);
            resultVO.setCode(0);
            resultVO.setMsg("验证码正确");
        }else {
            resultVO.setCode(1);
            resultVO.setMsg("验证码错误");
        }
        return resultVO;
    }
}
