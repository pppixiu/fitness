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
    @Ignore
    public void queryCourseListTest(){
        Course courseCondition = new Course();
        courseCondition.setTagId(2);
        courseCondition.setCourseLevel(0);
        String value = OrderByUtil.convert2String(OrderByEnum.COUNT.getCode());
        List<Course> courseList =courseMapper.queryCourseList(1, 5, courseCondition, value);
        Assert.assertEquals(5, courseList.size());
        System.out.println(courseList.size());

    }


    @Test
    public void queryByCourseId(){
        int courseId = 438;
        List<Course> courseList = courseMapper.queryCourseByCourseId(courseId);
        System.out.println(courseList.size());

    }
    @Test
    public void queryByUserId(){
        int userId = 1;
        List<Course> courseList = courseMapper.queryCourseByUserId(userId);
        System.out.println(courseList.size());

    }







}
