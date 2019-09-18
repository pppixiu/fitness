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
        courseCondition.setTagId(1);
        String value = OrderByUtil.convert2String(OrderByEnum.TIME.getCode());
        List<Course> courseList =courseMapper.queryCourseList(1, 5, courseCondition, value);
        Assert.assertEquals(2, courseList.size());

    }
//    @Test
//    @Ignore
//    public void queryByCourseTitleTest(){
//        String courseTitle="背部";
//        List<Course> courseList = courseMapper.queryByCourseTitle(courseTitle);
//        System.out.println(courseList.get(0).getUser().getUserName());
//        System.out.println(courseList.size());
//        System.out.println(courseList);
//    }

//   @Test
//    @Ignore
//    public void queryCourseByTagId(){
//        int tagId = 2;
//        List<Course> courseList = courseMapper.queryCourseByTagId(tagId);
//        System.out.println(courseList.get(0).getCoachTag().getTagName());
//        System.out.println(courseList.size());
//
//    }

//    @Test
//    @Ignore
//    public void queryByCourseId(){
//        int courseId = 438;
//        List<CourseLesson> courseLessonList = courseMapper.queryByCourseId(courseId);
//        System.out.println(courseLessonList);
//        System.out.println(courseLessonList.size());
//
//    }
//
//
//    @Test
//    @Ignore
//    public void queryListByPage(){
//        List<Course> courseList = courseMapper.queryListByPage(2,2);
//        System.out.println(courseList);
//        System.out.println(courseList.size());
//    }

//    @Test
//    public void queryListByConditionTest(){
//        List<Course> courseList = courseMapper.queryListCondition(0,2);
//        System.out.println(courseList);
//        System.out.println(courseList.size());
//    }





}
