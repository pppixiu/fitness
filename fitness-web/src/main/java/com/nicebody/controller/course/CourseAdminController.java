package com.nicebody.controller.course;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName CourseAdminController
 * @Author cx
 * @Date 2019/9/20 20:46
 **/
@Controller
@RequestMapping("/course")
public class CourseAdminController {
    @RequestMapping("course")
    public String course(){
        return "course";
    }

    @RequestMapping("courseInfo")
    public String courseLesson(){
        return "courseInfo";
    }


}
