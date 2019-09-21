package com.nicebody.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/blog")
public class BlogAdminController {
    @RequestMapping("blogindex")
    public String blogIndex(){
        return "blog_index";
    }

    @RequestMapping("blogcomment")
    public String blogComment(){
        return "blog_comment";
    }
}
