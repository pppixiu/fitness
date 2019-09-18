package com.nicebody.service;

import com.nicebody.mapper.TagMapper;
import com.nicebody.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName TagService
 * @Author sensu
 * @Date 2019/9/18 19:00
 **/
public interface TagService {
    /**
     * 取出所有tag
     * @return
     */
    public List<Tag> getTagList();
}
