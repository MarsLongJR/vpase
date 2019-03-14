package com.xbz.vpase.dao.impl;


import com.xbz.vpase.dao.SysUserDao;

import com.xbz.vpase.dao.base.impl.BaseDaoImpl;
import com.xbz.vpase.persistent.entity.SysUser;
import com.xbz.vpase.request.SysUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository("sysUserDao")

public class SysUserDaoImpl extends BaseDaoImpl<SysUser> implements SysUserDao {

    @Override
    public SysUser selectSysUserByAccount(String account) {
        return sqlSessionTemplate.selectOne("SysUser.selectSysUserByAccount",account);
    }

    //注册查询重复
    @Override
    public int checkUser(String account) {
        return sqlSessionTemplate.selectOne("SysUser.checkUser",account);
    }

    @Override
    public SysUser queryUserByPhone(String phone) {
        return sqlSessionTemplate.selectOne("SysUser.queryUserByPhone");
    }

    @Override
    public SysUser selectSysUserByOpenId(String openId) {
        return sqlSessionTemplate.selectOne("SysUser.selectSysUserByOpenId",openId);
    }
}
