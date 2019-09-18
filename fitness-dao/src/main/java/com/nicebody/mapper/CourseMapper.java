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
    /**
     * 查询课程所有信息
     * 支持 标签（tag） 难度（level） 名称（title）（模糊查询） 过滤
     * 通过 时间 人数 价格
     *
     * @return
     */
    List<Course> queryCourseList(@Param("rowIndex") int rowIndex,
                                 @Param("pageSize") int pageSize,
                                 @Param("courseCondition") Course courseCondition,
                                 @Param("orderByCondition") String orderByCondition);


    /**
     * 通过CourseId查询course
     * @param courseId
     * @return
     */
    List<Course> queryCourseByCourseId(int courseId);

    /**
     * 通过userId查询course信息
     * @param userId
     * @return
     */
    List<Course> queryCourseByUserId(int userId);




}
