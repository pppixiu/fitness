package com.nicebody.service.impl;

import com.nicebody.mapper.CourseMapper;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.CourseLesson;
import com.nicebody.service.CourseService;
import com.nicebody.util.PageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CourseServiceImpl
 * @Author sensu
 * @Date 2019/9/15 20:15
 **/
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Course> getCourseList(int pageIndex, int pageSize, Course courseCondition, String orderByCondition) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        return courseMapper.queryCourseList(rowIndex,pageSize,courseCondition,orderByCondition);
    }

    @Override
    public Course getCourseByCourseId(int courseId) {
        return courseMapper.queryCourseByCourseId(courseId);
    }

    @Override
    public List<Course> getCourseByUserId(int userId) {
        return courseMapper.queryCourseByUserId(userId);
    }




    @Override
    public List<Course> getCourseByCoachId(int coachId, int rowIndex, int pageSize) {
        return courseMapper.queryCourseByCoachId(coachId,rowIndex,pageSize);
    }
}
