package com.xbz.vpase.controller.wechat;

import com.google.common.base.Throwables;
import com.xbz.vpase.response.ResultJson;
import me.hao0.wepay.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * @ClassName WxPayNotifiesController
 * @Description 支付后的通知
 * @company:www.xinbeize.com
 * @author:Mars
 */
public class WxPayNotifiesController {

    @Autowired
    private WepaySupport wepaySupport;

    @RequestMapping("/paid")
    public ResultJson Paid(HttpServletRequest request){
        ResultJson resultJson=new ResultJson();
        String notifyXml=getPostRequestBody(request);
        if (notifyXml.isEmpty()){
            resultJson.setMessage(wepaySupport.notifyNotOk("body不能为空"));
            return resultJson;
        }
        Map<String,Object> notifyParams= Maps.toMap(notifyXml);
        if(wepaySupport.verifySign(notifyParams)){
            //TODO logic
        }
            resultJson.setMessage(wepaySupport.notifyOk());
            return resultJson;
    }

    public static String getPostRequestBody(HttpServletRequest req) {
        if (req.getMethod().equals("POST")) {
            StringBuilder sb = new StringBuilder();
            try (BufferedReader br = req.getReader()) {
                char[] charBuffer = new char[128];
                int bytesRead;
                while ((bytesRead = br.read(charBuffer)) != -1) {
                    sb.append(charBuffer, 0, bytesRead);
                }
            } catch (IOException e) {

            }
            return sb.toString();
        }
        return "";
    }
}
