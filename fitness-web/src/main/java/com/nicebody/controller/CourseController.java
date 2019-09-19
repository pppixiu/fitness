package com.nicebody.controller;

import com.nicebody.enums.OrderByEnum;
import com.nicebody.pojo.Course;
import com.nicebody.service.CourseService;
import com.nicebody.util.OrderByUtil;
import com.nicebody.vo.CourseVO;
import com.nicebody.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
        //查询所有的course
        List<Course> courseList = courseService.getCourseList(1,5,null,null);
        List<CourseVO> courseVOList = new ArrayList<>();
        for(Course course:courseList){
            CourseVO courseVO = new CourseVO();
            courseVO.setCourseTitle(course.getCourseTitle());
            courseVO.setCourseDesc(course.getCourseDesc());
            courseVO.setImageUrl(course.getImageUrl());
            courseVO.setCourseNowPrice(course.getCourseNowPrice());
            courseVO.setCoursePrePrice(course.getCoursePrePrice());
            courseVO.setCourseLevel(course.getCourseLevel());
            courseVO.setStudyCount(course.getStudyCount());
            courseVOList.add(courseVO);
        }
        ResultVO resultVO = new ResultVO();
        resultVO.setData(courseVOList);
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        return resultVO;


    }
}
