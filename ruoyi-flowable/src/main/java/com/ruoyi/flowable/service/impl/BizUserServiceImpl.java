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
        for (TugFeeVo tugFeeVo : dataList) {
            setPasswordNull(tugFeeVo);
        }
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
        List<SysUser> users = sysUserMapper.selectUserListByRoleId(Long.valueOf(role));
        for (SysUser user : users) {
            user.setPassword(null);
            user.setSalt(null);
        }

        return AjaxResult.success(users);
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
}
