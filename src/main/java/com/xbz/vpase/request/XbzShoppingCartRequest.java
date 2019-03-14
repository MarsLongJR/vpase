package com.xbz.vpase.request;

import com.xbz.vpase.request.base.BaseRequest;

import java.util.Date;

/**
 * @company:www.xinbeize.com
 * @author:Mars
 */
public class XbzShoppingCartRequest extends BaseRequest {
    private String userAccount;

    private Integer cartId;

    private Integer storeId;

    private Integer storeCount;

    private Date created;

    private Date updated;

    private String startCreatedDate;

    private String endCreatedDate;

    private String startUpdatedDate;

    private String endUpdatedDate;


    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getStoreCount() {
        return storeCount;
    }

    public void setStoreCount(Integer storeCount) {
        this.storeCount = storeCount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getStartCreatedDate() {
        return startCreatedDate;
    }

    public void setStartCreatedDate(String startCreatedDate) {
        this.startCreatedDate = startCreatedDate;
    }

    public String getEndCreatedDate() {
        return endCreatedDate;
    }

    public void setEndCreatedDate(String endCreatedDate) {
        this.endCreatedDate = endCreatedDate;
    }

    public String getStartUpdatedDate() {
        return startUpdatedDate;
    }

    public void setStartUpdatedDate(String startUpdatedDate) {
        this.startUpdatedDate = startUpdatedDate;
    }

    public String getEndUpdatedDate() {
        return endUpdatedDate;
    }

    public void setEndUpdatedDate(String endUpdatedDate) {
        this.endUpdatedDate = endUpdatedDate;
    }
}
