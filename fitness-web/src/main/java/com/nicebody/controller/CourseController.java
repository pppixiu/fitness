package com.nicebody.controller;

import com.nicebody.enums.OrderByEnum;
import com.nicebody.pojo.Course;
import com.nicebody.service.CourseService;
import com.nicebody.util.OrderByUtil;
import com.nicebody.vo.ResultVO;
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
    @Autowired
    private CourseService courseService;

    @GetMapping("/listcourses")
    public ResultVO listCourse(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;


    }
}
