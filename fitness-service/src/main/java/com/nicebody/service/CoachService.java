package com.nicebody.service;

import com.nicebody.pojo.CoachImage;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *@ClassName CoachService
 *@Author Hassan
 %@Date
 */
public interface CoachService {
    /**
     * 多条件查询教练所有信息
     * 支持 标签（tag） 收藏数（likeCount） 姓名（coachName）价格（price）（模糊查询） 过滤
     * 通过 时间 人数 价格 姓名
     * @param rowIndex
     * @param pageSize
     * @param coachCondition
     * @param orderByCondition
     * @return
     */
    List<CoachInfo> getCoachList(@Param("rowIndex") int rowIndex,
                                   @Param("pageSize") int pageSize,
                                   @Param("coachCondition") CoachInfo coachCondition,
                                   @Param("orderByCondition") String orderByCondition);

    /**
     * 根据Id查找教练信息
     * 支持 查找用户关注教练信息（userId，0） 查找教练个人信息（0，coachId）
     * @param userId
     * @param coachId
     * @return
     */
    List<CoachInfo> getCoachInfo(@Param("rowIndex") int rowIndex,
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
    List<CoachImage> getImageList(@Param("rowIndex") int rowIndex, @Param("pageSize") int pageSize, @Param("coachId") int coachId);

    /**
     * 查询分类
     * @return
     */
    List<Tag> getTag();


    /**
     * 点赞
     * @param coachId
     * @param likeJudge
     * @return
     */
    int  modifyCoachLikeCount(@Param("coachId") int coachId, @Param("likeJudge") int likeJudge);
}
