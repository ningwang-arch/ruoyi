package com.ruoyi.flowable.domain;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CommentData implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long calculatorId;
    private Long reviewerId;
    private Long amount;
    private String calculatorComment;
    private String reviewerComment;
    private String applicantComment;

    public CommentData() {
        this.calculatorId = 0L;
        this.reviewerId = 0L;
        this.amount = 0L;
        this.calculatorComment = "";
        this.reviewerComment = "";
        this.applicantComment = "";
    }

    public static CommentData fromString(String str) {
        try {
            return JSON.parseObject(str, CommentData.class);
        } catch (Exception e) {
            return new CommentData();
        }
    }

    public static void main(String[] args) {
        CommentData commentData = CommentData.fromString("abc");
        System.out.println(commentData);
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

}


