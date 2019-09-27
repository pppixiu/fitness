package com.nicebody.dao;

import com.nicebody.enums.OrderByEnum;
import com.nicebody.mapper.CourseMapper;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.CourseLesson;
import com.nicebody.pojo.Tag;
import com.nicebody.util.OrderByUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.locks.Condition;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDaoTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void queryCourseListTest(){
        Course courseCondition = new Course();
        //courseCondition.setTagId(2);
       courseCondition.setCourseLevel(2);
        String value = OrderByUtil.convert2String(OrderByEnum.COUNT.getCode());
        List<Course> courseList =courseMapper.queryCourseList(1, 5, courseCondition,value);
        System.out.println(courseCondition.getCourseLevel());
        Assert.assertEquals(1, courseList.size());
        System.out.println(courseList.size());

    }


    @Test
    @Ignore
    public void queryByCourseId(){
        int courseId = 438;
        Course course = courseMapper.queryCourseByCourseId(courseId);
        System.out.println(course.getCourseNote());
        System.out.println(course.getCourseLessonList().size());

    }

    @Test
    @Ignore
    public void queryByUserId(){
        int userId = 1;
        List<Course> courseList = courseMapper.queryCourseByUserId(userId);
        System.out.println(courseList.size());

    }
    @Test
    @Ignore
    public void queryByCoachIdTest(){
        int coachId = 1;
       List<Course> courseList = courseMapper.queryCourseByCoachId(1,1,5);
        System.out.println(courseList.size());

    }
    @Test
    public void queryUserCourseCountTest(){
        int courseId = 438;
        int userId = 1;
        int count = courseMapper.queryUserCourseCount(userId,courseId);
        System.out.println(count);
    }







}
