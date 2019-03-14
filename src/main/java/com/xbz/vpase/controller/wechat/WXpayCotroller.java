package com.xbz.vpase.controller.wechat;

import com.xbz.vpase.response.ResultJson;
import me.hao0.wepay.model.pay.JsPayResponse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;


/**
 * @ClassName
 * @Description
 * @company:www.xinbeize.com
 * @author:Mars
 */
public class WXpayCotroller {
    @Autowired
    private WepaySupport wepaySupport;
    //JSAPI支付
    public  ResultJson Jspay(HttpServletRequest httpServletRequest,String code) {
        try {
            JsPayResponse jsPayResponse = wepaySupport.jsPay(httpServletRequest, code);
            ResultJson resultJson = new ResultJson();
            resultJson.setData(jsPayResponse);
            return resultJson;
        } catch (Exception e) {

        }
        return null;
    }

}
