package com.xbz.vpase.service.impl;


import com.xbz.vpase.authorities.UserInfo;
import com.xbz.vpase.dao.SysRoleDao;
import com.xbz.vpase.dao.SysUserRoleDao;
import com.xbz.vpase.persistent.entity.SysRole;
import com.xbz.vpase.persistent.entity.SysUserRole;
import com.xbz.vpase.request.SysRoleRequest;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.service.SysRoleService;
import com.xbz.vpase.service.base.impl.BaseServiceImpl;
import com.xbz.vpase.utils.TextUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService {

    @Resource
    private SysRoleDao sysRoleDao;

    @Resource
    private SysUserRoleDao sysUserRoleDao;

    @Resource
    public void setBaseDao(SysRoleDao sysRoleDao) {
        super.setBaseDao(sysRoleDao);
    }


    /**
     * 判断参数是否为空
     * @param id 角色id
     * @param roleName 角色名称
     * @param isManager 是否是管理员
     * @param type 角色所属方
     * @param startDate 查询开始时间
     * @param endDate 查询结束时间
     * @param pageNum
     * @param pageSize
     * @return
     */
    private SysRoleRequest paramIsNull(Integer id,String roleName, Boolean isManager, Short type, String startDate, String endDate, Integer pageNum, Integer pageSize){
        try {
            SysRoleRequest request = new SysRoleRequest();
            if(id!=null){
                request.setId(id);
            }
            if(!TextUtil.isEmpty(roleName)){
                request.setRoleName(roleName);
            }
            if(isManager!=null){
                request.setManager(isManager);
            }
            if(type!=null){
                request.setType(type);
            }
            if(!TextUtil.isEmpty(startDate)){
                request.setStartDate(startDate+" 00:00:00");
            }
            if(!TextUtil.isEmpty(endDate)){
                request.setEndDate(endDate+" 23:59:59");
            }
            if(pageNum!=null&&pageSize!=null){
                request.setPage(pageNum,pageSize);
            }
            return request;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    @Override
    public SysRole selectSysRoleByUserId(Integer userId) {
        try {
            if(userId==null){
                userId= ((UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
            }
            SysUserRole userRole = sysUserRoleDao.selectUserRoleByUserId(userId);
            SysRole role = sysRoleDao.get(userRole.getRoleId());
            return role;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据条件分页查询角色
     * @param id
     * @param roleName
     * @param isManager
     * @param type
     * @param startDate
     * @param endDate
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<SysRole> selectSysRoleList(Integer id,String roleName, Boolean isManager, Short type, String startDate, String endDate, Integer pageNum, Integer pageSize) {
        try {
            SysRoleRequest request = paramIsNull(id,roleName,isManager,type,startDate,endDate,pageNum,pageSize);
            List<SysRole> roles = sysRoleDao.selectSysRoleList(request);
            return roles;
        }catch (Exception e){
            e.printStackTrace();

            return null;
        }
    }

    /**
     * 查询角色的总条数
     * @param id
     * @param roleName
     * @param isManager
     * @param type
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public Integer selectSysRoleCount(Integer id,String roleName, Boolean isManager, Short type, String startDate, String endDate) {
        try {
            SysRoleRequest request = paramIsNull(id,roleName,isManager,type,startDate,endDate,null,null);
            Integer count = sysRoleDao.selectSysRoleCount(request);
            return count;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 修改用户角色
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public ResultJson modifySysRoleByUserId(Integer userId,Integer roleId) {
        ResultJson resultJson = new ResultJson();
        try {
            if(userId!=null && roleId!=null){
                //删除当前用户角色
                sysUserRoleDao.deleteUserRoleByUserId(userId);
                SysUserRole sysUserRole = new SysUserRole();
                //插入新的用户角色
                sysUserRole.setRoleId(roleId);
                sysUserRole.setUserId(userId);
                sysUserRoleDao.save(sysUserRole);
                resultJson.ResultJson(RetCode.OK);
                resultJson.setMessage("修改成功！");
            }else{
                resultJson.ResultJson(RetCode.PARAM_NULL);
            }
        }catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return null;
    }

    /**
     *新增角色
     * @param roleName
     * @param desc
     * @param isManager
     * @param type
     * @return
     */
    @Override
    public ResultJson insertSysRole(String roleName, String desc, Boolean isManager, Short type) {
        ResultJson resultJson = new ResultJson();
        try {
            //根据角色名称查询角色是否存在
            SysRole sysRole = selectSysRoleByRoleName(roleName);
            if(!TextUtil.isEmpty(roleName)&&sysRole!=null){
                //存在，返回存在
                resultJson.ResultJson(RetCode.EXIST);
            }else{
                //不存在，新增
                SysRole role = new SysRole();
                role.setCreateTime(new Date());
                if(!TextUtil.isEmpty(desc)){
                role.setDesc(desc);
                }
                if(!TextUtil.isEmpty(roleName)){
                    role.setRoleName(roleName);
                }
                if(isManager!=null){
                    role.setIsManager(isManager);
                }
                if(type!=null){
                    role.setType(type);
                }
                sysRoleDao.save(role);
                resultJson.ResultJson(RetCode.OK);
                resultJson.setMessage("新增成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return resultJson;
    }

    /**
     * 根据角色名称查询角色是否存在
     * @param roleName
     * @return
     */
    public SysRole selectSysRoleByRoleName(String roleName){
        try {
            SysRole sysRole = new SysRole();
            if(!TextUtil.isEmpty(roleName)){
                sysRole = sysRoleDao. selectSysRoleByRoleName(roleName);
            }
            return sysRole;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
