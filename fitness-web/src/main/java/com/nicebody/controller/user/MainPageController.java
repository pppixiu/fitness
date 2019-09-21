package com.nicebody.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName MainPageController
 * @Author sensu
 * @Date 2019/9/20 22:56
 **/
@Controller
public class MainPageController {
    @GetMapping("/index")
    public String Index(){
        return "index";
    }
}
