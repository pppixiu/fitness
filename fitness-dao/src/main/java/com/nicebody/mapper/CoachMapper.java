package com.nicebody.mapper;

import com.nicebody.pojo.Coach;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName CoachMapper
 * @Author Hassan
 * %@Date 2019/9/16 21:54
 */

@Repository
public interface CoachMapper {
    /**
     * 教练查询
     * @return
     */
    List<Coach> queryCoach();

    /**
     * 分类查询
     * @return
     */
    List<Coach> sortCoach(Integer tagId);

    /*
    * 根据courseId查询单条详细信息
    * */

}
