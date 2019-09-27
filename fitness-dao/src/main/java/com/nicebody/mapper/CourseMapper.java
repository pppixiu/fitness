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
     * 查询总数
     *
     * @param rowIndex
     * @param pageSize
     * @param courseCondition
     * @param orderByCondition
     * @return
     */
    int selectCount(@Param("rowIndex") int rowIndex,
                    @Param("pageSize") int pageSize,
                    @Param("courseCondition") Course courseCondition,
                    @Param("orderByCondition") String orderByCondition);


    /**
     * 通过CourseId查询course
     *
     * @param courseId
     * @return
     */
    Course queryCourseByCourseId(int courseId);

    /**
     * 通过userId查询course信息
     *
     * @param userId
     * @return
     */
    List<Course> queryCourseByUserId(int userId);
    //查询用户记录总数

    /**
     * 根据coachId查询所有课程信息
     *
     * @param coachId
     * @param rowIndex
     * @param pageSize
     * @return
     */
    List<Course> queryCourseByCoachId(int coachId,int rowIndex,int pageSize);

    /**
     * 根据userId,courseId 查询信息
     * @param userId
     * @param courseId
     * @return
     */
    int queryUserCourseCount(int userId,int courseId);


}
