package com.ruoyi.flowable.domain;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@Getter
@Setter
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
        if (StringUtils.isBlank(str)) {
            return new CommentData();
        }
        try {
            return JSON.parseObject(str, CommentData.class);
        } catch (Exception e) {
            return new CommentData();
        }
    }

    public static void main(String[] args) {
        CommentData commentData = CommentData.fromString("abc");
        System.out.println(commentData);

        CommentData cd = new CommentData();
        System.out.println(cd);
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

}


