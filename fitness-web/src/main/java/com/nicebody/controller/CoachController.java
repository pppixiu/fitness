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
import com.nicebody.vo.CourseVO;
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
    private CourseService courseService;

    /**
     * 多条件查询教练信息
     *
     * @param tagId
     * @param rowIndex
     * @param sortId
     * @param coachName
     * @return
     */
    @GetMapping(value = "/coachList")
    public ResultVO sortCoachList(@RequestParam(name = "tagId", defaultValue = "0") Integer tagId,
                                  @RequestParam(name = "rowIndex", defaultValue = "0") Integer rowIndex,
                                  @RequestParam(name = "sortId", defaultValue = "0") Integer sortId,
                                  @RequestParam(name = "coachName", defaultValue = "empty") String coachName) {
        rowIndex += 8;

        //存储查找教练信息
        CoachInfo coachCondition = new CoachInfo();
        coachCondition.setTagId(tagId);
        coachCondition.setCoachName(coachName);

        //将转换sortId
        String sortValue = OrderByUtil.coachConvent2String(sortId);

        //判断是否加载全部
        List<CoachInfo> coachSize = coachService.getCoachList(0,9999,coachCondition,sortValue);
        if(rowIndex > coachSize.size() + 8){
            return null;
        }

        List<CoachInfo> coachInfoList = coachService.getCoachList(0, rowIndex, coachCondition, sortValue);
        List<CoachVO> coachVOList = new ArrayList<>();
        //填值
        for (CoachInfo coachInfo : coachInfoList) {
            CoachVO coachVO = new CoachVO();
            BeanUtils.copyProperties(coachInfo, coachVO);
            coachVOList.add(coachVO);
        }
        //公共方法返回
        return ResultVOUtil.success(coachVOList);
    }

    /**
     * 多条件查询教练个人信息
     *
     * @param rowIndex
     * @param pageSize
     * @param coachId
     * @param userId
     * @return
     */
    @GetMapping(value = "/coachShow")
    public ResultVO getCoachInfo(@RequestParam(name = "rowIndex", defaultValue = "0") Integer rowIndex,
                                 @RequestParam(name = "pageSize", defaultValue = "2") Integer pageSize,
                                 @RequestParam(name = "coachId", defaultValue = "1") Integer coachId,
                                 @RequestParam(name = "userId", defaultValue = "0") Integer userId) {
        Blog userCondition = new Blog();
        userCondition.setUserId(coachId);

        //查找该id的教练\图片\课程\博文信息
        List<CoachInfo> coachInfoList = coachService.getCoachInfo(rowIndex, pageSize, 0, coachId);
        List<CoachInfoVO> coachInfoVOList = new ArrayList<>();

        for (CoachInfo coachInfo : coachInfoList) {
            CoachInfoVO coachInfoVO = new CoachInfoVO();
            BeanUtils.copyProperties(coachInfo, coachInfoVO);
            coachInfoVOList.add(coachInfoVO);
        }
        //公共方法返回
        return ResultVOUtil.success(coachInfoVOList);
    }

    /**
     * 查询全部分类
     * @return
     */
    @GetMapping(value = "/tag")
    public ResultVO getCoachTag() {
        List<Tag> tagList = coachService.getTag();
        return ResultVOUtil.success(tagList);
    }

    /**
     * 查询教练课程
     * @param coachId
     * @return
     */
    @GetMapping(value = "/coachCourse")
    public ResultVO getCoachSourse(@RequestParam(name = "coachId", defaultValue = "1") Integer coachId){
        List<Course> courseList = courseService.getCourseByCoachId(coachId,0,3);
        List<CourseVO> courseInfoVOList = new ArrayList<>();

        for (Course course : courseList) {
            CourseVO courseVO = new CourseVO();
            BeanUtils.copyProperties(course, courseVO);
            courseInfoVOList.add(courseVO);
        }
        //公共方法返回
        return ResultVOUtil.success(courseInfoVOList);
    }

    /**
     * 查询教练展示图片
     * @param coachId
     * @return
     */
    @GetMapping(value = "/coachImage")
    public ResultVO  getCoachImage(@RequestParam(name = "coachId", defaultValue = "1") Integer coachId){
       List<CoachImage> coachImageList = coachService.getImageList(0,3,coachId);
       ResultVO resultVO = new ResultVO();

       resultVO.setData(coachImageList);
       resultVO.setCode(0);
       resultVO.setMsg("成功");
       return resultVO;
    }
}
