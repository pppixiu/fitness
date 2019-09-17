package com.nicebody.service.impl;

import com.nicebody.mapper.CoachMapper;
import com.nicebody.mapper.CoachTagMapper;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.CoachTag;
import com.nicebody.pojo.User;
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
    private CoachTagMapper coachTagMapper;

    @Autowired
    private CoachMapper coachMapper;
    /*测试获取标签*/
    @Test
    public void queryTag(){
        List<CoachTag> coachTagList = coachTagMapper.queryCoachTag();
        System.out.println(coachTagList.get(1).getTagName());
        System.out.println(coachTagList.size());
    }
    /*测试查找全部教练*/
    @Test
    public void queryAllCoach(){
        List<CoachInfo> coachInfoList = coachTagMapper.queryAllCoach();
        System.out.println(coachInfoList.size());
        System.out.println(coachInfoList.get(0).getCoachDesc());
        System.out.println(coachInfoList.get(1).getCoachName());
    }
    /*测试模糊查询*/
    @Test
    public void queryCoachByName(){
        List<CoachInfo> coachInfoList = coachTagMapper.queryCoachByName("黄");
        System.out.println(coachInfoList.size());
        System.out.println(coachInfoList.get(0).getCoachName());
    }
    /*测试根据Id进入*/
    @Test
    public void queryCoachById(){
        List<CoachInfo> coachInfoList = coachMapper.queryCoachById(2);
        System.out.println(coachInfoList.size());
        System.out.println(coachInfoList.get(0).getCoachName());
    }

    @Test
    public void  queryAllImage(){

    }

}
