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
//    @Autowired
//    private CourseMapper courseMapper;
//
//    @Override
//    public List<Course> getCourseList(int indexRow, int pageSize, Course courseCondition, String orderByCondition) {
//        return courseMapper.queryCourseList(indexRow, pageSize, courseCondition, orderByCondition);
//    }
//
//    @Override
//    public List<Course> getByCourseTitle(String courseTitle) {
//        return courseMapper.queryByCourseTitle(courseTitle);
//    }
//
//    @Override
//    public List<Course> getCourseByTagId(int tagId) {
//        return courseMapper.queryCourseByTagId(tagId);
//    }
//
//    @Override
//    public List<CourseLesson> getByCourseId(int courseId) {
//        return courseMapper.queryByCourseId(courseId);
//    }
//
//    @Override
//    public List<Course> getListByPage(int a, int b) {
//        return courseMapper.queryListByPage(a,b);
//    }
//
//    @Override
//    public List<Course> getListCondition(int tagId, int condition) {
//        return null;
//    }

//    @Override
//    public List<Course> getListCondition(int tagId, int condition) {
//        return courseMapper.queryListCondition(tagId,condition);
//    }


}
