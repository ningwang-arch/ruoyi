package com.ruoyi.flowable.base_service;

import com.ruoyi.flowable.base_service.cmd.StartProcessNameProcessInstanceCmd;
import org.flowable.engine.ManagementService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.impl.RuntimeServiceImpl;
import org.flowable.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.flowable.engine.impl.cmd.StartProcessInstanceCmd;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BizRuntimeService  {

  @Autowired
  ManagementService managementService;

  public ProcessInstance startProcessInstanceById(String procName, String processDefinitionId, String businessKey, Map<String, Object> variables) {
    return managementService.executeCommand(new StartProcessNameProcessInstanceCmd<ProcessInstance>(procName,
            processDefinitionId, businessKey
            , variables));
  }

  public ProcessInstance startProcessInstanceById(String procName, String processDefinitionKey, Map<String, Object> variables) {
    return managementService.executeCommand(new StartProcessInstanceCmd<ProcessInstance>(procName, processDefinitionKey, null,variables));
  }
}
