package com.nicebody.service.impl;

import com.nicebody.mapper.CoachMapper;
import com.nicebody.pojo.Coach;
import com.nicebody.pojo.CoachTag;
import com.nicebody.service.CoachService;
import com.nicebody.service.CoachTagService;
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
    private CoachTagService coachTagService;

    @Autowired
    private CoachService coachService;

    @Autowired
    private CoachMapper coachMapper;

    @Test
    public void testQueryByCoach(){
        List<Coach> coachList = coachMapper.queryCoach();
        System.out.println(coachList.get(0).getUser().getUserName());
    }

    /**
     * 查询教练分类
     * */
    @Test
    public void getCoachTagList(){
        List<CoachTag> coachTagsList = coachTagService.getCoachTag();
        System.out.println(coachTagsList.get(2).getTagName());
        System.out.println(coachTagsList.size());
    }

    /**
     * 查询全部教练
     * */
    @Test
    public void getCoachList(){
        List<Coach> coachList = coachService.getCoach();

        System.out.println(coachList.size());
    }

    /**
     * 根据分类查询教练
     **/
    @Test
    public void getCoachByTag(){
        List<Coach> coachList = coachService.getCoachByTag(4);

        System.out.println(coachList.size());
    }
}
