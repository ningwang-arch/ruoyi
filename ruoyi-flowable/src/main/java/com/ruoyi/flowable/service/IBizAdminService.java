package com.ruoyi.flowable.service;

import com.ruoyi.common.core.domain.AjaxResult;

public interface IBizAdminService {
    AjaxResult myProcess(Integer pageNum, Integer pageSize);

    AjaxResult record(String tugFeeId);
}
