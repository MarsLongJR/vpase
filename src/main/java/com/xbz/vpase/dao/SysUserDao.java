package com.xbz.vpase.dao;

import com.xbz.vpase.dao.base.BaseDao;
import com.xbz.vpase.persistent.entity.SysUser;
import com.xbz.vpase.request.SysUserRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;


public interface SysUserDao extends BaseDao<SysUser> {

    SysUser selectSysUserByAccount(String account);

    SysUser selectSysUserByOpenId(String openId);

    //查询重复
    int checkUser(String phone);

    //根据用户手机号查找用户账户
    SysUser queryUserByPhone(String phone);
}
