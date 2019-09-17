package com.nicebody.mapper;

import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.CoachTag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@ClassName CoachTagMapper
 *@Author Hassan
 %@Date
 */
@Repository
public interface CoachTagMapper {
    /**
     * 查询全部教练
     * @return
     */
    List<CoachInfo> queryAllCoach();

    /**
     * 根据分类查询教练
     * @return
     */
    List<CoachInfo> queryCoachByTag();

    /**
     * 查询教练分类
     * @return
     */
    List<CoachTag> queryCoachTag();

    /**
     * 名字模糊查询
     * @return
     */
    List<CoachInfo> queryCoachByName(String coachame);
}
