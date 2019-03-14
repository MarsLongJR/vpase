package com.xbz.vpase.service.impl;

import com.xbz.vpase.dao.XbzShoppingCartDao;
import com.xbz.vpase.dao.XbzStoreDao;
import com.xbz.vpase.persistent.entity.XbzShoppingCart;
import com.xbz.vpase.persistent.entity.XbzStore;
import com.xbz.vpase.service.XbzShoppingCartService;
import com.xbz.vpase.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @company:www.xinbeize.com
 * @author:Mars
 */
@Service
public class XbzShoppingCartServiceImpl extends BaseServiceImpl<XbzShoppingCart> implements XbzShoppingCartService {

    @Autowired
    private XbzShoppingCartDao xbzShoppingCartDao;

    @Autowired
    private XbzStoreDao xbzStoreDao;

    @Resource
    public void setBaseDao(XbzShoppingCartDao xbzShoppingCartDao) {
        super.setBaseDao(xbzShoppingCartDao);
    }

    /**
     *
     * 根据用户账户查询用户的购物车
     * @param account
     * @return
     */
    @Override
    public List<XbzShoppingCart> selectXbzShoppingCartByUserAccount(String account) {
        try {
            List<XbzShoppingCart> cartList=xbzShoppingCartDao.selectXbzShoppingCartByUserAccount(account);
            return cartList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 新增购物车商品
     * @param account
     * @param storeId
     * @param storeCount
     * @return
     */
    @Override
    public int insertXbzShoppingCart(String account, Integer storeId, Integer storeCount) {
        int success=0;
        //查询购物车商品数据，看是否有商品
        XbzShoppingCart _xbzShoppingCart=new XbzShoppingCart();
        _xbzShoppingCart.setUserAccount(account);
        _xbzShoppingCart.setStoreId(storeId);
        //通过对象查询数据
        XbzShoppingCart exists=xbzShoppingCartDao.selectXbzShoppingCartByOne(_xbzShoppingCart);
        //购物车还有商品的名称和商品的价格
        if(exists==null){
            XbzStore xbzStore=xbzStoreDao.get(storeId);
            _xbzShoppingCart.setStoreCount(storeCount);
            _xbzShoppingCart.setStoreName(xbzStore.getStoreName());
            _xbzShoppingCart.setStorePrice(xbzStore.getPrice());
            success=xbzShoppingCartDao.save(_xbzShoppingCart);
        }else{
            //已经存在的购物车商品，直接修改商品的数量storeCount
            exists.setStoreCount(exists.getStoreCount()+storeCount);
            success=xbzShoppingCartDao.updateStoreCount(exists);
        }
        return success;
    }

    /**
     * 更新购物车商品数量
     * @param account
     * @param storeId
     * @param storeCount
     */
    @Override
    public void updateXbzShoppingCartCount(String account, Integer storeId, Integer storeCount) {
        XbzShoppingCart xbzShoppingCart=new XbzShoppingCart();
        xbzShoppingCart.setStoreCount(storeCount);
        xbzShoppingCart.setUserAccount(account);
        xbzShoppingCart.setStoreId(storeId);
        xbzShoppingCartDao.updateStoreCount(xbzShoppingCart);
    }
}

