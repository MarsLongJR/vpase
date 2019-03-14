package com.xbz.vpase.persistent.entity.UpdatePwd;

/**
 * 用户修改密码时提交的信息
 * @company:www.xinbeize.com
 * @author:Mars
 */
public class UpdatePwdInfo {
    private String newPassword;
    private String newPasswordAgain;
    private String phone;
    private String code;

    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    public String getNewPasswordAgain() {
        return newPasswordAgain;
    }
    public void setNewPasswordAgain(String newPasswordAgain) {
        this.newPasswordAgain = newPasswordAgain;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
