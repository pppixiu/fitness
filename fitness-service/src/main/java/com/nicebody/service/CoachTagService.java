package com.nicebody.service;

import com.nicebody.pojo.CoachTag;

import java.util.List;

/**
 *@ClassName
 *@Author Hassan
 %@Date
 */
public interface CoachTagService {
    /**
     * 查询所有标签
     * @return
     */
    public List<CoachTag> getCoachTag();
}
