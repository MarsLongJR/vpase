package com.xbz.vpase.controller.wechat;


import com.github.wxpay.sdk.WXPayUtil;
import com.xbz.vpase.wechat.utils.WxXmlToString;
import me.hao0.wepay.core.Wepay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;


/**
 * @ClassName WxPayController
 * @Description 微信支付成功后回调次接口
 * @company www.xinbeize.com
 * @author Mars
 */
@Controller
@RequestMapping("notify")
public class WxPayControllerNotifiesSource {



    @RequestMapping("callback")
    public String callBack(HttpServletRequest request, HttpServletResponse response){

        System.out.println("微信支付成功，微信发送callback信息，订单状态的修改");
        InputStream is=null;
        try{
            //获取请求流信息（因为微信发送的xml格式所有，所有只能用流来请求）
            is=request.getInputStream();
            //接收微信传来的xml，以UTF-8的字节码格式转成字节码对象
            String xml= WxXmlToString.inputStream2String(is, "UTF-8");
            //将微信发送的xml转为map
            Map<String,String> notifyMap=WXPayUtil.xmlToMap(xml);
            if(notifyMap.get("return_code").equals("SUCCESS")){
                if(notifyMap.get("result_code").equals("SUCCESS")){
                    //获取订单号
                    String oderNo=notifyMap.get("out_trade_no");
                    //实际支付的订单金额:单位 分
                    String amountpaid = notifyMap.get("total_fee");
                    //将金额单位分转化为金额单位元
                    BigDecimal amountPay = (new BigDecimal(amountpaid).divide(new BigDecimal("100"))).setScale(2);
                    //可以获得用户的openId
                    String openid = notifyMap.get("openid");
                    //获得交易类型
                    String trade_type = notifyMap.get("trade_type");

                    /*以下是自己的业务处理------仅做参考
                     * 更新order对应字段/已支付金额/状态码
                     */
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
