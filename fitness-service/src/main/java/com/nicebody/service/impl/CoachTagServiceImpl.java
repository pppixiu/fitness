package com.nicebody.service.impl;

import com.nicebody.mapper.CoachTagMapper;
import com.nicebody.pojo.CoachTag;
import com.nicebody.service.CoachTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachTagServiceImpl implements CoachTagService {
    @Autowired
    private CoachTagMapper coachTagMapper;

    @Override
    public List<CoachTag> quaryCoachTag() {
        return coachTagMapper.quaryCoachTag();
    }
}
