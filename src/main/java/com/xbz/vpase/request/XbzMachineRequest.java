package com.xbz.vpase.request;

import com.xbz.vpase.request.base.BaseRequest;

import java.util.Date;

/**
 * @company:www.xinbeize.com
 * @author:Mars
 */
public class XbzMachineRequest extends BaseRequest {
    private Integer id;

    private String machineName;

    private String machineCode;

    private Short machineType;

    private Date createTime;

    private Short status;

    private Boolean connectStatus;

    private Short temperatureStatus;

    private Integer addressId;

    private String openTime;

    private String offTime;

    private String startDate;

    private String endDate;

    private Integer channelNum;

    private Integer creatorId;

    private String creator;

    private String province;

    private String city;

    private String adressDetail;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public Short getMachineType() {
        return machineType;
    }

    public void setMachineType(Short machineType) {
        this.machineType = machineType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Boolean getConnectStatus() {
        return connectStatus;
    }

    public void setConnectStatus(Boolean connectStatus) {
        this.connectStatus = connectStatus;
    }

    public Short getTemperatureStatus() {
        return temperatureStatus;
    }

    public void setTemperatureStatus(Short temperatureStatus) {
        this.temperatureStatus = temperatureStatus;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getOffTime() {
        return offTime;
    }

    public void setOffTime(String offTime) {
        this.offTime = offTime;
    }

    public Integer getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(Integer channelNum) {
        this.channelNum = channelNum;
    }

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

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdressDetail() {
        return adressDetail;
    }

    public void setAdressDetail(String adressDetail) {
        this.adressDetail = adressDetail;
    }


}
