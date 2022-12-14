package com.ruoyi.flowable.domain.dto;

import com.ruoyi.flowable.domain.CommentData;
import lombok.Data;

@Data
public class FlowTaskWithCommentDto extends FlowTaskDto {
    private CommentData commentData;
}
