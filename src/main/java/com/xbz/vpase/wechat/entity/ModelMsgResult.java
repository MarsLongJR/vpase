package com.xbz.vpase.wechat.entity;

/**
 * 发送模版消息的结果对象
 */
public class ModelMsgResult {
    private int errcode;
    private String errmsg;
    private String msgid;//消息id

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    @Override
    public String toString() {
        final StringBuffer stringBuffer = new StringBuffer("ModelMsgResult{");
        stringBuffer.append("errcode=").append(errcode);
        stringBuffer.append(", errmsg='").append(errmsg).append('\'');
        stringBuffer.append(", msgid='").append(msgid).append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
