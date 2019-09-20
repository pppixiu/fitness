package com.nicebody.service.impl;

import com.nicebody.mapper.CourseMapper;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.CourseLesson;
import com.nicebody.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public List<Course> getCourseList(int rowIndex, int pageSize, Course courseCondition, String orderByCondition) {
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        PageBean<Course> pageBean = new PageBean<Course>();
//
//        //封装当前页数
//        pageBean.setCurrPage(rowIndex);
//
//        //每页显示的数据
//        pageBean.setPageSize(pageSize);
//
//        //封装总记录数
//        int totalCount = courseMapper.selectCount();
//        pageBean.setTotalCount(totalCount);
//
//        //封装总页数
//        double tc = totalCount;
//        Double num = Math.ceil(tc / pageSize);//向上取整
//        pageBean.setTotalPage(num.intValue());
//
//        map.put("start", (rowIndex - 1) * pageSize);
//        map.put("size", pageBean.getPageSize());
//        //封装每页显示的数据
//        PageBean<Course> lists = courseMapper.queryCourseList((rowIndex - 1) * pageSize, pageBean.getPageSize(),courseCondition,orderByCondition);
//        pageBean.setLists(lists);
//
//        return pageBean;
        return courseMapper.queryCourseList(rowIndex,pageSize,courseCondition,orderByCondition);
    }

    @Override
    public Course getCourseByCourseId(int courseId) {
        return courseMapper.queryCourseByCourseId(courseId);
    }

    @Override
    public List<Course> getCourseByUserId(int userId) {
        return courseMapper.queryCourseByUserId(userId);
    }


    @Override
    public int selectCount() {
        return 0;
    }

    @Override
    public List<Course> getCourseByCoachId(int coachId, int rowIndex, int pageSize) {
        return courseMapper.queryCourseByCoachId(coachId,rowIndex,pageSize);
    }
}
