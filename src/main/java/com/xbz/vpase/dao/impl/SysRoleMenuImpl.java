package com.xbz.vpase.dao.impl;

import com.xbz.vpase.dao.SysRoleMenuDao;
import com.xbz.vpase.dao.base.impl.BaseDaoImpl;
import com.xbz.vpase.persistent.entity.SysRoleMenu;
import org.springframework.stereotype.Repository;

@Repository("sysRoleMenuDao")
public class SysRoleMenuImpl extends BaseDaoImpl<SysRoleMenu> implements SysRoleMenuDao {

    @Override
    public void deleteRoleMenuByRoleId(Integer roleId) {
        sqlSessionTemplate.delete("SysRoleMenu.deleteRoleMenuByRoleId",roleId);
    }
}
