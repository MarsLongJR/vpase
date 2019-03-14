package com.xbz.vpase.dao.impl;

import com.xbz.vpase.dao.SysRoleDao;
import com.xbz.vpase.dao.base.impl.BaseDaoImpl;
import com.xbz.vpase.persistent.entity.SysRole;
import com.xbz.vpase.request.SysRoleRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sysRoleDao")
public class SysRoleDaoImpl extends BaseDaoImpl<SysRole> implements SysRoleDao {

    @Override
    public List<SysRole> selectSysRoleList(SysRoleRequest request) {
        return sqlSessionTemplate.selectList("SysRole.selectSysRoleList",request);
    }

    @Override
    public Integer selectSysRoleCount(SysRoleRequest request) {
        return sqlSessionTemplate.selectOne("SysRole.selectSysRoleCount",request);
    }

    @Override
    public SysRole selectSysRoleByRoleName(String roleName) {
        return sqlSessionTemplate.selectOne("SysRole.selectSysRoleByRoleName",roleName);
    }
}
