package com.nicebody.service;

import com.nicebody.pojo.Coach;

import java.util.List;

public interface CoachService {
    /**
     * 查询所有教练
     * @return
     */
    public List<Coach> getCoach();

    /**
     * 根据分类查找教练
     * @return
     */
    public List<Coach> getCoachByTag(Integer tagId);
}
