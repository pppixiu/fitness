package com.nicebody.controller;

import com.nicebody.pojo.Course;
import com.nicebody.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CourseController
 * @Author sensu
 * @Date 2019/9/15 20:24
 **/
@RestController
@RequestMapping("/course")
public class CourseController {
//    @Autowired
//    private CourseService courseService;
//
//    @GetMapping("/listcourses")
//    public Map<String, Object> listCourse(){
//        Map<String, Object> map = new HashMap<>();
//        List<Course> courseList = courseService.getCourseList();
//        map.put("success", true);
//        map.put("courses", courseList);
//        return map;
//    }
}
