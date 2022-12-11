package com.ruoyi.flowable.service;

import com.ruoyi.common.core.domain.AjaxResult;

import java.util.Date;

public interface IBizAdminService {
    AjaxResult myProcess(Integer pageNum, Integer pageSize, String name, Date startTime, String shipType);

    AjaxResult record(String tugFeeId);
}
