package com.nicebody.controller;

import com.nicebody.interceptor.LoginRequired;
import com.nicebody.pojo.Course;
import com.nicebody.pojo.CourseLesson;
import com.nicebody.pojo.Tag;
import com.nicebody.pojo.UserProfile;
import com.nicebody.service.CourseService;
import com.nicebody.service.TagService;
import com.nicebody.util.OrderByUtil;
import com.nicebody.util.ResultVOUtil;
import com.nicebody.vo.CourseLessonVO;
import com.nicebody.vo.CourseVO;
import com.nicebody.vo.ResultVO;
import com.nicebody.vo.UserProfileVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @ClassName CourseController
 * @Author cx
 * @Date 2019/9/15 20:24
 **/
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private TagService tagService;

    @GetMapping("/listcourses")
    public ResultVO listCourse(@RequestParam(value ="pageIndex",required = false) Integer pageIndex,
                               @RequestParam(value ="pageSize" ,required = false) Integer pageSize,
                               @RequestParam(value = "orderByCondition",required = false )Integer orderByCondition,
                               @RequestParam(value = "courseTitle",required = false) String courseTitle,
                               @RequestParam(value = "tagId",required = false) Integer tagId,
                               @RequestParam(value = "courseLevel",required = false) Integer courseLevel){
        ResultVO resultVO = new ResultVO();
        Course courseCondition = compactCourseCondition3Search(courseTitle,tagId,courseLevel);
        String orderByCourse = OrderByUtil.convert2String(orderByCondition);
        //查询所有的course信息
        List<Course> courseList = courseService.getCourseList(pageIndex,pageSize,courseCondition,orderByCourse);
        List<CourseVO> courseVOList = new ArrayList<>();
        for(Course course:courseList){
            CourseVO courseVO = new CourseVO();
            int level = course.getCourseLevel();
            if(level == 0){
                courseVO.setCourseLevel("初级");
            }else if(level == 1){
                courseVO.setCourseLevel("中级");
            }else{
                courseVO.setCourseLevel("高级");
            }
            UserProfileVO userProfileVO = new UserProfileVO();
            courseVO.setCourseId(course.getCourseId());
            courseVO.setCourseTitle(course.getCourseTitle());
            courseVO.setCourseDesc(course.getCourseDesc());
            courseVO.setImageUrl(course.getImageUrl());
            courseVO.setCourseNowPrice(course.getCourseNowPrice());
            courseVO.setCoursePrePrice(course.getCoursePrePrice());
            courseVO.setCourseTime(course.getCourseTime());
            courseVO.setStudyCount(course.getStudyCount());
            userProfileVO.setUserName(course.getUserProfile().getUserName());
            userProfileVO.setUserImageUrl(course.getUserProfile().getUserImageUrl());
            courseVO.setUserProfileVO(userProfileVO);
            courseVOList.add(courseVO);
        }

        return ResultVOUtil.success(courseVOList);


    }

    /**
     *按条件查询的方法
     * @param courseTitle
     * @param tagId
     * @param courseLevel
     * @return
     */
    private Course compactCourseCondition3Search(String courseTitle,Integer tagId,Integer courseLevel){
        Course courseCondition = new Course();
        if(courseTitle!=null){
            ////查询名字里包含courseTitle的courses信息
            courseCondition.setCourseTitle(courseTitle);
        }
        if(tagId!=null){
            //查询某个tagId下面的course信息
           courseCondition.setTagId(tagId);
        }
        if(courseLevel!=null){
            //查询位于某个等级下的course信息
            courseCondition.setCourseLevel(courseLevel);
        }

        return courseCondition;
    }

    /**
     * 根据courseId查询course信息
     * @param courseId
     * @return
     */


    @GetMapping("/listcoursebyid")
    public ResultVO listCourseById(@RequestParam(value = "courseId",required = false) Integer courseId){
        ResultVO resultVO = new ResultVO();
        //查询所有的course信息
        Course course = courseService.getCourseByCourseId(courseId);
        List<CourseLesson> courseLessonList = course.getCourseLessonList();
        CourseVO courseVO = new CourseVO();
        UserProfileVO userProfileVO = new UserProfileVO();
        int level = course.getCourseLevel();
        if(level == 0){
            courseVO.setCourseLevel("初级");
        }else if(level == 1){
            courseVO.setCourseLevel("中级");
        }else{
            courseVO.setCourseLevel("高级");
        }
        courseVO.setCourseTitle(course.getCourseTitle());
        courseVO.setCourseDesc(course.getCourseDesc());
        courseVO.setCourseNowPrice(course.getCourseNowPrice());
        courseVO.setStudyCount(course.getStudyCount());
        courseVO.setCourseTime(course.getCourseTime());
        courseVO.setCourseNote(course.getCourseNote());
        userProfileVO.setUserName(course.getUserProfile().getUserName());
        userProfileVO.setUserImageUrl(course.getUserProfile().getUserImageUrl());
        List<CourseLessonVO> courseLessonVOList = new ArrayList<>();
        for(CourseLesson courseLesson:courseLessonList){
                CourseLessonVO courseLessonVO = new CourseLessonVO();
                BeanUtils.copyProperties(courseLesson,courseLessonVO);
                courseLessonVOList.add(courseLessonVO);
        }
        courseVO.setCourseLessonVOList(courseLessonVOList);
        courseVO.setUserProfileVO(userProfileVO);
        return ResultVOUtil.success(courseVO);
    }

    /**
     * 查询所有标签
     * @return
     */
    @GetMapping("/tagname")
    public ResultVO listCourseById(){
        ResultVO resultVO = new ResultVO();
        List<Tag> tagList = tagService.getTagList();
        resultVO.setData(tagList);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;


    }
    








}
