package com.nicebody.dao;

import com.nicebody.enums.OrderByEnum;
import com.nicebody.mapper.CoachMapper;
import com.nicebody.mapper.TagMapper;
import com.nicebody.pojo.CoachImage;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.Tag;
import com.nicebody.util.OrderByUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName CoachMapperTest
 * @Author Hassan
 * %@Date 2019/9/18 08:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoachMapperTest {
    @Autowired
    private CoachMapper coachMapper;

    /** 测试教练列表多条件查询*/
    @Test
    public void queryCoachListTest() {
        CoachInfo coachInfo = new CoachInfo();
        coachInfo.setTagId(4);
        String value = OrderByUtil.coachConvent2String(OrderByEnum.PRICE.getCode());
        List<CoachInfo> coachInfoList = coachMapper.queryCoachList(0, 2, coachInfo, value);
        Assert.assertEquals(1, coachInfoList.size());
    }

    /** 测试查找用户收藏教练，以及测试查找教练个人信息*/
    @Test
    public void queryCoachInfoTest() {
        CoachInfo coachInfo = new CoachInfo();
        List<CoachInfo> coachInfoList = coachMapper.queryCoachInfo(0,2,1,0);
        Assert.assertEquals(2, coachInfoList.size());
    }

    /** 测试获取教练图片*/
    @Test
    public void queryImageListTest(){
        CoachImage coachImage = new CoachImage();
        List<CoachImage> coachImageList = coachMapper.queryImageList(0,1,1);
        Assert.assertEquals(2,coachImageList.size());
    }

    /** 测试修改教练点赞信息*/
    @Test
    public void updateLikeCountTest(){
        System.out.println(coachMapper.updateCoachLikeCount(1,-1));
        System.out.println(coachMapper.updateCoachLikeCount(1,1));
    }

    /** 测试添加用户点赞教练关联信息*/
    @Test
    public void addUserLikeCoachTest(){
        System.out.println(coachMapper.addCoachLikeCount(8,3));
    }

    /** 测试删除用户点赞教练关联信息*/
    @Test
    public void deleteUserLikeCountTest(){
        System.out.println(coachMapper.deleteCoachLikeCount(7,3));
        System.out.println(coachMapper.deleteCoachLikeCount(7,3));
    }

    /** 测试查询用户点赞教练关联信息*/
    @Test
    public void queryUserLikeCountTest(){
        System.out.println(coachMapper.queryCoachLikeCount(8,3));
        System.out.println(coachMapper.queryCoachLikeCount(7,3) == null);
    }
}
