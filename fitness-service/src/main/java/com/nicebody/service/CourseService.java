package com.nicebody.service;

import com.nicebody.mapper.CourseMapper;
import com.nicebody.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CourseService
 * @Author sensu
 * @Date 2019/9/15 20:06
 **/
public interface CourseService {
    /**
     * 查询所有课程
     * @return
     */
    public List<Course> getCourseList();
}
