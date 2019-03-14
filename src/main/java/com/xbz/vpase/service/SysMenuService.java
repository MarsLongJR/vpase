package com.xbz.vpase.service;

import com.xbz.vpase.persistent.entity.SysMenu;
import com.xbz.vpase.persistent.entity.SysRole;
import com.xbz.vpase.request.SysRoleRequest;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.service.base.BaseService;

import java.util.List;

public interface SysMenuService extends BaseService<SysMenu> {

    List<SysMenu> selectAllMenuByFirstMenu(Integer roleId);

    ResultJson modifyRoleMenuByRole(SysRoleRequest roleRequest);
}
