package com.xbz.vpase.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.xbz.vpase.persistent.entity.SysUser;
import com.xbz.vpase.persistent.entity.UpdatePwd.UpdatePwdInfo;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.service.SysUserService;
import com.xbz.vpase.utils.MD5;
import com.xbz.vpase.utils.SendMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 忘记密码（手机号找回）
 * @company:www.xinbeize.com
 * @author:Mars
 */
@Controller
@RequestMapping("forget")
public class UserController {
    /**
     * 验证手机短信是否发送成功
     *
     * @throws Exception
     */
    @Autowired
    SysUserService sysUserService;
    //跳转到重设密码页面
    @RequestMapping("forgetpwd_allow")
    public String findPassword(){
        return "findpassword";
    }

    @RequestMapping("sendphone_allow")
    @ResponseBody
    public ResultJson sendPhoneCode(String phone) {
        ResultJson result = new ResultJson();
        SysUser sysUser = sysUserService.queryUserByPhone(phone);
        //根据账户判断用户是否存在
        if (sysUser == null) {
            result.ResultJson(RetCode.NO_EXIST);
            result.setMessage("手机号不存在");
            return result;
        }
        //发送短信
        String code = SendMsg.createCode();
        boolean sendMsgState = false;
        try {
            // 阿里云短信
            SendSmsResponse sendSmsResponse = SendMsg.sendCaptcha(phone, code, "鑫倍则", "123");
            if (sendSmsResponse.getCode().equals("OK")) {
                sendMsgState = true;
            }
        } catch (Exception e) {
            result.ResultJson(RetCode.SEND_MESSAGE_ERROR);
            result.setMessage("系统异常");
        }
        if (sendMsgState) {
            result.ResultJson(RetCode.OK);
            result.setData(code);
            sysUserService.insertUserCode(phone,code);
            return result;
        }else{
            //发送失败，提醒
            result.ResultJson(RetCode.ERROR);
            result.setMessage("验证码发送异常");
            return result;
        }
    }
    /**
     * 提交重置密码请求，包括新密码
     *
     * @return
     */
    @RequestMapping("resetpwd_allow")
    public ResultJson resetPassword(UpdatePwdInfo info) {
        ResultJson result = new ResultJson();
        SysUser sysUser = sysUserService.queryUserByPhone(info.getPhone());
        //根据账户判断用户是否存在
        if (sysUser == null) {
            result.ResultJson(RetCode.OK);
            result.setMessage("用户不存在");
            return result;
        } else {
            String captcha = info.getCode();
            if (captcha != null && !captcha.equals("") && captcha.equals(sysUser.getCode())) {
                //验证失败了，返回重置密码的页面
                //验证成功了，更新密码，然后跳转到首页，重新让用户登录
                sysUserService.updateUserPwd(sysUser.getAccount(), MD5.getMD5(info.getNewPassword()));
                //删除验证码
                sysUserService.cleanCaptcha(sysUser.getAccount());
                result.ResultJson(RetCode.OK);
                result.setMessage("密码更改成功");
                return result;
            } else {
                //验证码不对或验证码不存在
                result.ResultJson(RetCode.ERROR);
                result.setMessage("验证码不正确");
                return result;
            }
        }
    }
}
