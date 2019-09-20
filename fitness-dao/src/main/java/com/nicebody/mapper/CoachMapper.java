package com.nicebody.mapper;

import com.nicebody.pojo.CoachImage;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.UserBlog;
import org.apache.ibatis.annotations.Param;
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
     * 查询教练所有信息
     * 支持 标签（tag） 收藏数（likeCount） 姓名（coachName）价格（price）（模糊查询） 过滤
     * 通过 时间 人数 价格 姓名
     *
     * @return
     */
    List<CoachInfo> queryCoachList(@Param("rowIndex") int rowIndex,
                                   @Param("pageSize") int pageSize,
                                   @Param("coachCondition") CoachInfo coachCondition,
                                   @Param("orderByCondition") String orderByCondition);

    /**
     * 根据Id查找教练信息
     * 支持 查找用户关注教练信息（userId，0） 查找教练个人信息（0，coachId）
     * @param coachId
     * @return
     */
    List<CoachInfo> queryCoachInfo(@Param("rowIndex") int rowIndex,
                                   @Param("pageSize") int pageSize,
                                   @Param("userId") int userId,
                                   @Param("coachId") int coachId);

    /**
     * 根据教练Id查找所有教练图片
     * @param rowIndex
     * @param pageSize
     * @param coachId
     * @return
     */
    List<CoachImage> queryImageList( @Param("rowIndex") int rowIndex,
                                     @Param("pageSize") int pageSize,
                                     @Param("coachId") int coachId);

}
