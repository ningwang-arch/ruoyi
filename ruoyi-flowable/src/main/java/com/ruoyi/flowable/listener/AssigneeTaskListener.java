package com.ruoyi.flowable.listener;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.TugFee;
import com.ruoyi.system.mapper.TugFeeMapper;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("AssigneeTaskListener")
public class AssigneeTaskListener implements TaskListener {

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TugFeeMapper tugFeeMapper;

    @Override
    public void notify(DelegateTask delegateTask) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceId(delegateTask.getProcessInstanceId())
                .singleResult();
        String businessKey = processInstance.getBusinessKey();
        if (businessKey == null || StringUtils.isEmpty(businessKey)) {
            return;
        }
        TugFee tugFee = tugFeeMapper.selectTugFeeById(Long.valueOf(businessKey));
        if (tugFee == null) {
            return;
        }
        if ("create".equals(delegateTask.getEventName())) {
            switch (delegateTask.getName()) {
                case "计费员":
                    if (tugFee.getCaculatorId() == null) {
                        delegateTask.setAssignee("100");
                    } else {
                        delegateTask.setAssignee(tugFee.getCaculatorId().toString());
                    }
                    break;
                case "审核员":
                    if (tugFee.getReviewerId() == null) {
                        delegateTask.setAssignee("100");
                    } else {
                        delegateTask.setAssignee(tugFee.getReviewerId().toString());
                    }
                    break;
                case "船代":
                    if (tugFee.getApplicantId() == null) {
                        delegateTask.setAssignee("100");
                    } else {
                        delegateTask.setAssignee(tugFee.getApplicantId().toString());
                    }
                    break;
                default:
                    break;
            }
        }

    }
}
