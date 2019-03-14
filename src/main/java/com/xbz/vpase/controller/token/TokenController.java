package com.xbz.vpase.controller.token;

import com.xbz.vpase.persistent.entity.SysUser;
import com.xbz.vpase.service.SysUserService;
import com.xbz.vpase.utils.GsonUtil;
import com.xbz.vpase.utils.HttpsGetUtil;
import com.xbz.vpase.wechat.entity.WeChat;
import com.xbz.vpase.wechat.entity.WeChatSetting;
import com.xbz.vpase.wechat.entity.WeChatUserToken;
import com.xbz.vpase.wechat.utils.SignUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("token")
public class TokenController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/getToken", method = RequestMethod.GET)
    public @ResponseBody
    String xxtInterface(WeChat wc) {
        System.out.println("/api");
//        微信加密签名
        String signature = wc.getSignature();
//        时间戳
        String timestamp = wc.getTimestamp();
//        随机数
        String nonce = wc.getNonce();
//        随机字符串
        String echostr = wc.getEchostr();

//         通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        } else {
            System.out.println("不是微信服务器发来的请求,请小心!");
            return null;
        }
    }

    @RequestMapping(value = "/getToken", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String getWeiXinMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        微信服务器POST消息时用的是UTF-8编码，在接收时也要用同样的编码，否则中文会乱码；
        request.setCharacterEncoding("UTF-8");
//        在响应消息（回复消息给用户）时，也将编码方式设置为UTF-8，原理同上；
        response.setCharacterEncoding("UTF-8");
//        初始化配置文件
        String respMessage = "";
        return respMessage;
    }

    @Scope("request")
    @RequestMapping(value="/redirect",produces = "application/json;charset=UTF-8")
    public String loginRedirect(String code, String state ,HttpServletRequest request) {
        return null;
    }




}
