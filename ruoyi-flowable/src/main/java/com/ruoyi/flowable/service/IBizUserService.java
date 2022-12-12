package com.ruoyi.flowable.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.FlowProcDefDto;

public interface IBizUserService {
    FlowProcDefDto getLatestRecord();

    AjaxResult getFinishedList(Integer pageNum, Integer pageSize);

    AjaxResult getDictData(String dictType);

    AjaxResult getUserList(Integer role);
}
