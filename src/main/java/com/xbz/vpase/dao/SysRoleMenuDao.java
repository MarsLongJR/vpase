package com.xbz.vpase.dao;

import com.xbz.vpase.dao.base.BaseDao;
import com.xbz.vpase.persistent.entity.SysRoleMenu;

public interface SysRoleMenuDao extends BaseDao<SysRoleMenu> {

    void deleteRoleMenuByRoleId(Integer roleId);
}
