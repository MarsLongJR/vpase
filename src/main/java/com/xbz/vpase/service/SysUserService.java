package com.xbz.vpase.service;

import com.xbz.vpase.persistent.entity.SysUser;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.service.base.BaseService;

public interface SysUserService extends BaseService<SysUser> {
    SysUser selectSysUserByAccount(String account);

    ResultJson register(String account, String password);

    SysUser selectSysUserByOpenId(String openId);

    //新增用户的验证码
    void insertUserCode(String phone, String code);
    //根据用户查找用户账户
    SysUser queryUserByPhone(String phone);
    //更新用户的密码
    void updateUserPwd(String account, String md5);
    //删除用户的验证码
    void cleanCaptcha(String account);

    int insertUser(SysUser sysUser);
}
