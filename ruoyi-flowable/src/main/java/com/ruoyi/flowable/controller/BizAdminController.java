package com.ruoyi.flowable.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.flowable.domain.dto.FlowTaskDto;
import com.ruoyi.flowable.domain.vo.TugFeeVo;
import com.ruoyi.flowable.service.IBizAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@Api(tags = "流程定义")
@RestController
@RequestMapping("/api/admin")
public class BizAdminController {

    @Autowired
    private IBizAdminService bizAdminService;

    @GetMapping("/myProcess")
    @ApiOperation(value = "获取我的流程", response = TugFeeVo.class)
    public AjaxResult myProcess(@ApiParam(value = "当前页码", required = true) @RequestParam Integer pageNum,
                                @ApiParam(value = "每页条数", required = true) @RequestParam Integer pageSize,
                                @ApiParam(value = "船名") @RequestParam(required = false) String name,
                                @ApiParam(value = "开始时间") @RequestParam(required = false) Date startTime,
                                @ApiParam(value = "船舶类型") @RequestParam(required = false) String shipType
    ) {
        return bizAdminService.myProcess(pageNum, pageSize, name, startTime, shipType);
    }

    @GetMapping("/record")
    @ApiOperation(value = "历史流转记录", response = FlowTaskDto.class)
    public AjaxResult record(String tugFeeId) {
        return bizAdminService.record(tugFeeId);
    }
}
