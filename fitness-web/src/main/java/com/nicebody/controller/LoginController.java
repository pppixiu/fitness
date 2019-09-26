package com.nicebody.controller;
import com.nicebody.pojo.PhoneAuth;
import com.nicebody.pojo.UserProfile;
import com.nicebody.service.CodeService;
import com.nicebody.service.LoginService;
import com.nicebody.service.UserService;
import com.nicebody.util.ResultVOUtil;
import com.nicebody.vo.ResultVO;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
      /*  JSONObject jsonObject = codeService.Code(phone);*/
       /* System.out.println(jsonObject);
        //获取验证码的值
        String smsCode = jsonObject.get("smsCode").toString();
        //获取状态码
        String code = jsonObject.get("code").toString();*/
        String smsCode = "2234";
        String code = "0";

        String myphone=null;
        if(code.equals("0")){
            PhoneAuth phoneAuth = new PhoneAuth();
            phoneAuth.setPhoneNumber(phone);
            phoneAuth.setAuthNumber(smsCode);
            PhoneAuth phoneAuth1 = loginService.getAuthNumber(phone);
            if(phoneAuth1 == null){
                loginService.insertPhoneAuth(phoneAuth);
            }else{
                phoneAuth.setUserId(phoneAuth1.getUserId());
                loginService.updatePhoneAuth(phoneAuth);
            }
            resultVO.setCode(Integer.parseInt(code));
            resultVO.setMsg("发送成功");
//            resultVO.setData(jsonObject);
        }
        else{
            resultVO.setCode(Integer.parseInt(code));
            resultVO.setMsg("发送失败");
//            resultVO.setData(jsonObject);
        }
//       return resultVO;
        return ResultVOUtil.success();
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
    public ResultVO judgeAuthNumber(@RequestParam("phone") String phone,
                                    @RequestParam("smsCode") String smsCode,
                                    HttpServletRequest request){
        ResultVO resultVO = new ResultVO();
        //根据手机号获取到数据库验证码
        PhoneAuth phoneAuth = loginService.getAuthNumber(phone);
        String authNumber = phoneAuth.getAuthNumber();
        String myphone = phoneAuth.getPhoneNumber();
        //int userId = phoneAuth.getUserId();
        //System.out.println(userId);
        System.out.println(myphone);
        System.out.println(authNumber);
        //验证码的校验
        if(smsCode.equals(authNumber)){
            UserProfile userProfile = new UserProfile();
            if(myphone.equals(phone) && phoneAuth.getUserId()==null){
                String userName = "nicebody"+RandomStringUtils.randomAlphanumeric(6).toLowerCase();
                System.out.println(userName);
                userProfile.setUserName(userName);
                userService.insertUser(userProfile);
                int userId = userProfile.getUserId();
                System.out.println(userId);
                //把userId加到对象里去
                phoneAuth.setUserId(userId);
            }
            //根据用户id查找用户
            int userId = phoneAuth.getUserId();
            userProfile = userService.getUserById(userId);
            HttpSession session = request.getSession();
            session.setAttribute("userProfile",userProfile);
            System.out.println(session.getAttribute("userProfile"));
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
