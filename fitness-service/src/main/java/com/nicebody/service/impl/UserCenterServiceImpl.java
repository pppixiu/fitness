package com.nicebody.service.impl;

import com.nicebody.dto.UserBlogExecution;
import com.nicebody.dto.UserCoachExecution;
import com.nicebody.dto.UserCourseExecution;
import com.nicebody.enums.UserCenterInfoEnum;
import com.nicebody.mapper.BlogMapper;
import com.nicebody.mapper.CoachMapper;
import com.nicebody.mapper.CourseMapper;
import com.nicebody.pojo.Blog;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.Course;
import com.nicebody.service.UserCenterService;
import com.nicebody.util.PageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private BlogMapper blogMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CoachMapper coachMapper;

    @Override
    public UserBlogExecution getUserBlogByUserIdOrContentLike(int pageIndex, int pageSize, Blog userBlogCondition) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        List<Blog> userBlogList = blogMapper.queryUserBlogByUserIdOrContentLike(rowIndex, pageSize, userBlogCondition);
        if (userBlogList == null || userBlogList.size() == 0) {
            return new UserBlogExecution(UserCenterInfoEnum.NO_INFO);
        }
        return new UserBlogExecution(UserCenterInfoEnum.SUCCESS, userBlogList);
    }

    @Override
    public UserCourseExecution getCourseList(int userId) {
        List<Course> courseList = courseMapper.queryCourseByUserId(userId);
        if (courseList == null || courseList.size() == 0) {
            return new UserCourseExecution(UserCenterInfoEnum.NO_INFO);
        }
        return new UserCourseExecution(UserCenterInfoEnum.SUCCESS, courseList);
    }

    public UserCoachExecution getCoachList(int pageIndex, int pageSize, int userId) {
        int rowindex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        List<CoachInfo> coachInfoList = coachMapper.queryCoachInfo(rowindex, pageSize, userId, 0);
        if (coachInfoList == null || coachInfoList.size() == 0) {
            return  new UserCoachExecution(UserCenterInfoEnum.NO_INFO);
        }
        return new UserCoachExecution(UserCenterInfoEnum.SUCCESS, coachInfoList);
    }
}
