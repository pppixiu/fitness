package com.nicebody.controller;

import com.nicebody.enums.OrderByEnum;
import com.nicebody.pojo.*;
import com.nicebody.service.CoachService;
import com.nicebody.service.CourseService;
import com.nicebody.service.BlogService;
import com.nicebody.util.OrderByUtil;
import com.nicebody.util.ResultVOUtil;
import com.nicebody.vo.CoachInfoVO;
import com.nicebody.vo.CoachVO;
import com.nicebody.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName CoachController
 * @Author Hassan
 * %@Date 2019/9/16 22:06
 */
@RestController
@RequestMapping("/coach")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @Autowired
    private BlogService BlogService;

    @Autowired
    private CourseService courseService;

    /**
     * 多条件查询教练信息
     * @param tagId
     * @param rowIndex
     * @param sortId
     * @param coachName
     * @return
     */
    @GetMapping
    public ResultVO sortCoachList(@RequestParam(name="tagId", defaultValue="0") Integer tagId,
                                  @RequestParam(name="rowIndex", defaultValue="0") Integer rowIndex,
                                  @RequestParam(name="sortId", defaultValue="0") Integer sortId,
                                  @RequestParam(name="coachName", defaultValue = "empty") String coachName){
        //存储查找教练信息
        CoachInfo coachCondition = new CoachInfo();
        coachCondition.setTagId(tagId);
        coachCondition.setCoachName(coachName);
        //将转换sortId
        String sortValue = OrderByUtil.coachConvent2String(sortId);
        //查询所有教练信息
        List<CoachInfo> coachInfoList = coachService.getCoachList(rowIndex,8,coachCondition,sortValue);
        List<CoachVO> coachVOList = new ArrayList<>();
        //填值
        for(CoachInfo coachInfo : coachInfoList) {
            CoachVO coachVO = new CoachVO();
            BeanUtils.copyProperties(coachInfo,coachVO);
            coachVOList.add(coachVO);
        }
        //公共方法返回
        return ResultVOUtil.success(coachVOList);
    }

    /**
     * 多条件查询教练个人信息
     * @param rowIndex
     * @param pageSize
     * @param coachId
     * @param userId
     * @return
     */
    @GetMapping(value = "/coachInfo")
    public ResultVO getCoachInfo(@RequestParam(name="rowIndex", defaultValue="0") Integer rowIndex,
                                 @RequestParam(name="pageSize", defaultValue="2") Integer pageSize,
                                 @RequestParam(name="coachId",defaultValue = "1") Integer coachId,
                                 @RequestParam(name="userId",defaultValue = "1") Integer userId){
        Blog userCondition = new Blog();
        userCondition.setUserId(userId);

        //查找该id的教练\图片\课程\博文信息
        List<CoachInfo> coachInfoList = coachService.getCoachInfo(rowIndex,pageSize,0,coachId);
        List<CoachImage> coachImageList = coachService.getImageList(rowIndex,pageSize, coachId);
        List<Blog> userBlogList = BlogService.getUserBlogByUserIdOrContentLike(rowIndex,pageSize,userCondition);
        //List<Course> courseList = courseService.getCourseList(rowIndex, pageSize, coachId);
        List<CoachInfoVO> coachInfoVOList = new ArrayList<>();
        //填值
        for(CoachInfo coachInfo : coachInfoList){
            CoachInfoVO coachInfoVO = new CoachInfoVO();
            BeanUtils.copyProperties(coachInfo, coachInfoVO);
            coachInfoVO.setBlogs(userBlogList);
            coachInfoVO.setCoachImages(coachImageList);
            //coachInfoVO.setCourses(courseList);
            coachInfoVOList.add(coachInfoVO);
        }

        //公共方法返回
        return ResultVOUtil.success(coachInfoVOList);
    }

    @GetMapping("/tag")
    public ResultVO getCoachTag(){
        List<Tag> tagList = coachService.getTag();
        return ResultVOUtil.success(tagList);
    }
}
