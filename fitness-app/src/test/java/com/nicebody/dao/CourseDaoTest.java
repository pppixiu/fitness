package com.nicebody.dao;

import com.nicebody.mapper.CourseMapper;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.CourseLesson;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDaoTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void queryCourseListTest(){
        List<Course> courseList =courseMapper.queryCourseList();
        System.out.println(courseList.get(0).getUser().getUserName());
        System.out.println(courseList);
        System.out.println(courseList.size());

    }
    @Test
    @Ignore
    public void queryByCourseTitleTest(){
        String courseTitle="背部";
        List<Course> courseList = courseMapper.queryByCourseTitle(courseTitle);
        System.out.println(courseList.get(0).getUser().getUserName());
        System.out.println(courseList.size());
        System.out.println(courseList);
    }

    @Test
    @Ignore
    public void queryCourseByTagId(){
        int tagId = 2;
        List<Course> courseList = courseMapper.queryCourseByTagId(tagId);
        System.out.println(courseList.get(0).getCoachTag().getTagName());
        System.out.println(courseList.size());

    }

    @Test
    @Ignore
    public void queryByCourseId(){
        int courseId = 438;
        List<CourseLesson> courseLessonList = courseMapper.queryByCourseId(courseId);
        System.out.println(courseLessonList);
        System.out.println(courseLessonList.size());

    }
    @Test
    @Ignore
    public void queryOderByStudyCountTest(){
        List<Course> courseList =courseMapper.queryOderByStudyCount();
        System.out.println(courseList.get(0).getUser().getUserName());
        System.out.println(courseList);
        System.out.println(courseList.size());

    }

    @Test
    @Ignore
    public void queryOderByPriceTest(){
        List<Course> courseList =courseMapper.queryOderByPrice();
        System.out.println(courseList.get(0).getUser().getUserName());
        System.out.println(courseList);
        System.out.println(courseList.size());

    }

    @Test
    @Ignore
    public void queryListByPage(){
        List<Course> courseList = courseMapper.queryListByPage(2,2);
        System.out.println(courseList);
        System.out.println(courseList.size());
    }

    @Test
    public void queryListByConditionTest(){
        List<Course> courseList = courseMapper.queryListCondition(0,2);
        System.out.println(courseList);
        System.out.println(courseList.size());
    }





}
