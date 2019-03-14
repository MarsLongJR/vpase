package com.xbz.vpase.dao.impl;

import com.xbz.vpase.dao.SysUserRoleDao;
import com.xbz.vpase.dao.base.impl.BaseDaoImpl;
import com.xbz.vpase.persistent.entity.SysUserRole;
import org.springframework.stereotype.Repository;

@Repository("sysUserRoleDao")
public class SysUserRoleDaoImpl extends BaseDaoImpl<SysUserRole> implements SysUserRoleDao {

    @Override
    public SysUserRole selectUserRoleByUserId(Integer userId) {
        return sqlSessionTemplate.selectOne("SysUserRole.selectUserRoleByUserId",userId);
    }

    @Override
    public void deleteUserRoleByUserId(Integer userId) {
        sqlSessionTemplate.delete("SysUserRole.deleteUserRoleByUserId",userId);
    }
}
