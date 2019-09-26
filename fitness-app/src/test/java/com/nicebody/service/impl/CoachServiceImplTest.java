package com.nicebody.service.impl;

import com.nicebody.enums.OrderByEnum;
import com.nicebody.pojo.CoachImage;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.service.CoachService;
import com.nicebody.util.OrderByUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName CoachServiceImplTest
 * @Author Hassan
 * %@Date 2019/9/17 09:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoachServiceImplTest {
    @Autowired
    private CoachService coachService;

    /** 多条件查找教练信息测试*/
    @Test
    public void getCoachListTest(){
        CoachInfo coachInfo = new CoachInfo();
        coachInfo.setTagId(4);
        coachInfo.setCoachName("王");
        String value = OrderByUtil.coachConvent2String(OrderByEnum.PRICE.getCode());
        List<CoachInfo> coachInfoList = coachService.getCoachList(0,2,coachInfo,value);
        Assert.assertEquals(1, coachInfoList.size());
    }

    /** 测试根据Id查找关注教练，以及教练个人信息*/
    @Test
    public void getCoachInfoTest(){
        CoachInfo coachInfo = new CoachInfo();
        List<CoachInfo> coachInfoList = coachService.getCoachInfo(0,2,0,1);
        List<CoachInfo> coachInfoList1 = coachService.getCoachInfo(0,2,1,0);
        Assert.assertEquals(1,coachInfoList.size());
        Assert.assertEquals(2,coachInfoList1.size());
    }

    /** 测试查找教练图片*/
    @Test
    public void getImageListTest(){
        CoachImage coachImage = new CoachImage();
        List<CoachImage> coachImages = coachService.getImageList(0,2,1);
        Assert.assertEquals(2,coachImages.size());
    }

    /** 测试教练点赞修改*/
    @Test
    public void modifyCoachLikeCountTest(){
        int i = coachService.modifyCoachLikeCount(1,-1);
        System.out.println(i);
    }

    /** 查询关联信息*/
    @Test
    public void getCoachLikeCountTest(){
        System.out.println(coachService.getCoachLikeCount(3,2));
        System.out.println(coachService.getCoachLikeCount(9,10));
    }

    /** 添加关联信息*/
    @Test
    public void insCoachLikeCountTest(){
        System.out.println(coachService.insCoachLikeCount(9,10));
    }

    /** 删除关联信息*/
    @Test
    public void delCoachLikeCountTest(){
        System.out.println(coachService.delCoachLikeCount(9,10));
        System.out.println(coachService.delCoachLikeCount(9,10));
    }
}
