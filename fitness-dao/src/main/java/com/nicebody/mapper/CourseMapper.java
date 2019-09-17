package com.nicebody.mapper;

import com.nicebody.pojo.Course;
import com.nicebody.pojo.CourseLesson;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.HTML;
import java.util.List;


/**
 * @ClassName CourseMapper
 * @Author sensu
 * @Date 2019/9/15 20:01
 **/
@Repository
public interface CourseMapper {
    /*
    *查询课程所有信息
    * */
    List<Course> queryCourseList();

    /*
    * 搜索栏模糊查询
    *
    * */
    List<Course> queryByCourseTitle(String courseTitle);

    /*
    * 根据tag_id查询course信息
    * */
    List<Course> queryCourseByTagId(int tagId);

    /*
     * 根据courseId查询单条详细信息
     * */
    List<CourseLesson> queryByCourseId(int courseId);

    /*
    * 分页查询
    * */
    public List<Course> queryListByPage(int a,int b);

    /*
    *多条件叠加查询
    * */

    public List<Course> queryListCondition(@Param("tagId") int tagId,@Param("condition") int condition);




}
