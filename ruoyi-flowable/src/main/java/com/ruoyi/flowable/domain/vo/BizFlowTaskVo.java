package com.ruoyi.flowable.domain.vo;

import com.ruoyi.flowable.domain.CommentData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BizFlowTaskVo extends FlowTaskVo {
    private CommentData commentData;
}
