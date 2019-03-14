package com.xbz.vpase.dao.impl;

import com.xbz.vpase.dao.SysMenuDao;
import com.xbz.vpase.dao.base.impl.BaseDaoImpl;
import com.xbz.vpase.persistent.entity.SysMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sysMenuDao")
public class SysMenuDaoImpl extends BaseDaoImpl<SysMenu> implements SysMenuDao {

    @Override
    public List<SysMenu> selectFirstLevelMenu(Integer roleId) {
        return sqlSessionTemplate.selectList("SysMenu.selectFirstLevelMenu",roleId);
    }
}
