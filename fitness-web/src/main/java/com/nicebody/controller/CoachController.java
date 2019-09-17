package com.nicebody.controller;

import com.nicebody.pojo.Coach;
import com.nicebody.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CoachController
 * @Author Hassan
 * %@Date 2019/9/16 22:06
 */
@RestController
@RequestMapping("/coachList")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @GetMapping("/coach")
    public Map<String, Object> listCoach() {
        Map<String, Object> map = new HashMap<>();
        List<Coach> coachList = coachService.getCoach();
        map.put("success", true);
        map.put("tags", coachList);
        return map;
    }

    @GetMapping("/coachByTag")
    public Map<String, Object> listCoachByTag(HttpServletRequest request) {
        Integer tagId = Integer.parseInt(request.getParameter("tagId"));
        Map<String, Object> map = new HashMap<>();
        List<Coach> coachList = coachService.getCoachByTag(tagId);
        map.put("success", true);
        map.put("tags", coachList);
        return map;
    }
}
