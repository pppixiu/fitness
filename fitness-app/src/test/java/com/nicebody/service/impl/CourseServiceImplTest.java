package com.nicebody.service.impl;

import com.nicebody.pojo.Course;
import com.nicebody.pojo.CourseLesson;
import com.nicebody.service.CourseService;
import org.junit.Ignore;
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
    @Ignore
    public void getCourseList(){
        List<Course> courseList = courseService.getCourseList();
        System.out.println(courseList.size());
    }
    @Test
    @Ignore
    public void getByCourseTitleTest(){
        String courseTitle="背部";
        List<Course> courseList = courseService.getByCourseTitle(courseTitle);
        System.out.println(courseList);
        System.out.println(courseList.size());
    }

    @Test
    @Ignore
    public void getCourseByTagId(){
        int tagId = 2;
        List<Course> courseList = courseService.getCourseByTagId(tagId);
        System.out.println(courseList);
        System.out.println(courseList.size());

    }

    @Test
    @Ignore
    public void getByCourseId(){
        int courseId = 438;
        List<CourseLesson> courseLessonList = courseService.getByCourseId(courseId);
        System.out.println(courseLessonList);
        System.out.println(courseLessonList.size());
    }

    @Test
    @Ignore
    public void getListByPage(){
        List<Course> courseList = courseService.getListByPage(2,2);
        System.out.println(courseList);
        System.out.println(courseList.size());
    }

    @Test
    public void getListByConditionTest(){
        List<Course> courseList = courseService.getListCondition(0,1);
        System.out.println(courseList);
        System.out.println(courseList.size());
    }


}
