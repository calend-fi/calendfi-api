package com.ach.calendfi.dao;

import com.ach.calendfi.entity.ActivityInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Activityinfo)Table database access layer
 *
 * @author makejava
 * @since 2021-10-21 20:22:23
 */
@Mapper
public interface ActivityinfoDao {

    /**
     * Query specified row data
     *
     * @param activityinfo Query conditions
     * @param pageable     Pagination object
     * @return Object list
     */
    List<ActivityInfo> queryAllByLimit(ActivityInfo activityinfo, @Param("pageable") Pageable pageable);

    /**
     * Count the total number of rows
     *
     * @param activityinfo Query conditions
     * @return Total number of rows
     */
    long count(ActivityInfo activityinfo);

    /**
     * Add data
     *
     * @param activityinfo Instance object
     * @return Affect the number of rows
     */
    int insert(ActivityInfo activityinfo);

    List<ActivityInfo> getActivity(@Param("projectid") int projectid);

    List<ActivityInfo> getActivityByPoolId(@Param("projectid") int projectid, @Param("poolid") int poolid);

    ActivityInfo getActivityByPidAndAid(@Param("projectid") int projectid, @Param("actividyid") int actividyid, @Param("version") String version, @Param("flag") int flag);

    int update(ActivityInfo activityInfo);
}

