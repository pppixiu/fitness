package com.nicebody.controller;

import com.nicebody.enums.OrderByEnum;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.service.CoachService;
import com.nicebody.util.OrderByUtil;
import com.nicebody.util.ResultVOUtil;
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

    @GetMapping(value = "/coachList/tag/{tagId}/page/{rowIndex}/sort/{sortId}/coachName/{coachName}")
    public ResultVO sortCoachList(@PathVariable Integer tagId, @PathVariable Integer rowIndex, @PathVariable Integer sortId, @PathVariable String coachName){
        //存储查找教练信息
        CoachInfo coachCondition = new CoachInfo();
        coachCondition.setTagId(tagId);
        coachCondition.setCoachName(coachName);
        //将转换sortId
        String sortValue = OrderByUtil.coachConvent2String(sortId);
        //查询所有教练信息
        List<CoachInfo> coachInfoList = coachService.getCoachList(rowIndex,4,coachCondition,sortValue);
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

  /*  @GetMapping(value = "/coachList/{coachId}")
    public ResultVO getCoachInfo(@PathVariable Integer coachId){
        //查找该id的教练信息
        List<CoachInfo> coachInfoList = coachService.getCoachInfo(0,coachId);
    }*/
}
