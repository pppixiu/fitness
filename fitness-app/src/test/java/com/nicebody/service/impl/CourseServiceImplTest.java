package com.nicebody.service.impl;

import com.nicebody.pojo.Course;
import com.nicebody.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName CourseServiceImplTest
 * @Author sensu
 * @Date 2019/9/15 22:26
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseServiceImplTest {
    @Autowired
    private CourseService courseService;

    @Test
    public void getCourseList(){
        List<Course> courseList = courseService.getCourseList();
        System.out.println(courseList.size());
    }
}
