package com.nicebody.service.impl;

import com.nicebody.mapper.CoachMapper;
import com.nicebody.pojo.Coach;
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

    @Override
    public List<Coach> getCoach() {
        return coachMapper.queryCoach();
    }

    @Override
    public List<Coach> getCoachByTag(Integer tagId) {
        return coachMapper.sortCoach(tagId);
    }
}
