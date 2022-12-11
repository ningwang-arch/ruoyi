package com.ruoyi.flowable.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentData {
    private Long calculatorId;
    private Long reviewerId;
    private Long amount;
    private String calculatorComment;
    private String reviewerComment;
    private String applicantComment;
}
