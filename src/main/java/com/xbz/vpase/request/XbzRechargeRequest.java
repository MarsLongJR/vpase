package com.xbz.vpase.request;

import com.xbz.vpase.request.base.BaseRequest;

import java.math.BigDecimal;

public class XbzRechargeRequest extends BaseRequest {

    private String startDate;

    private String endDate;

    private Integer userId;

    private BigDecimal accounts;

    private Short status;

    private Short payType;

    private Boolean enable;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getAccounts() {
        return accounts;
    }

    public void setAccounts(BigDecimal accounts) {
        this.accounts = accounts;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getPayType() {
        return payType;
    }

    public void setPayType(Short payType) {
        this.payType = payType;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
