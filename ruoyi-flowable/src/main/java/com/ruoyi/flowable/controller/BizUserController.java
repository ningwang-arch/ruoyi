package com.ruoyi.flowable.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.flowable.domain.vo.TugFeeVo;
import com.ruoyi.flowable.service.IBizUserService;
import com.ruoyi.system.domain.FlowProcDefDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "自定义接口")
@RestController
@RequestMapping("/api/user")
public class BizUserController {
    @Autowired
    private IBizUserService bizUserService;

    @GetMapping("/get")
    @ApiOperation(value = "获取最新流程信息", response = FlowProcDefDto.class)
    public AjaxResult get_latest_record() {
        // todo
        return AjaxResult.success(bizUserService.getLatestRecord());
    }

    @GetMapping("/finishedList")
    @ApiOperation(value = "获取已完成流程列表", response = TugFeeVo.class)
    public AjaxResult get_finished_list(@ApiParam(value = "当前页码", required = true) @RequestParam Integer pageNum,
                                        @ApiParam(value = "每页条数", required = true) @RequestParam Integer pageSize) {
        // todo
        return bizUserService.getFinishedList(pageNum, pageSize);
    }

    @GetMapping("/getDictData")
    public AjaxResult getDictData(@ApiParam(value = "字典类型", required = true) @RequestParam String dictType) {
        return bizUserService.getDictData(dictType);
    }
}
