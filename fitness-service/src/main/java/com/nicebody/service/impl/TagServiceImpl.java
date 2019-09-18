package com.nicebody.service.impl;

import com.nicebody.mapper.TagMapper;
import com.nicebody.pojo.Tag;
import com.nicebody.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TagServiceImpl
 * @Author sensu
 * @Date 2019/9/18 19:02
 **/
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;


    @Override
    public List<Tag> getTagList() {
        return tagMapper.queryTag();
    }
}
