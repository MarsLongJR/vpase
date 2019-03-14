package com.xbz.vpase.dao;

import com.xbz.vpase.dao.base.BaseDao;
import com.xbz.vpase.persistent.entity.SysUserRole;

public interface SysUserRoleDao extends BaseDao<SysUserRole> {

    SysUserRole selectUserRoleByUserId(Integer userId);

    void deleteUserRoleByUserId(Integer userId);
}
