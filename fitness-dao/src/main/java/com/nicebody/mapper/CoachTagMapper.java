package com.nicebody.mapper;

import com.nicebody.pojo.CoachTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@ClassName
 *@Author Hassan
 %@Date
 */
@Repository
public interface CoachTagMapper {
    /**
     * 查询标签
     * @return
     */
    List<CoachTag> queryCoachTag();
}
