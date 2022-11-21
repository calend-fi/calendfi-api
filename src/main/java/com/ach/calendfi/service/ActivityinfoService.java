package com.ach.calendfi.service;

import com.ach.calendfi.entity.ActivityInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * (Activityinfo)Table service interface
 *
 * @author makejava
 * @since 2021-10-21 20:22:25
 */
public interface ActivityinfoService {

    /**
     * Paging query
     *
     * @param activityinfo Filter condition
     * @param pageRequest  Pagination object
     * @return search result
     */
    Page<ActivityInfo> queryByPage(ActivityInfo activityinfo, PageRequest pageRequest);

    /**
     * Add data
     *
     * @param activityinfo Instance object
     * @return Instance object
     */
    int insert(ActivityInfo activityinfo);

    Map batchCreateActivity(List<ActivityInfo> activityInfos);

    int update(ActivityInfo activityInfo);
}
