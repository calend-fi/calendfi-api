package com.ach.calendfi.controller;

import com.ach.calendfi.customexception.ResultBody;
import com.ach.calendfi.entity.ActivityInfo;
import com.ach.calendfi.service.ActivityinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/calendfi")
public class ActivityController {

    @Autowired
    private ActivityinfoService activityinfoService;

    /*
     * Create ateactivity
     * */
    @RequestMapping(value = "/createactivity", method = RequestMethod.POST)
    public ResultBody createActivity(@RequestBody(required = false) ActivityInfo activityInfo) {
        int insert = activityinfoService.insert(activityInfo);
        Map map = new HashMap();
        map.put("insertcount", insert);
        return ResultBody.success(map);
    }
}
