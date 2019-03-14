package com.xbz.vpase.dao;

import com.xbz.vpase.dao.base.BaseDao;
import com.xbz.vpase.persistent.entity.SysRole;
import com.xbz.vpase.request.SysRoleRequest;

import java.util.List;

public interface SysRoleDao extends BaseDao<SysRole> {

    List<SysRole> selectSysRoleList(SysRoleRequest request);

    Integer selectSysRoleCount(SysRoleRequest request);

    SysRole selectSysRoleByRoleName(String roleName);
}
