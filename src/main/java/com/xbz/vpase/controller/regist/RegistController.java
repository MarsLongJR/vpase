package com.xbz.vpase.controller.regist;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.xbz.vpase.persistent.entity.SysUser;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.service.SysUserService;
import com.xbz.vpase.utils.SendMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @company:www.xinbeize.com
 * @author:Mars
 */

@Controller
@RequestMapping("regist")
public class RegistController {

   @Autowired
    private SysUserService sysUserService;

    /**
     * 注册
     * @param sysUser
     * @return result
     */
    @RequestMapping("getRegist_allow")
    @ResponseBody
    public ResultJson regist( @RequestBody (required = false) SysUser sysUser) {
        ResultJson resultJson = new ResultJson();
       try {
           //用户没有填内容
           if (sysUser.isEmpty()) {
               resultJson.ResultJson(RetCode.PARAM_NULL);
               resultJson.setMessage("没有填内容");
               return resultJson;
           }
           //注册
           int count = sysUserService.insertUser(sysUser);
           if (count == 0) {
               resultJson.ResultJson(RetCode.OK);
               resultJson.setMessage("用户信息添加失败");
               return resultJson;
           }

           if (count == 1) {
               resultJson.ResultJson(RetCode.OK);
               resultJson.setMessage("注册成功");
               return resultJson;
           }
           return resultJson;
        } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }

    /**
     * 发送短信验证码
     * @param phone 电话号码
     * @return Json
     */
    @RequestMapping("getCode_allow")
    @ResponseBody
    public ResultJson sendTestCode(@RequestParam(value="phone",defaultValue="") String phone){

        ResultJson resultJson = new ResultJson();
        String code = SendMsg.createCode();

        // 短信发送状态(默认失败)
        boolean sendMsgState = false;
        try {
            // 阿里云短信
            SendSmsResponse sendSmsResponse = SendMsg.sendCaptcha(phone,code,"鑫倍则",null);
            if(sendSmsResponse.getCode().equals("OK")){
                sendMsgState = true;
            }
            if(phone == null || phone.length()==0){
                resultJson.ResultJson(RetCode.NO_INPUT_PHONE);
                resultJson.setMessage("用户没有输入手机号");
                return resultJson;
            }
            if(sendSmsResponse.getCode().equals("isv.BUSINESS_LIMIT_CONTROL")){
                resultJson.ResultJson(RetCode.ERROR);
                resultJson.setMessage("短信发送过于频繁");
                return resultJson;
            }
            if(sendSmsResponse.getCode().equals("isv.MOBILE_NUMBER_ILLEGAL")){
                resultJson.ResultJson((RetCode.ERROR));
                resultJson.setMessage("非法手机号");
                return resultJson;
            }
            if( code== null || code.length()==0){
                resultJson.ResultJson(RetCode.SEND_MESSAGE_ERROR);
                resultJson.setMessage("验证码发送出现异常");
                return resultJson;
            }
        } catch (Exception e) {
            resultJson.ResultJson(RetCode.SEND_MESSAGE_ERROR);
            resultJson.setMessage("注册失败");
        }

        // 判断短信接口返回状态
        if(sendMsgState){
            resultJson.ResultJson(RetCode.OK);
            resultJson.setData(code);
            return resultJson;
        }
            resultJson.ResultJson(RetCode.ERROR);
            return resultJson;
    }

}
