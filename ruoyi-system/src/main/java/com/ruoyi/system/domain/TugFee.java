package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 【请填写功能名称】对象 tug_fee
 *
 * @author ruoyi
 * @date 2022-12-06
 */


public class TugFee extends BaseEntity {
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

    @Excel(name = "计算费用")
    private Long caculateAmount;

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
    @Excel(name = "船代id")
    private Long applicantId;

    /**
     * 复核员id
     */
    @Excel(name = "复核员id")
    private Long reviewerId;

    /**
     * 计费员id
     */
    @Excel(name = "计费员id")
    private Long caculatorId;

    /**
     * 管理员id
     */
    @Excel(name = "管理员id")
    private Long adminId;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getDepth() {
        return depth;
    }

    public void setDepth(Long depth) {
        this.depth = depth;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public Date getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    public Long getTugNum() {
        return tugNum;
    }

    public void setTugNum(Long tugNum) {
        this.tugNum = tugNum;
    }

    public BigDecimal getTugUnitPrice() {
        return tugUnitPrice;
    }

    public void setTugUnitPrice(BigDecimal tugUnitPrice) {
        this.tugUnitPrice = tugUnitPrice;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public Long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Long getCaculatorId() {
        return caculatorId;
    }

    public void setCaculatorId(Long caculatorId) {
        this.caculatorId = caculatorId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getCaculatorComment() {
        return caculatorComment;
    }

    public void setCaculatorComment(String caculatorComment) {
        this.caculatorComment = caculatorComment;
    }

    public String getReviewerComment() {
        return reviewerComment;
    }

    public void setReviewerComment(String reviewerComment) {
        this.reviewerComment = reviewerComment;
    }

    public String getApplicantComment() {
        return applicantComment;
    }

    public void setApplicantComment(String applicantComment) {
        this.applicantComment = applicantComment;
    }

    public Date getApplicateTime() {
        return applicateTime;
    }

    public void setApplicateTime(Date applicateTime) {
        this.applicateTime = applicateTime;
    }

    public Date getAdminConfirmTime() {
        return adminConfirmTime;
    }

    public void setAdminConfirmTime(Date adminConfirmTime) {
        this.adminConfirmTime = adminConfirmTime;
    }

    public Date getCaculateTime() {
        return caculateTime;
    }

    public void setCaculateTime(Date caculateTime) {
        this.caculateTime = caculateTime;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public Date getApplicantConfirmTime() {
        return applicantConfirmTime;
    }

    public void setApplicantConfirmTime(Date applicantConfirmTime) {
        this.applicantConfirmTime = applicantConfirmTime;
    }

    public Long getCaculateAmount() {
        return caculateAmount;
    }

    public void setCaculateAmount(Long caculateAmount) {
        this.caculateAmount = caculateAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("shipName", getShipName())
                .append("shipType", getShipType())
                .append("length", getLength())
                .append("depth", getDepth())
                .append("workType", getWorkType())
                .append("workPlace", getWorkPlace())
                .append("workTime", getWorkTime())
                .append("tugNum", getTugNum())
                .append("tugUnitPrice", getTugUnitPrice())
                .append("amount", getAmount())
                .append("state", getState())
                .append("applicantId", getApplicantId())
                .append("reviewerId", getReviewerId())
                .append("caculatorId", getCaculatorId())
                .append("adminId", getAdminId())
                .append("caculatorComment", getCaculatorComment())
                .append("reviewerComment", getReviewerComment())
                .append("applicantComment", getApplicantComment())
                .append("applicateTime", getApplicateTime())
                .append("adminConfirmTime", getAdminConfirmTime())
                .append("caculateTime", getCaculateTime())
                .append("reviewTime", getReviewTime())
                .append("applicantConfirmTime", getApplicantConfirmTime())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("caculateAmount", caculateAmount)
                .toString();
    }
}
