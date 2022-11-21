package com.ach.calendfi.service.impl;

import com.ach.calendfi.dao.*;
import com.ach.calendfi.entity.ActivityInfo;
import com.ach.calendfi.service.ActivityinfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * (Activityinfo)Table service implementation class
 *
 * @author makejava
 * @since 2021-10-21 20:22:26
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ActivityinfoServiceImpl implements ActivityinfoService {
    @Resource
    private ActivityinfoDao activityinfoDao;

    //Copy fields that are not empty
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set emptyNames = new HashSet();
        for (java.beans.PropertyDescriptor pd : pds) {
            //check if value of this property is null then add it to the collection
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return (String[]) emptyNames.toArray(result);
    }

    /**
     * Paging query
     *
     * @param activityinfo Filter condition
     * @param pageRequest  Pagination object
     * @return search result
     */
    @Override
    public Page<ActivityInfo> queryByPage(ActivityInfo activityinfo, PageRequest pageRequest) {
        long total = this.activityinfoDao.count(activityinfo);
        return new PageImpl<>(this.activityinfoDao.queryAllByLimit(activityinfo, pageRequest), pageRequest, total);
    }

    /**
     * Add data
     *
     * @param activityinfo Instance object
     * @return Instance object
     */
    @Override
    public int insert(ActivityInfo activityinfo) {
        ActivityInfo activityByPidAndAid = activityinfoDao.getActivityByPidAndAid(activityinfo.getProjectid(), activityinfo.getActividyid(), activityinfo.getVersion(), activityinfo.getFlag());
        if (!ObjectUtils.isEmpty(activityByPidAndAid)) {
            BeanUtils.copyProperties(activityinfo, activityByPidAndAid, getNullPropertyNames(activityinfo));
            activityByPidAndAid.setEndtime(DateUtils.getyyyymmdd(activityinfo.getEndtime()));
            activityByPidAndAid.setStrarttime(DateUtils.getyyyymmdd(activityinfo.getStrarttime()));
            activityByPidAndAid.setInserttime(DateUtils.getyyyymmdd(activityinfo.getInserttime()));
            return activityinfoDao.update(activityByPidAndAid);
        }
        activityinfo.setEndtime(DateUtils.getyyyymmdd(activityinfo.getEndtime()));
        activityinfo.setStrarttime(DateUtils.getyyyymmdd(activityinfo.getStrarttime()));
        activityinfo.setInserttime(DateUtils.getyyyymmdd(activityinfo.getInserttime()));
        activityinfo.setIsdel("");
        return activityinfoDao.insert(activityinfo);
    }

    @Override
    public Map batchCreateActivity(List<ActivityInfo> activityInfos) {
        int insertcount = 0;
        for (ActivityInfo activityInfo : activityInfos) {
            insertcount += activityinfoDao.insert(activityInfo);
        }
        Map map = new HashMap();
        map.put("insertcount", insertcount);
        return map;
    }

    @Override
    public int update(ActivityInfo activityInfo) {
        if (StringUtils.hasText(activityInfo.getEndtime())){
            activityInfo.setEndtime(DateUtils.getyyyymmdd(activityInfo.getEndtime()));
        }
        return activityinfoDao.update(activityInfo);
    }
}
