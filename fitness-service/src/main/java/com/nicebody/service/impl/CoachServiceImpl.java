package com.nicebody.service.impl;

import com.nicebody.mapper.CoachMapper;
import com.nicebody.mapper.TagMapper;
import com.nicebody.pojo.CoachImage;
import com.nicebody.pojo.CoachInfo;
import com.nicebody.pojo.Tag;
import com.nicebody.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CoachServiceImpl
 * @Author Hassan
 * %@Date 2019/9/16 22:03
 */
@Service
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachMapper coachMapper;

    @Autowired
    private TagMapper tagMapper;

    /**
     * 多条件查找教练信息
     * @param rowIndex
     * @param pageSize
     * @param coachCondition
     * @param orderByCondition
     * @return
     */
    @Override
    public List<CoachInfo> getCoachList(int rowIndex, int pageSize, CoachInfo coachCondition, String orderByCondition) {
        return coachMapper.queryCoachList(rowIndex, pageSize, coachCondition, orderByCondition);
    }

    /**
     * 根据Id查找用户关注教练，以及教练个人信息
     * @param userId
     * @param coachId
     * @return
     */
    @Override
    public List<CoachInfo> getCoachInfo(int rowIndex, int pageSize,int userId, int coachId) {
        return coachMapper.queryCoachInfo(rowIndex, pageSize, userId, coachId);
    }

    /**
     * 根据Id查找教练全部图片
     * @param coachId
     * @return
     */
    @Override
    public List<CoachImage> getImageList(int rowIndex, int pageSize, int coachId) {
        return coachMapper.queryImageList(rowIndex,pageSize,coachId);
    }

    @Override
    public List<Tag> getTag() {
        return tagMapper.queryTag();
    }
}
