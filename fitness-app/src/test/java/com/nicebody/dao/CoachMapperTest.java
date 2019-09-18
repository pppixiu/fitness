package com.nicebody.dao;

import com.nicebody.mapper.CoachMapper;
import com.nicebody.mapper.CoachTagMapper;
import com.nicebody.pojo.CoachImage;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.CoachTag;
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
    /*测试根据Id查找*/
    @Test
    public void queryCoachById(){
        List<CoachInfo> coachInfoList = coachMapper.queryCoachById(2);
        System.out.println(coachInfoList.size());
        System.out.println(coachInfoList.get(0).getCoachName());
    }
    /*测试查找教练图片*/
    @Test
    public void  queryImage(){
        List<CoachImage> coachImages = coachMapper.queryAllImage(1);
        System.out.println(coachImages.size());
        System.out.println(coachImages.get(0).getImageUrl());
    }
    /*测试查找教练博客*/
    @Test
    public void queryCoachBlog(){
        List<CoachInfo> coachInfos = coachMapper.queryAllBlog(2);
        System.out.println(coachInfos.size());
        System.out.println(coachInfos.get(0).getUserBlogImage().getImageUrl());
    }

    /*测试多条件分类查询*/
    @Test
    public void queryCoachTag(){
        List<CoachInfo> coachInfoList = coachTagMapper.queryCoachByTag(0,1);
        System.out.println(coachInfoList.size());
        System.out.println(coachInfoList.get(0).getCoachImage().getImageUrl());
    }

}
