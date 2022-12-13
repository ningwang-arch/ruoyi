package com.ruoyi.flowable.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.flowable.domain.dto.BizFlowTaskDto;
import com.ruoyi.flowable.domain.vo.TugFeeVo;
import com.ruoyi.flowable.mapper.TugFeeVoMapper;
import com.ruoyi.flowable.service.IBizAdminService;
import com.ruoyi.flowable.service.IFlowTaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricProcessInstance;
import org.flowable.engine.history.HistoricProcessInstanceQuery;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.flowable.task.api.history.HistoricTaskInstance;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class BizAdminServiceImpl implements IBizAdminService {


    @Resource
    protected RuntimeService runtimeService;
    @Resource
    HistoryService historyService;
    @Resource
    private TugFeeVoMapper tugFeeVoMapper;
    @Resource
    private IFlowTaskService flowTaskService;

    @Resource
    private RepositoryService repositoryService;

    @Resource
    private TaskService taskService;

    @Override
    public AjaxResult myProcess(Integer pageNum, Integer pageSize) {
        Page<BizFlowTaskDto> page = new Page<>();
        //   Long userId = SecurityUtils.getLoginUser().getUser().getUserId();
        HistoricProcessInstanceQuery historicProcessInstanceQuery = historyService.createHistoricProcessInstanceQuery()
//                 .startedBy(userId.toString())
                .orderByProcessInstanceStartTime()
                .desc();
        List<HistoricProcessInstance> historicProcessInstances = historicProcessInstanceQuery.listPage(pageSize * (pageNum - 1), pageSize);
        page.setTotal(historicProcessInstanceQuery.count());
        List<BizFlowTaskDto> flowList = new ArrayList<>();
        for (HistoricProcessInstance hisIns : historicProcessInstances) {
            BizFlowTaskDto flowTask = new BizFlowTaskDto();
            flowTask.setCreateTime(hisIns.getStartTime());
            flowTask.setFinishTime(hisIns.getEndTime());
            flowTask.setProcInsId(hisIns.getId());


            HistoricProcessInstance processInstance = historicProcessInstanceQuery.processInstanceId(hisIns.getId()).singleResult();
            if (!(processInstance == null)) {
                String businessKey = processInstance.getBusinessKey();

                if (StringUtils.isNotBlank(businessKey)) {
                    TugFeeVo tugFeeVo = tugFeeVoMapper.queryById(Long.valueOf(businessKey));

                    setPasswordNull(tugFeeVo);

                    flowTask.setTugFeeVo(tugFeeVo);
                }
            }


            // 计算耗时
            if (Objects.nonNull(hisIns.getEndTime())) {
                long time = hisIns.getEndTime().getTime() - hisIns.getStartTime().getTime();
                flowTask.setDuration(getDate(time));
            } else {
                long time = System.currentTimeMillis() - hisIns.getStartTime().getTime();
                flowTask.setDuration(getDate(time));
            }
            // 流程定义信息
            ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
                    .processDefinitionId(hisIns.getProcessDefinitionId())
                    .singleResult();
            flowTask.setDeployId(pd.getDeploymentId());
            // TODO: 2020/12/16 0016
            flowTask.setProcDefName(pd.getName());
            flowTask.setProcDefVersion(pd.getVersion());
            flowTask.setCategory(pd.getCategory());
            flowTask.setProcDefVersion(pd.getVersion());
            // 当前所处流程 todo: 本地启动放开以下注释
            List<Task> taskList = taskService.createTaskQuery().processInstanceId(hisIns.getId()).list();
            if (CollectionUtils.isNotEmpty(taskList)) {
                flowTask.setTaskId(taskList.get(0).getId());
            } else {
                List<HistoricTaskInstance> historicTaskInstance = historyService.createHistoricTaskInstanceQuery().processInstanceId(hisIns.getId()).orderByHistoricTaskInstanceEndTime().desc().list();
                flowTask.setTaskId(historicTaskInstance.get(0).getId());
            }
            flowList.add(flowTask);
        }
        page.setRecords(flowList);
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

    private void setPasswordNull(TugFeeVo tugFeeVo) {
        if (tugFeeVo == null) {
            return;
        }
        if (tugFeeVo.getReviewer() != null) {
            tugFeeVo.getReviewer().setPassword(null);
            tugFeeVo.getReviewer().setSalt(null);
        }
        if (tugFeeVo.getAdmin() != null) {
            tugFeeVo.getAdmin().setPassword(null);
            tugFeeVo.getAdmin().setSalt(null);
        }
        if (tugFeeVo.getCaculator() != null) {
            tugFeeVo.getCaculator().setPassword(null);
            tugFeeVo.getCaculator().setSalt(null);
        }
        if (tugFeeVo.getApplicant() != null) {
            tugFeeVo.getApplicant().setPassword(null);
            tugFeeVo.getApplicant().setSalt(null);
        }
    }

    private String getDate(long ms) {

        long day = ms / (24 * 60 * 60 * 1000);
        long hour = (ms / (60 * 60 * 1000) - day * 24);
        long minute = ((ms / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long second = (ms / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - minute * 60);

        if (day > 0) {
            return day + "天" + hour + "小时" + minute + "分钟";
        }
        if (hour > 0) {
            return hour + "小时" + minute + "分钟";
        }
        if (minute > 0) {
            return minute + "分钟";
        }
        if (second > 0) {
            return second + "秒";
        } else {
            return 0 + "秒";
        }
    }
}
