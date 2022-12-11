package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TugFee;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2022-12-06
 */

public interface TugFeeMapper {
    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    TugFee selectTugFeeById(Long id);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tugFee 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    List<TugFee> selectTugFeeList(TugFee tugFee);

    /**
     * 新增【请填写功能名称】
     *
     * @param tugFee 【请填写功能名称】
     * @return 结果
     */
    int insertTugFee(TugFee tugFee);

    /**
     * 修改【请填写功能名称】
     *
     * @param tugFee 【请填写功能名称】
     * @return 结果
     */
    int updateTugFee(TugFee tugFee);

    /**
     * 删除【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    int deleteTugFeeById(Long id);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTugFeeByIds(Long[] ids);
}
