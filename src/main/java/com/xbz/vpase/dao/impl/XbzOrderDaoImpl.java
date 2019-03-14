package com.xbz.vpase.dao.impl;

import com.xbz.vpase.dao.XbzOrderDao;
import com.xbz.vpase.dao.base.impl.BaseDaoImpl;
import com.xbz.vpase.persistent.entity.XbzOrder;
import com.xbz.vpase.persistent.entity.XbzShoppingCart;
import com.xbz.vpase.request.XbzOrderRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("xbzOrderDao")
public class XbzOrderDaoImpl extends BaseDaoImpl<XbzOrder> implements XbzOrderDao {

    @Override
    public List<XbzOrder> selectXbzOrderList(XbzOrderRequest request) {
        return sqlSessionTemplate.selectList("XbzOrder.selectXbzOrderList",request);
    }

    @Override
    public Integer selectXbzOrderCount(XbzOrderRequest request) {
        return sqlSessionTemplate.selectOne("XbzOrder.selectXbzOrderCount",request);
    }

    @Override
    public XbzShoppingCart selectXbzCart(XbzShoppingCart xbzShoppingCart) {
        return sqlSessionTemplate.selectOne("XbzShoppingCart.selectXbzCart",xbzShoppingCart);
    }

    @Override
    public List<XbzShoppingCart> queryCarts(String userAccount) {
        return sqlSessionTemplate.selectList("<XbzShoppingCart.queryCarts",userAccount);
    }

    @Override
    public void insertXbzShoppingCart(XbzShoppingCart xbzShoppingCart) {

    }

    @Override
    public void updateByPrimaryKeySelective(XbzShoppingCart newXbzShoppingCart) {

    }

    @Override
    public void updateNum(XbzShoppingCart xbzShoppingCart) {

    }

    @Override
    public void deleteCart(XbzShoppingCart xbzShoppingCart) {

    }

}
