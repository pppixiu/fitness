package com.nicebody.mapper;

import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName TagMapper
 * @Author Hassan
 * %@Date
 */
@Repository
public interface TagMapper {


    /**
     * 查询教练分类
     *
     * @return
            */
    List<Tag> queryTag();


}
