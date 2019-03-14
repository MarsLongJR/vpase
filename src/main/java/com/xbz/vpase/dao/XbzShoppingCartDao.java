package com.xbz.vpase.dao;

import com.xbz.vpase.dao.base.BaseDao;
import com.xbz.vpase.persistent.entity.XbzShoppingCart;

import java.util.List;

/**
 * @company:www.xinbeize.com
 * @author:Mars
 */
public interface XbzShoppingCartDao extends BaseDao<XbzShoppingCart> {
    /**
     * 根据用户账户查询用户的购物车
     * @param account
     * @return
     */
    List<XbzShoppingCart> selectXbzShoppingCartByUserAccount(String account);

    /**
     * 查询一个购物车商品数据
     * @param xbzShoppingCart
     * @return
     */
     XbzShoppingCart selectXbzShoppingCartByOne(XbzShoppingCart xbzShoppingCart);

    /**
     * 更新购物车里商品的数量
     * @param exists
     * @return
     */
    int updateStoreCount(XbzShoppingCart exists);


}
