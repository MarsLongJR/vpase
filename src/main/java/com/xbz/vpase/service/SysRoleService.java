package com.xbz.vpase.service;

import com.xbz.vpase.persistent.entity.SysRole;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.service.base.BaseService;

import java.util.List;

public interface SysRoleService extends BaseService<SysRole> {

    SysRole selectSysRoleByUserId(Integer userId);

    List<SysRole> selectSysRoleList(Integer id,String roleName, Boolean isManager, Short type, String startDate, String endDate, Integer pageNum, Integer pageSize);

    Integer selectSysRoleCount(Integer id,String roleName, Boolean isManager, Short type, String startDate, String endDate);

    ResultJson modifySysRoleByUserId(Integer userId,Integer roleId);

    ResultJson insertSysRole(String roleName, String desc, Boolean isManager, Short type);
}
