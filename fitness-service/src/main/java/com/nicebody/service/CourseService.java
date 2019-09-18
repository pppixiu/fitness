package com.nicebody.service;

import com.nicebody.mapper.CourseMapper;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.CourseLesson;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CourseService
 * @Author sensu
 * @Date 2019/9/15 20:06
 **/
public interface CourseService {
    List<Course> getCourseList(@Param("rowIndex") int rowIndex,
                                 @Param("pageSize") int pageSize,
                                 @Param("courseCondition") Course courseCondition,
                                 @Param("orderByCondition") String orderByCondition);

    /*
     * 通过CourseId查询course
     * */
    List<Course> getByCourseId(int courseId);

    /*
     * 通过userId查询course信息
     * */
    List<Course> getByUserId(int userId);



}

