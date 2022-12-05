package com.ach.calendfi.web.service;

import com.ach.calendfi.mybatis.entity.ActivityInfo;

public interface ActivityinfoService {

    /**
     * Add data
     *
     * @param activityinfo Instance object
     * @return Instance object
     */
    int insert(ActivityInfo activityinfo);
}
