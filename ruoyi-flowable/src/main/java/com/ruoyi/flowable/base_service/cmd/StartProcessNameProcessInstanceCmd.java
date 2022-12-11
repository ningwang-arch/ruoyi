package com.ruoyi.flowable.base_service.cmd;

import org.flowable.engine.impl.cmd.StartProcessInstanceCmd;

import java.util.Map;

public class StartProcessNameProcessInstanceCmd<T> extends StartProcessInstanceCmd<T> {
  public StartProcessNameProcessInstanceCmd(String processDefinitionKey, String processDefinitionId, String businessKey, Map<String, Object> variables) {
    super(processDefinitionKey, processDefinitionId, businessKey, variables);
    this.processInstanceName = processInstanceName;
  }
}

