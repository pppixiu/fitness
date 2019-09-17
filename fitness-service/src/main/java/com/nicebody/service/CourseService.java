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
    /**
     * 查询所有课程
     * @return
     */
    public List<Course> getCourseList();

    /**
     *根据courseTitle模糊查询课程
     * @return
     */

    public List<Course> getByCourseTitle(String courseTitle);

    /*
    * 根据tag_id查询信息
    * */
    public List<Course> getCourseByTagId(int tagId);

    /*
     * 根据courseId查询单条详细信息
     * */
    List<CourseLesson> getByCourseId(int courseId);


    /*
    * 分页查询
    * */
    public List<Course> getListByPage(int a,int b);

    /*
    * 多条件组合查询
    * */
    public List<Course> getListCondition(@Param("tagId") int tagId, @Param("condition") int condition);







}
