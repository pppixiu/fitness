package com.nicebody.service.impl;

import com.nicebody.pojo.Coach;
import com.nicebody.pojo.CoachTag;
import com.nicebody.pojo.Course;
import com.nicebody.service.CoachService;
import com.nicebody.service.CoachTagService;
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

    @Autowired
    private CoachTagService coachTagService;

    @Autowired
    private CoachService coachService;

    @Test
    public void getCourseList(){
        List<Course> courseList = courseService.getCourseList();
        courseList.get(2).getCourseTitle();
        System.out.println(courseList.size());
    }

    /*查询教练分类*/
    @Test
    public void getCoachTagList(){
        List<CoachTag> coachTagsList = coachTagService.getCoachTag();
        System.out.println(coachTagsList.get(2).getTagName());
        System.out.println(coachTagsList.size());
    }

    /*查询全部教练*/
    @Test
    public void getCoachList(){
        List<Coach> coachList = coachService.getCoach();
        System.out.println(coachList.get(1).getTagName());
        System.out.println(coachList.size());
    }

    /*根据分类查询教练*/
    @Test
    public void getCoachByTag(){
        List<Coach> coachList = coachService.getCoachByTag(4);
        System.out.println(coachList.get(0).getUserName());
        System.out.println(coachList.size());
    }
}
