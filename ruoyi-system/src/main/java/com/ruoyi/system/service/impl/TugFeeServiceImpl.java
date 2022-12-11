package com.ruoyi.system.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.TugFee;
import com.ruoyi.system.mapper.TugFeeMapper;
import com.ruoyi.system.service.ITugFeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-12-06
 */
@Service
public class TugFeeServiceImpl implements ITugFeeService {
    @Resource
    private TugFeeMapper tugFeeMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public TugFee selectTugFeeById(Long id) {
        return tugFeeMapper.selectTugFeeById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tugFee 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TugFee> selectTugFeeList(TugFee tugFee) {
        return tugFeeMapper.selectTugFeeList(tugFee);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param tugFee 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTugFee(TugFee tugFee) {
        tugFee.setCreateTime(DateUtils.getNowDate());
        return tugFeeMapper.insertTugFee(tugFee);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param tugFee 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTugFee(TugFee tugFee) {
        tugFee.setUpdateTime(DateUtils.getNowDate());
        return tugFeeMapper.updateTugFee(tugFee);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteTugFeeByIds(Long[] ids) {
        return tugFeeMapper.deleteTugFeeByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteTugFeeById(Long id) {
        return tugFeeMapper.deleteTugFeeById(id);
    }
}
