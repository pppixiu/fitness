package com.nicebody.controller;

import com.nicebody.pojo.UserProfile;
import com.nicebody.service.UserService;
import com.nicebody.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName HeaderController
 * @Author Hassan
 * %@Date 2019/9/25 17:01
 */

@Controller
@RequestMapping("/header")
public class HeaderController {
    @Autowired
    private UserService userService;

    @RequestMapping("/sessionInfo")
    @ResponseBody
    public UserProfile getUserinfo(HttpServletRequest request){
        UserProfile userProfile = new UserProfile();
        HttpSession session = request.getSession();
        userProfile = (UserProfile) session.getAttribute("userProfile");

        return userProfile;
    }

    @RequestMapping("/quitUser")
    public void quitUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("userProfile");
    }
}
