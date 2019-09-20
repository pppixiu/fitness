package com.nicebody.service.impl;

import com.nicebody.dto.UserCenterExecution;
import com.nicebody.enums.UserCenterInfoEnum;
import com.nicebody.mapper.CourseMapper;
import com.nicebody.mapper.UserBlogMapper;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.UserBlog;
import com.nicebody.service.UserCenterService;
import com.nicebody.util.PageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserCenterServiceImpl
 * @Author sensu
 * @Date 2019/9/19 19:04
 **/
@Service
public class UserCenterServiceImpl implements UserCenterService {
    @Autowired
    private UserBlogMapper userBlogMapper;
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<UserBlog> getUserBlogByUserIdOrContentLike(int pageIndex, int pageSize, UserBlog userBlogCondition) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        List<UserBlog> userBlogList = userBlogMapper.queryUserBlogByUserIdOrContentLike(rowIndex, pageSize, userBlogCondition);
        return userBlogList;
    }

    @Override
    public List<Course> getCourseList(int pageIndex, int pageSize, int userId) {
        List<Course> courseList = courseMapper.queryCourseByUserId(userId);
        return courseList;
    }
}
