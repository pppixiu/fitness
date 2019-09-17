package com.nicebody.mapper;

import com.nicebody.pojo.CoachImage;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.UserBlog;
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
     * 根据Id显示在教练主页
     * @param id
     * @return
     */
    List<CoachInfo> queryCoachById(Integer id);

    /**
     * 查找所有教练图片
     * @param id
     * @return
     */
    List<CoachImage> queryAllImage(Integer id);

    /**
     * 查找所有教练博客
     * @param id
     * @return
     */
    List<UserBlog> queryAllBlog(Integer id);

}
