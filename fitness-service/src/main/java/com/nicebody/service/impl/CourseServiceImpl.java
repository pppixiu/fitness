package com.nicebody.service.impl;

import com.nicebody.mapper.CourseMapper;
import com.nicebody.pojo.Course;
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
        return courseMapper.queryCourse();
    }
}
