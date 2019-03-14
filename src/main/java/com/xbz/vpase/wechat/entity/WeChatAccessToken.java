package com.xbz.vpase.wechat.entity;

import java.util.Date;

public class WeChatAccessToken {

    private String access_token;
    private Integer expires_in;
    private Date time;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuffer stringBuffer = new StringBuffer("WxAccessToken{");
        stringBuffer.append("access_token='").append(access_token).append('\'');
        stringBuffer.append(", expires_in=").append(expires_in);
        stringBuffer.append(", time=").append(time);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
