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
    public List<Course> getCourseList() {
        return courseMapper.queryCourseList();
    }

    @Override
    public List<Course> getByCourseTitle(String courseTitle) {
        return courseMapper.queryByCourseTitle(courseTitle);
    }

    @Override
    public List<Course> getCourseByTagId(int tagId) {
        return courseMapper.queryCourseByTagId(tagId);
    }

    @Override
    public List<CourseLesson> getByCourseId(int courseId) {
        return courseMapper.queryByCourseId(courseId);
    }

    @Override
    public List<Course> getByOderByStudyCount() {
        return courseMapper.queryOderByStudyCount();
    }

    @Override
    public List<Course> getOderByPrice() {
        return courseMapper.queryOderByPrice();
    }

    @Override
    public List<Course> getListByPage(int a, int b) {
        return courseMapper.queryListByPage(a,b);
    }


}
