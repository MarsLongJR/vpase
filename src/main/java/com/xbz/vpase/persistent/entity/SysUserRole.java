package com.xbz.vpase.persistent.entity;

import java.io.Serializable;

public class SysUserRole implements Serializable {
    private Integer roleId;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}