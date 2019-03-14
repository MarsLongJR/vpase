package com.xbz.vpase.controller.permission;

import com.xbz.vpase.persistent.entity.SysRole;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 根据当前登录用户查询用户角色
     * @return
     */
    @RequestMapping("selectSysRoleByUserId")
    public ResultJson selectSysRoleByUserId(Integer userId){
        ResultJson resultJson = new ResultJson();
        try {
            SysRole role = sysRoleService.selectSysRoleByUserId(userId);
            resultJson.ResultJson(RetCode.OK);
            resultJson.setData(role);
        }catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return  resultJson;
    }

    /**
     * 分页查询角色
     * @param roleName
     * @param isManager
     * @param type
     * @param startDate
     * @param endDate
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("selectSysRolePage")
    public @ResponseBody Map<String,Object> selectSysRolePage(Integer id,String roleName, Boolean isManager, Short type, String startDate, String endDate, Integer pageNum, Integer pageSize){
        try {
            Map<String ,Object> objectMap = new HashMap<>();
            List<SysRole> roles = sysRoleService.selectSysRoleList(id,roleName,isManager,type,startDate,endDate,pageNum,pageSize);
            Integer totalCount = sysRoleService.selectSysRoleCount(id,roleName,isManager,type,startDate,endDate);
            objectMap.put("list",roles);
            objectMap.put("totalCount",totalCount);
            return objectMap;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 修改用户权限
     * @param userId
     * @return
     */
    @RequestMapping("modifySysRoleByUserId")
    public ResultJson modifySysRoleByUserId(Integer userId,Integer roleId){
        ResultJson resultJson = new ResultJson();
        try {
            resultJson = sysRoleService.modifySysRoleByUserId(userId,roleId);
        }catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return resultJson;
    }

    /**
     * 新增角色
     * @param roleName 角色名称
     * @param desc 角色描述
     * @param isManager 是否是管理员
     * @param type 所属方
     * @return
     */
    @RequestMapping("insertSysRole")
    public @ResponseBody ResultJson insertSysRole(String roleName,String desc,Boolean isManager,Short type){
        try {
            ResultJson  resultJson = sysRoleService.insertSysRole(roleName,desc,isManager,type);
        return resultJson;
        }catch (Exception e){
            e.printStackTrace();
          return null;
        }

    }
}
