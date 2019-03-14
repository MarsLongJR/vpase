package com.xbz.vpase.controller.wechat;

import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPayUtil;
import com.xbz.vpase.response.ResultFactory;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.utils.HttpRequst;
import com.xbz.vpase.wechat.entity.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @company:www.xinbeize.com
 * @author:Mars
 */
public class WxPayControllerSource {
    /**
     * @Description 处理微信支付的逻辑与微信服务器做交互
     * @param request
     * @param
     * @return
     */
    @RequestMapping("wxpay")
    @ResponseBody
    public ResultJson toPay(HttpServletRequest request, String code) {
        try {
        /*
            获得用户openID
         */
            //页面获取openId接口
            String getopenid_url = "https://api.weixin.qq.com/sns/oauth2/access_token";
            String param = "appid=" + "wx8850d007f51a6ca1" + "&secret=" + "dd1fd34902efcc7706bb880f25ed0f38" + "&code=" +code + "&grant_type=authorization_code";
            //向微信服务器发送get请求获取openIdStr
            String openIdStr = HttpRequst.sendGet(getopenid_url, param);
            JSONObject json = JSONObject.parseObject(openIdStr);//转成Json格式
            String openId = json.getString("openid");
            /*
            前台获得用户输入的金额
            */
            String money = request.getParameter("money");
            int intMoney = 0;
            ResultJson resultJson = new ResultJson();
            if (openId == null | openId.isEmpty()) {
                return ResultFactory.getNullParamResultJson();
            }
            if (money == null || money.isEmpty()) {
                resultJson.ResultJson(RetCode.PARAM_NULL);
                resultJson.setMessage("金额数不能为0");
                return resultJson;
            }
            try {
                intMoney = (int) (Double.valueOf(money) * 100);
            } catch (Exception e) {
                resultJson.ResultJson(RetCode.PARAM_NULL);
                resultJson.setMessage("金额数不能为0");
                return resultJson;
            }
            /*拼接统一下单地址参数
             */
            Map<String, String> paraMap = new HashMap<String, String>();
            //通过IP判定，哪一台机器操作
            String spbill_create_ip = request.getRemoteAddr();
            paraMap.put("appid", Constants.APP_ID);
            paraMap.put("body", Constants.Body);
            paraMap.put("mch_id", Constants.mch_id);
            paraMap.put("nonce_str", Constants.nonce_str);
            paraMap.put("openid", openId);
            paraMap.put("out_trade_no", Constants.out_trade_no);//订单号
            paraMap.put("spbill_create_ip", spbill_create_ip);
            paraMap.put("total_fee", Constants.total_fee);
            paraMap.put("trade_type", Constants.trade_type);
            paraMap.put("device_info",Constants.device_info);
            paraMap.put("notify_url", Constants.notify_url);// 此路径是微信服务器调用支付结果通知路径随意写
            String sign = WXPayUtil.generateSignature(paraMap,Constants.partnerkey );
            paraMap.put("sign", sign);
            String xml = WXPayUtil.mapToXml(paraMap);//将所有参数(map)转xml格式

            // 统一下单 https://api.mch.weixin.qq.com/pay/unifiedorder
            String unifiedorder_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";

            //发送post请求"统一下单接口"返回预支付id:prepay_id
            String xmlStr = HttpRequst.sendPost(unifiedorder_url,xml);

            //以下内容是返回前端页面的json数据
            String prepay_id = "";//预支付id
            if (xmlStr.indexOf("SUCCESS") != -1) {
                Map<String, String> map = WXPayUtil.xmlToMap(xmlStr);
                prepay_id = (String) map.get("prepay_id");
            }
            Map<String, String> payMap = new HashMap<String, String>();
            payMap.put("appId",Constants.APP_ID);
            payMap.put("timeStamp", Constants.timeStamp+"");//timeStamp的获得
            payMap.put("nonceStr",Constants.nonce_str);
            payMap.put("signType", "MD5");
            payMap.put("package", "prepay_id=" + prepay_id);
            String paySign = WXPayUtil.generateSignature(payMap,Constants.partnerkey);
            payMap.put("paySign", paySign);
            resultJson.ResultJson(RetCode.OK);
            resultJson.setData(paraMap);
            return resultJson;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
