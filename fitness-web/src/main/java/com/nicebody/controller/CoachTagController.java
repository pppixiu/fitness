package com.nicebody.controller;

import com.nicebody.pojo.CoachTag;
import com.nicebody.service.CoachTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@ClassName
 *@Author Hassan
 %@Date
 */
@RestController
@RequestMapping("/coachList")
public class CoachTagController {
    @Autowired
    private CoachTagService coachTagService;

    @GetMapping("/tag")
    public Map<String, Object> listTag(){
        Map<String, Object> map = new HashMap<>();
        List<CoachTag> tagList = coachTagService.getCoachTag();
        map.put("success", true);
        map.put("tags", tagList);
        return map;
    }
}
