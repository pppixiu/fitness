package com.nicebody.controller;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.nicebody.dto.UserBlogExecution;
import com.nicebody.dto.UserCoachExecution;
import com.nicebody.dto.UserCourseExecution;
import com.nicebody.enums.UserCenterInfoEnum;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.UserBlog;
import com.nicebody.service.UserBlogService;
import com.nicebody.service.UserCenterService;
import com.nicebody.util.ResultVOUtil;
import com.nicebody.vo.CoachVO;
import com.nicebody.vo.CourseVO;
import com.nicebody.vo.ResultVO;
import com.nicebody.vo.UserBlogVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Author sensu
 * @Date 2019/9/19 9:54
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserCenterService userCenterService;

    @Autowired


    @GetMapping("/bloglist")
    public ResultVO getBlogList() {
        List<UserBlogVO> blogVOList = new ArrayList<>();
        //权限管理改为session
        //TODO 权限管理
        UserBlog userBlogCondition = new UserBlog();
        userBlogCondition.setUserId(1);
        //取出blog集合
        UserBlogExecution userBlogExecution = userCenterService.getUserBlogByUserIdOrContentLike(0, 5, userBlogCondition);
        if (userBlogExecution.getCode() == UserCenterInfoEnum.SUCCESS.getState()) {
            for (UserBlog userBlog : userBlogExecution.getUserBlogList()) {
                UserBlogVO userBlogVO = new UserBlogVO();
                BeanUtils.copyProperties(userBlog, userBlogVO);
                userBlogVO.setImageUrl(userBlog.getUserBlogImage().getImageUrl());
                blogVOList.add(userBlogVO);
            }
            return ResultVOUtil.success(blogVOList);
        } else if (userBlogExecution.getCode() == UserCenterInfoEnum.NO_INFO.getState()) {
            return ResultVOUtil.none(UserCenterInfoEnum.NO_INFO);
        }
        return ResultVOUtil.none(UserCenterInfoEnum.ERROR);
    }

    @GetMapping("/courseList")
    public ResultVO getCourseList() {
        //TODO 权限管理
        int userId = 1;
        List<CourseVO> courseVOList = new ArrayList<>();

        UserCourseExecution userCourseExecution = userCenterService.getCourseList(userId);
        if(userCourseExecution.getCode() == UserCenterInfoEnum.SUCCESS.getState()){
            for(Course course : userCourseExecution.getCourseList()){
                CourseVO courseVO = new CourseVO();
                BeanUtils.copyProperties(course, courseVO);
                courseVOList.add(courseVO);
            }
            return ResultVOUtil.success(courseVOList);
        }else if(userCourseExecution.getCode() == UserCenterInfoEnum.NO_INFO.getState()){
            return ResultVOUtil.none(UserCenterInfoEnum.NO_INFO);
        }

        return ResultVOUtil.none(UserCenterInfoEnum.ERROR);
    }

    @GetMapping("/coachlist")
    public ResultVO getCoachList(){
        //TODO 权限管理
        int userId = 1;
        List<CoachVO> coachVOList = new ArrayList<>();
        UserCoachExecution userCoachExecution = userCenterService.getCoachList(userId);
        if(userCoachExecution.getCode() == UserCenterInfoEnum.SUCCESS.getState()){
            for(CoachInfo coachInfo : userCoachExecution.getCoachInfoList()){
                CoachVO coachVO = new CoachVO();
                BeanUtils.copyProperties(coachInfo, coachVO);
                coachVOList.add(coachVO);
            }
            return ResultVOUtil.success(coachVOList);
        }else if(userCoachExecution.getCode() == UserCenterInfoEnum.NO_INFO.getState()){
            return ResultVOUtil.none(UserCenterInfoEnum.NO_INFO);
        }
        return ResultVOUtil.none(UserCenterInfoEnum.ERROR);
    }
}
