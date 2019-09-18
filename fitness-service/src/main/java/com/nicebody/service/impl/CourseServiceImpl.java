package com.nicebody.service.impl;

import com.nicebody.mapper.CourseMapper;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.CourseLesson;
import com.nicebody.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Course> getCourseList(int rowIndex, int pageSize, Course courseCondition, String orderByCondition) {
        return courseMapper.queryCourseList(rowIndex,pageSize,courseCondition,orderByCondition);

    }

    @Override
    public List<Course> getCourseByCourseId(int courseId) {
        return courseMapper.queryCourseByCourseId(courseId);
    }

    @Override
    public List<Course> getCourseByUserId(int userId) {
        return courseMapper.queryCourseByUserId(userId);
    }
}
