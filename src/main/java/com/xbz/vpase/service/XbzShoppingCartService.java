package com.xbz.vpase.service;

import com.xbz.vpase.persistent.entity.XbzShoppingCart;
import com.xbz.vpase.service.base.BaseService;

import java.util.List;

/**
 * @company:www.xinbeize.com
 * @author:Mars
 */
public interface XbzShoppingCartService extends BaseService<XbzShoppingCart> {

    List<XbzShoppingCart> selectXbzShoppingCartByUserAccount(String account);

    int insertXbzShoppingCart(String account, Integer storeId, Integer storeCount);

    void updateXbzShoppingCartCount(String account, Integer storeId, Integer storeCount);
}
