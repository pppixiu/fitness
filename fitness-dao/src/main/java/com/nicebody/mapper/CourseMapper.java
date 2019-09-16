package com.nicebody.mapper;

import com.nicebody.pojo.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName CourseMapper
 * @Author sensu
 * @Date 2019/9/15 20:01
 **/
@Repository
public interface CourseMapper {
    List<Course> queryCourse();
}
