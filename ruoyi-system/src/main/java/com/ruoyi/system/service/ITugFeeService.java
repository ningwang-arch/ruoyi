package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TugFee;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-12-06
 */
public interface ITugFeeService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public TugFee selectTugFeeById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tugFee 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TugFee> selectTugFeeList(TugFee tugFee);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tugFee 【请填写功能名称】
     * @return 结果
     */
    public int insertTugFee(TugFee tugFee);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tugFee 【请填写功能名称】
     * @return 结果
     */
    public int updateTugFee(TugFee tugFee);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTugFeeByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTugFeeById(Long id);
}
