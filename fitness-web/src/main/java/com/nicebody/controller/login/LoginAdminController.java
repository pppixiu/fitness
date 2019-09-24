package com.nicebody.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginAdminController {

    @RequestMapping("login")
    public String course(){
        return "login";
    }
}
