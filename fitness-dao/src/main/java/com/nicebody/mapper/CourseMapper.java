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
     * 搜索栏模糊查询
     *
     * @param courseTitle
     * @return
     */
    List<Course> queryByCourseTitle(String courseTitle);

    /**
     * 根据tag_id查询course信息
     *
     * @param tagId
     * @return
     */
    List<Course> queryCourseByTagId(int tagId);

    /**
     * 根据courseId查询单条详细信息
     *
     * @param courseId
     * @return
     */
    List<CourseLesson> queryByCourseId(int courseId);

    /**
     * 分页查询
     *
     * @param a
     * @param b
     * @return
     */
    public List<Course> queryListByPage(int a, int b);

    /**
     * 多条件叠加查询
     *
     * @param tagId
     * @param courseCondition
     * @return
     */
    public List<Course> queryListCondition(@Param("tagId") int tagId, @Param("courseCondition") Course courseCondition);


}
