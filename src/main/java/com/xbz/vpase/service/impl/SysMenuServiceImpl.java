package com.xbz.vpase.service.impl;

import com.xbz.vpase.dao.SysMenuDao;
import com.xbz.vpase.dao.SysRoleMenuDao;
import com.xbz.vpase.dao.SysUserRoleDao;
import com.xbz.vpase.persistent.entity.SysMenu;
import com.xbz.vpase.persistent.entity.SysRoleMenu;
import com.xbz.vpase.request.SysRoleRequest;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.service.SysMenuService;
import com.xbz.vpase.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu> implements SysMenuService {

    @Resource
    private SysMenuDao sysMenuDao;

    @Resource
    private SysUserRoleDao sysUserRoleDao;

    @Resource
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    public List<SysMenu> selectAllMenuByFirstMenu(Integer roleId) {
//        Integer userId = ((UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        try {
//            if(roleId==null){
//                roleId = sysUserRoleDao.selectUserRoleByUserId(userId).getRoleId();
//            }
            List<SysMenu> menus = sysMenuDao.selectFirstLevelMenu(roleId);
            return menus;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 修改角色对应的菜单
     */
    @Override
    public ResultJson modifyRoleMenuByRole(SysRoleRequest roleRequest) {
        ResultJson resultJson = new ResultJson();
        try {
            sysRoleMenuDao.deleteRoleMenuByRoleId(roleRequest.getId());
            List<SysMenu> menus = roleRequest.getSysMenus();
            for(SysMenu menu:menus){
                SysRoleMenu roleMenu = new SysRoleMenu();
                roleMenu.setMenuId(menu.getId());
                roleMenu.setRoleId(roleRequest.getId());
            }
            resultJson.ResultJson(RetCode.OK);
        }catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return resultJson;
    }

}
