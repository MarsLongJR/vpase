package com.xbz.vpase.wechat.entity;

public class WeChatQRCode {

    /**
     * ticket : gQH47joAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL2taZ2Z3TVRtNzJXV1Brb3ZhYmJJAAIEZ23sUwMEmm 3sUw==
     * expire_seconds : 60
     * url : http://weixin.qq.com/q/kZgfwMTm72WWPkovabbI
     */

    private String ticket;
    private int expire_seconds;
    private String url;
    /**
     * errcode : 40001
     * errmsg : invalid credential, access_token is invalid or not latest hint: [7Z2YiA0559vr30!]
     */

    private String errcode;
    private String errmsg;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getExpire_seconds() {
        return expire_seconds;
    }

    public void setExpire_seconds(int expire_seconds) {
        this.expire_seconds = expire_seconds;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }


    @Override
    public String toString() {
        return "WxQRCode{" +
                "ticket='" + ticket + '\'' +
                ", expire_seconds=" + expire_seconds +
                ", url='" + url + '\'' +
                ", errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
