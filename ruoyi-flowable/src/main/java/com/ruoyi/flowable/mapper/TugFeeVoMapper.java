package com.ruoyi.flowable.mapper;

import com.ruoyi.flowable.domain.vo.TugFeeVo;

import java.util.List;
import java.util.Map;

public interface TugFeeVoMapper {
    List<TugFeeVo> queryByParams(Map<String, Object> map);

    TugFeeVo queryById(Long id);

    List<TugFeeVo> getFinishedList(Long userId);
}
