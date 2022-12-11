package com.ruoyi.flowable.domain.vo;

import com.ruoyi.flowable.domain.CommentData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BizFlowTaskVo extends FlowTaskVo {
    private CommentData commentData;
}
