package com.ruoyi.flowable.domain;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentData implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long calculatorId;
    private Long reviewerId;
    private Long amount;
    private String calculatorComment;
    private String reviewerComment;
    private String applicantComment;

    public static CommentData fromString(String str) {
        try {
            return JSON.parseObject(str, CommentData.class);
        } catch (Exception e) {
            return new CommentData();
        }
    }
    

    public String toString() {
        return JSON.toJSONString(this);
    }

}


