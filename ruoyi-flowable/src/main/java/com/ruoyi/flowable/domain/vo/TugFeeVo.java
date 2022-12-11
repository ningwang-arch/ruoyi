package com.ruoyi.flowable.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TugFeeVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 拖船计费单编号
     */
    private Long id;

    /**
     * 船名
     */
    @Excel(name = "船名")
    private String shipName;

    /**
     * 船舶类型：客船:0
     * 货船:1
     */
    @Excel(name = "船舶类型：客船:0 货船:1")
    private String shipType;

    /**
     * 大船的长度（米）
     */
    @Excel(name = "大船的长度", readConverterExp = "米=")
    private Long length;

    /**
     * 大船吃水的深度
     */
    @Excel(name = "大船吃水的深度")
    private Long depth;

    /**
     * 工作类型
     */
    @Excel(name = "工作类型")
    private String workType;

    /**
     * 作业地点
     */
    @Excel(name = "作业地点")
    private String workPlace;

    /**
     * 作业时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "作业时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date workTime;

    /**
     * 所需拖轮数
     */
    @Excel(name = "所需拖轮数")
    private Long tugNum;

    /**
     * 单价
     */
    @Excel(name = "单价")
    private BigDecimal tugUnitPrice;

    /**
     * 应付费用
     */
    @Excel(name = "应付费用")
    private Long amount;

    /**
     * 状态,已提交：0，已计费：1
     * 已审核：2
     * 船代通过：3
     */
    @Excel(name = "状态,已提交：0，已计费：1 已审核：2  船代通过：3")
    private String state;

    /**
     * 船代id
     */
    @Excel(name = "船代")
    private SysUser applicant;

    /**
     * 复核员id
     */
    @Excel(name = "复核员")
    private SysUser reviewer;

    /**
     * 计费员id
     */
    @Excel(name = "计费员")
    private SysUser caculator;

    /**
     * 管理员id
     */
    @Excel(name = "管理员id")
    private SysUser admin;

    /**
     * 计费员备注
     */
    @Excel(name = "计费员备注")
    private String caculatorComment;

    /**
     * 审核员备注
     */
    @Excel(name = "审核员备注")
    private String reviewerComment;

    /**
     * 船代备注
     */
    @Excel(name = "船代备注")
    private String applicantComment;

    private String applicantConfirmComment;

    /**
     * 提交申请时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提交申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applicateTime;

    /**
     * 管理员确认时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "管理员确认时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date adminConfirmTime;

    /**
     * 计费员计费时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计费员计费时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date caculateTime;

    /**
     * 复核员复合时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "复核员复合时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reviewTime;

    /**
     * 船代确认时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "船代确认时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applicantConfirmTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 逻辑删除
     */
    @Excel(name = "逻辑删除")
    private Integer delete;
}
