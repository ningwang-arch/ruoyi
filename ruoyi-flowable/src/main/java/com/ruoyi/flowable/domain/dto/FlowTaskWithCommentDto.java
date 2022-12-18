package com.ruoyi.flowable.domain.dto;

import com.ruoyi.flowable.domain.CommentData;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FlowTaskWithCommentDto extends FlowTaskDto {
    private CommentData commentData;
}
