package com.xbz.vpase.controller.permission;

import com.xbz.vpase.persistent.entity.SysMenu;
import com.xbz.vpase.request.SysRoleRequest;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     *分页查询菜单
     * @param id
     * @param parent
     * @param level
     * @param enable
     * @param roleId
     * @return
     */
    @RequestMapping("selectSysMenuPage")
    public @ResponseBody ResultJson selectSysMenuPage(Integer id, Integer parent, Integer level, Boolean enable, Integer roleId){
        ResultJson resultJson = new ResultJson();
        try {


        }catch (Exception e){
            e.printStackTrace();
        }
        return resultJson;
    }

    /**
     * 根据roleId查询菜单
     * @param roleId
     * @return
     */
    @RequestMapping("selectAllMenuByFirstMenu")
    public  @ResponseBody ResultJson selectFirstLevelMenu(Integer roleId){
        ResultJson resultJson = new ResultJson();
        try {
            List<SysMenu> menus = sysMenuService.selectAllMenuByFirstMenu(roleId);
            resultJson.ResultJson(RetCode.OK);
            resultJson.setData(menus);
        }catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return resultJson;
    }

    /**
     * 修改角色菜单
     * @param roleRequest
     * @return
     */
    @RequestMapping("modifyRoleMenuByRole")
    public @ResponseBody ResultJson modifyRoleMenuByRole(@RequestBody SysRoleRequest roleRequest){
        try {
            ResultJson resultJson = sysMenuService.modifyRoleMenuByRole(roleRequest);
            return resultJson;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
