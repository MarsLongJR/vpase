package com.xbz.vpase.persistent.entity;

import java.io.Serializable;

public class XbzAddress implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer cityId;

    private String address;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVipId() {
        return userId;
    }

    public void setVipId(Integer vipId) {
        this.userId = vipId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}