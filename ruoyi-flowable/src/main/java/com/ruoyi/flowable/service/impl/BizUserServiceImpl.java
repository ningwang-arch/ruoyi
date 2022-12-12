package com.ruoyi.flowable.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.flowable.domain.vo.TugFeeVo;
import com.ruoyi.flowable.mapper.TugFeeVoMapper;
import com.ruoyi.flowable.service.IBizUserService;
import com.ruoyi.system.domain.FlowProcDefDto;
import com.ruoyi.system.mapper.FlowDeployMapper;
import com.ruoyi.system.mapper.SysDictDataMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class BizUserServiceImpl implements IBizUserService {
    @Resource
    private FlowDeployMapper flowDeployMapper;

    @Resource
    private TugFeeVoMapper tugFeeVoMapper;

    @Resource
    private SysDictDataMapper sysDictDataMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public FlowProcDefDto getLatestRecord() {
        return flowDeployMapper.getLatestRecord();
    }

    @Override
    public AjaxResult getFinishedList(Integer pageNum, Integer pageSize) {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Page<TugFeeVo> page = new Page<>();
        PageHelper.startPage(pageNum, pageSize);
        List<TugFeeVo> dataList = tugFeeVoMapper.getFinishedList(user.getUserId());
        page.setRecords(dataList);
        page.setTotal(new PageInfo<>(dataList).getTotal());
        return AjaxResult.success(page);
    }

    @Override
    public AjaxResult getDictData(String dictType) {
        return AjaxResult.success(sysDictDataMapper.selectDictDataByType(dictType));
    }

    @Override
    public AjaxResult getUserList(Integer role) {
        return AjaxResult.success(sysUserMapper.selectUserListByRoleId(role.longValue()));
    }
}
