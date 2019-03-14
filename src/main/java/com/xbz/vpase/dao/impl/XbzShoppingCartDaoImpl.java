package com.xbz.vpase.dao.impl;

import com.xbz.vpase.dao.XbzShoppingCartDao;
import com.xbz.vpase.dao.base.impl.BaseDaoImpl;
import com.xbz.vpase.persistent.entity.XbzShoppingCart;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @company:www.xinbeize.com
 * @author:Mars
 */
@Repository("xbzShoppingCartDao")
public class XbzShoppingCartDaoImpl extends BaseDaoImpl<XbzShoppingCart> implements XbzShoppingCartDao {
    @Override
    public List<XbzShoppingCart> selectXbzShoppingCartByUserAccount(String account) {
        return sqlSessionTemplate.selectList("XbzShoppingCart.selectXbzShoppingCartByUserAccount",account);
    }

    @Override
    public XbzShoppingCart selectXbzShoppingCartByOne(XbzShoppingCart xbzShoppingCart) {
        return sqlSessionTemplate.selectOne("XbzShoppingCart.selectXbzShoppingCartByOne",xbzShoppingCart);
    }

    @Override
    public int updateStoreCount(XbzShoppingCart exists) {
        return sqlSessionTemplate.update("XbzShoppingCart.updateStoreCount",exists);
    }
}
