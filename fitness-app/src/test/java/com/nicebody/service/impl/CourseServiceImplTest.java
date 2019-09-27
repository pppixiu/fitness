package com.nicebody.service.impl;

import com.nicebody.enums.OrderByEnum;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.CourseLesson;
import com.nicebody.service.CourseService;
import com.nicebody.util.OrderByUtil;
import org.junit.Assert;
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
    public void getCourseListTest(){
        Course courseCondition = new Course();
        courseCondition.setTagId(9);
        courseCondition.setCourseTitle("计划");
        courseCondition.setCourseLevel(2);
        String value = OrderByUtil.convert2String(OrderByEnum.COUNT.getCode());
        List<Course> courseList = courseService.getCourseList(1,5,courseCondition,value);
        System.out.println(courseCondition.getCourseLevel());
        System.out.println(courseCondition.getCourseTitle());
        Assert.assertEquals(1, courseList.size());
        System.out.println(courseList.size());

    }
    @Test
    @Ignore
    public void getByCourseIdTest(){
        int courseId = 438;
        Course course = courseService.getCourseByCourseId(courseId);
        System.out.println(course.getCourseNote());
        System.out.println(course.getCourseLessonList().size());


    }
    @Test
    @Ignore
    public void getByUserIdTest(){
        int userId = 1;
        List<Course> courseList = courseService.getCourseByUserId(userId);
        System.out.println(courseList.size());

    }

    @Test
    @Ignore
    public void getCourseByCoachIdTest(){
        int coachId = 1;
        List<Course> courseList = courseService.getCourseByCoachId(coachId,1,5);
        System.out.println(courseList.size());


    }

    @Test
    public void getUserCourseCountTest(){
        int courseId = 438;
        int userId = 1;
        int count = courseService.getUserCourseCount(userId,courseId);
        System.out.println(count);
    }




}
