package com.nicebody.service.impl;

import com.nicebody.dto.UserBlogExecution;
import com.nicebody.dto.UserCoachExecution;
import com.nicebody.dto.UserCourseExecution;
import com.nicebody.enums.UserCenterInfoEnum;
import com.nicebody.mapper.CoachMapper;
import com.nicebody.mapper.CourseMapper;
import com.nicebody.mapper.UserBlogMapper;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.UserBlog;
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
    private UserBlogMapper userBlogMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private CoachMapper coachMapper;

    @Override
    public UserBlogExecution getUserBlogByUserIdOrContentLike(int pageIndex, int pageSize, UserBlog userBlogCondition) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        List<UserBlog> userBlogList = userBlogMapper.queryUserBlogByUserIdOrContentLike(rowIndex, pageSize, userBlogCondition);
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

    public UserCoachExecution getCoachList(int userId) {
        List<CoachInfo> coachInfoList = coachMapper.queryCoachInfo(userId, 0);
        if (coachInfoList == null || coachInfoList.size() == 0) {
            return  new UserCoachExecution(UserCenterInfoEnum.NO_INFO);
        }
        return new UserCoachExecution(UserCenterInfoEnum.SUCCESS, coachInfoList);
    }
}
