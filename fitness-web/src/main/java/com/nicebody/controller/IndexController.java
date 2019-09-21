package com.nicebody.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName MainPageController
 * @Author sensu
 * @Date 2019/9/20 22:51
 **/
@Controller
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/courselist")
    public void  getIndexCourseList(){

    }

}
