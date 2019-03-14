package com.xbz.vpase.wechat.entity;

public class WeChatAuth {

    private static final String APPID ="wx819626fc8b139481";

    private String redirect_uri = "";

    private String response_type;

    private String scope;

    private int state;

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

}
