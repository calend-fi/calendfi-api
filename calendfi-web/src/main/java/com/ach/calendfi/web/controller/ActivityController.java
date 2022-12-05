package com.ach.calendfi.web.controller;

import com.ach.calendfi.common.baseresp.ResultBody;
import com.ach.calendfi.mybatis.entity.ActivityInfo;
import com.ach.calendfi.web.service.ActivityinfoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/calendfi")
public class ActivityController {

    @Resource
    private ActivityinfoService activityinfoService;

    /*
     * Create ateactivity
     * */
    @PostMapping(value = "/createactivity")
    public ResultBody createActivity(@RequestBody(required = false) ActivityInfo activityInfo) {
        int insert = activityinfoService.insert(activityInfo);
        Map<String, Object> map = new HashMap<>();
        map.put("insertcount", insert);
        return ResultBody.success(map);
    }
}
