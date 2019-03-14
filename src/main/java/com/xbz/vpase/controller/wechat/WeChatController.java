package com.xbz.vpase.controller.wechat;

import com.xbz.vpase.persistent.entity.SysUser;
import com.xbz.vpase.service.SysUserService;
import com.xbz.vpase.utils.GsonUtil;
import com.xbz.vpase.utils.HttpsGetUtil;
import com.xbz.vpase.wechat.entity.WeChatSetting;
import com.xbz.vpase.wechat.entity.WeChatUserToken;
import com.xbz.vpase.wechat.utils.SignUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
/**
 * 关于微信
 */
@Controller
@RequestMapping("wechat")
public class WeChatController {

    @Autowired
    private SysUserService sysUserService;

    @Scope("request")
    @RequestMapping(value="/redirect",produces = "application/json;charset=UTF-8")
    public void loginRedirect(String code,HttpServletRequest request) {
        String url_0 = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WeChatSetting.APP_ID + "&secret=" + WeChatSetting.APP_SECRET + "&code=" + code + "&grant_type=authorization_code";
        ServletContext context = request.getServletContext();
        System.out.println(context.toString());
        String result = HttpsGetUtil.doHttpsGetJson(url_0);
        JSONObject jsonObject = JSONObject.fromObject(result);
        if (null != jsonObject) {
            if (jsonObject.containsKey("errcode")) {
                if (jsonObject.getString("errcode").equals("40029")) {
                    String newstr = url_0.substring(0, url_0.indexOf("&code=")).concat("&code=").concat(code);
                    //重新发起请求
                    result = HttpsGetUtil.doHttpsGetJson(newstr);
                }
            }
        }
        WeChatUserToken wxUserToken = GsonUtil.getGson().fromJson(result, WeChatUserToken.class);
        SysUser user = sysUserService.selectSysUserByOpenId(wxUserToken.getOpenid());
        request.getSession().setAttribute("openId", wxUserToken.getOpenid());
        if (user != null) {
            request.setAttribute("user", user);
        }
    }
}
