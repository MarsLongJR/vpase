package com.xbz.vpase.controller.wechat;

import com.alibaba.fastjson.JSONObject;
import com.xbz.vpase.utils.HttpRequst;
import me.hao0.common.date.Dates;
import me.hao0.wepay.core.Wepay;
import me.hao0.wepay.model.pay.JsPayRequest;
import me.hao0.wepay.model.pay.JsPayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName
 * @Description
 * @company:www.xinbeize.com
 * @author:Mars
 */
public class WepaySupport {

    @Value("${appId}")
    private String appId;

    @Value("${mchId}")
    private String mchId;

    @Value("${appSecret}")
    private String secret;

    @Value("${payNotifyUrl}")
    private String payNotifyUrl;

    private Wepay wepay;

    public JsPayResponse jsPay(HttpServletRequest request, String code){
          /*
            获得用户openID
         */
        //页面获取openId接口
        String getopenid_url = "https://api.weixin.qq.com/sns/oauth2/access_token";
        String param = "appid=" + appId + "&secret=" + secret + "&code=" +code + "&grant_type=authorization_code";
        //向微信服务器发送get请求获取openIdStr
        String openIdStr = HttpRequst.sendGet(getopenid_url, param);
        JSONObject json = JSONObject.parseObject(openIdStr);//转成Json格式
        String openId = json.getString("openid");

        JsPayRequest jsPayRequest=new JsPayRequest();
        jsPayRequest.setOpenId(openId);
        jsPayRequest.setBody("测试订单");
        jsPayRequest.setClientIp("127.0.0.1");
        jsPayRequest.setTotalFee(1);
        jsPayRequest.setNotifyUrl(payNotifyUrl);
        jsPayRequest.setTimeStart(Dates.now("yyyyMMddHHmmss"));
        return wepay.pay().jsPay(jsPayRequest);
    }

    /**
     * 校验签名
     * @param params 参数(包含sign)
     * @return 校验成功返回true，反之false
     */
    public Boolean verifySign(Map<String, ?> params){
        return wepay.notifies().verifySign(params);
    }

    /**
     * 通知成功
     */
    public String notifyOk(){
        return wepay.notifies().ok();
    }

    /**
     * 通知不成功
     * @param errMsg 错误消息
     */
    public String notifyNotOk(String errMsg){
        return wepay.notifies().notOk(errMsg);
    }
}
