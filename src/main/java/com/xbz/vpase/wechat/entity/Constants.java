package com.xbz.vpase.wechat.entity;

import com.github.wxpay.sdk.WXPayUtil;
import com.xbz.vpase.utils.ShalUtil;

public class Constants {

    public static final String APP_ID="wx819626fc8b139481";

    public static final String APP_SECRET="b394427a0810adb447b51951fe48a6f0";
//    获取access_token
    public  String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APP_ID + "&secret=" + APP_SECRET;
//    有效时间
    public static int EFFECTIVE_TIME = 700000;

    public static final String mch_id ="1507783111";

    public static final String nonce_str = WXPayUtil.generateNonceStr();

    public static final String Body ="鑫倍泽";

    public static final String out_trade_no = APP_ID+ ShalUtil.getTimeStamp();

    public static final String total_fee ="1";

    public static final String device_info="WEB";

    public static final String notify_url="http://vservice.njxbz.online/notify";

    public static final String trade_type="JSAPI";

    public static final String partnerkey = "9810c03c9f974275ec5816e2810efd2b";

    public static final String timeStamp= ShalUtil.getTimeStamp();
}
