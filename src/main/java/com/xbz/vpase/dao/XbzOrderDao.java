package com.xbz.vpase.dao;

import com.xbz.vpase.dao.base.BaseDao;
import com.xbz.vpase.persistent.entity.XbzOrder;
import com.xbz.vpase.persistent.entity.XbzShoppingCart;
import com.xbz.vpase.request.XbzOrderRequest;

import java.util.List;

public interface XbzOrderDao extends BaseDao<XbzOrder> {

    List<XbzOrder> selectXbzOrderList(XbzOrderRequest request);

    Integer selectXbzOrderCount(XbzOrderRequest request);

    XbzShoppingCart selectXbzCart(XbzShoppingCart xbzShoppingCart);

    List<XbzShoppingCart> queryCarts(String userAccount);

    void insertXbzShoppingCart(XbzShoppingCart xbzShoppingCart);

    void updateByPrimaryKeySelective(XbzShoppingCart newXbzShoppingCart);

    void updateNum(XbzShoppingCart xbzShoppingCart);

    void deleteCart(XbzShoppingCart xbzShoppingCart);


}
