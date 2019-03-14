package com.xbz.vpase.dao;

import com.xbz.vpase.dao.base.BaseDao;
import com.xbz.vpase.persistent.entity.SysMenu;

import java.util.List;

public interface SysMenuDao extends BaseDao<SysMenu> {

    List<SysMenu> selectFirstLevelMenu(Integer roleId);
}
