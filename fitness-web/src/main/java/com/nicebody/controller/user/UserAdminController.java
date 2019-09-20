package com.nicebody.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @ClassName UserAdminController
 * @Author sensu
 * @Date 2019/9/19 10:27
 **/
@Controller
@RequestMapping("/user")
public class UserAdminController {

    @RequestMapping("selfblog")
    public String userBlog(){
        return "course";
    }

    @RequestMapping("selfcoach")
    public String userCoach(){
        return "usercoachlike";
    }

    @RequestMapping("selfcourse")
    public String userCourse(){
        return "usercourses";
    }

    @RequestMapping("selforder")
    public String userOrder(){
        return "userorder";
    }


}
