package com.ruoyi.flowable.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.flowable.domain.vo.TugFeeVo;
import com.ruoyi.flowable.mapper.TugFeeVoMapper;
import com.ruoyi.flowable.service.IBizAdminService;
import com.ruoyi.flowable.service.IFlowTaskService;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BizAdminServiceImpl implements IBizAdminService {


    @Resource
    protected RuntimeService runtimeService;
    @Resource
    private TugFeeVoMapper tugFeeVoMapper;

    @Resource
    private IFlowTaskService flowTaskService;

    @Override
    public AjaxResult myProcess(Integer pageNum, Integer pageSize, String name, Date startTime, String shipType) {
        Page<TugFeeVo> page = new Page<>();
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("startTime", startTime);
        params.put("shipType", shipType);
        final List<TugFeeVo> dataList = tugFeeVoMapper.queryByParams(params);
        for (TugFeeVo tugFeeVo : dataList) {
            tugFeeVo.getApplicant().setPassword(null);
            tugFeeVo.getApplicant().setSalt(null);
            tugFeeVo.getAdmin().setPassword(null);
            tugFeeVo.getAdmin().setSalt(null);
            tugFeeVo.getCaculator().setPassword(null);
            tugFeeVo.getCaculator().setSalt(null);
            tugFeeVo.getReviewer().setPassword(null);
            tugFeeVo.getReviewer().setSalt(null);
        }
        page.setTotal(new PageInfo(dataList).getTotal());
        page.setRecords(dataList);

        return AjaxResult.success(page);

    }

    @Override
    public AjaxResult record(String tugFeeId) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(tugFeeId).singleResult();
        if (processInstance == null) {
            return AjaxResult.error("流程不存在");
        }

        return flowTaskService.flowRecord(processInstance.getId(), null);

    }
}
