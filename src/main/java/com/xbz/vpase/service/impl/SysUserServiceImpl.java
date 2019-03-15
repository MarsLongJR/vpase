package com.xbz.vpase.service.impl;

import com.xbz.vpase.dao.SysUserDao;
import com.xbz.vpase.persistent.entity.SysUser;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.service.SysUserService;
import com.xbz.vpase.service.base.impl.BaseServiceImpl;
import com.xbz.vpase.utils.MD5;
import com.xbz.vpase.utils.TextUtil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    @Resource
    public void setBaseDao(SysUserDao sysUserDao) {
        super.setBaseDao(sysUserDao);
    }


    /**
     * 注册用户
     * @param sysUser 用户对象
     * @return
     */
    @Override
    public int insertUser(SysUser sysUser) {
        //没有添加参数
        if(sysUser.isEmpty()){
            return 0;
        } else{
            String password = MD5.getMD5(sysUser.getPassword());
            sysUser.setPassword(password);
            int count = sysUserDao.save(sysUser);
            if (count == 1) {
                return 1;
            }
            throw new RuntimeException("添加用户信息失败：service");
        }
    }
    //查询重复
    @Override
    public SysUser queryUserByPhone(String phone) {
        return sysUserDao.queryUserByPhone(phone);
    }

    @Override
    public void insertUserCode(String phone, String code) {
    }

    @Override
    public void updateUserPwd(String account, String md5) {

    }

    @Override
    public void cleanCaptcha(String account) {

    }

    @Override
    public SysUser selectSysUserByAccount(String account) {
       return sysUserDao.selectSysUserByAccount(account);
    }

    @Override
    public ResultJson register(String account, String password) {
        ResultJson resultJson = new ResultJson();
        try {
            SysUser sysUser = selectSysUserByAccount(account);
            if(sysUser!=null){

            }else{
//                SysUser user =
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SysUser selectSysUserByOpenId(String openId) {
        return sysUserDao.selectSysUserByOpenId(openId);
    }

    public SysUser registerSysUser(String account, String password,String userName,String userCode,String phone,String email,String openId,Boolean firstLogin,String imageUrl,Boolean enable){
        try {
            SysUser user = new SysUser();
            if(!TextUtil.isEmpty(account)){
                user.setAccount(account);
            }
            if(!TextUtil.isEmpty(password)){
                user.setPassword(MD5.getMD5(password));
            }
            if(!TextUtil.isEmpty(userName)){
                user.setUserName(userName);
            }
            if(!TextUtil.isEmpty(userCode)){

            }


        }catch (Exception e){
            e.printStackTrace();
        }
            return null;

    }

}
