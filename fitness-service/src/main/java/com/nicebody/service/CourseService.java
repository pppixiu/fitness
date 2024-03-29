package com.nicebody.service;

import com.nicebody.mapper.CourseMapper;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.CourseLesson;
import com.nicebody.pojo.UserCourse;
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
    List<Course> getCourseList(int pageIndex, int pageSize,
                               @Param("courseCondition") Course courseCondition,
                               @Param("orderByCondition") String orderByCondition);

    /*
     * 通过CourseId查询course
     * */
    Course getCourseByCourseId(int courseId);

    /*
     * 通过userId查询course信息
     * */
    List<Course> getCourseByUserId(int userId);
    //查询用户记录总数

    /**
     * 根据coachId查询所有课程信息
     *
     * @param coachId
     * @param rowIndex
     * @param pageSize
     * @return
     */
    List<Course> getCourseByCoachId(int coachId, int rowIndex, int pageSize);


    /**
     * 根据userId,courseId 查询信息
     *
     * @param userId
     * @param courseId
     * @return
     */
    int getUserCourseCount(int userId, int courseId);


    /**
     * 插入用户购买课程记录
     *
     * @param userCourse
     * @return
     */
    int createUserCourse(UserCourse userCourse);


}

