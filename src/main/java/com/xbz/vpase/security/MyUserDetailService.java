package com.xbz.vpase.security;

import com.xbz.vpase.authorities.UserInfo;
import com.xbz.vpase.persistent.entity.SysRole;
import com.xbz.vpase.persistent.entity.SysUser;
import com.xbz.vpase.service.SysRoleService;
import com.xbz.vpase.service.SysUserService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MyUserDetailService implements UserDetailsService {
	@Resource
	private SysUserService sysUserService;

	@Resource
	private  SysRoleService sysRoleService;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();// 用户的权限集合
		if(username==null){
			throw new RuntimeException(MyAuthenticationFailureHandler.ACCOUNT_NO_EXIST);
		}
		SysUser sysUser = sysUserService.selectSysUserByAccount(username);
		if(sysUser==null){
			throw new RuntimeException(MyAuthenticationFailureHandler.ACCOUNT_NO_EXIST);
		}

		if(!sysUser.getEnable()){
			throw new RuntimeException(MyAuthenticationFailureHandler.ACCOUNT_BAN);
		}
		SysRole sysRole=sysRoleService.selectSysRoleByUserId(sysUser.getId());
		if(sysUser!=null){
			if(sysRole!=null){

				SimpleGrantedAuthority auth = new SimpleGrantedAuthority(
						"ROLE_GENERAL");// 根据权限名创建权限
				auths.add(auth);// 把权限添加进权限集合
			}
		}
		UserInfo user = new UserInfo(sysUser.getId(),sysUser.getAccount(),sysUser.getPassword(), sysUser.getUserName(),sysUser.getUserCode(), sysUser.getPhone(),sysUser.getEmail(),sysUser.getOpenId(),sysUser.getStatus(), sysUser.getCreateTime(),  sysUser.getCreateId(),sysUser.getFirstLogin(),sysUser.getModifierId(),sysUser.getModifyTime(),sysUser.getImageUrl(),sysUser.getLastTime(), (ArrayList<GrantedAuthority>) auths,true, true,
				true, true);
		return user;
	}

}
