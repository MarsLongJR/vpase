package com.xbz.vpase.dao;

import com.xbz.vpase.dao.base.BaseDao;
import com.xbz.vpase.persistent.entity.XbzStorePriceLine;

import java.util.List;

public interface XbzStorePriceLineDao extends BaseDao<XbzStorePriceLine> {

    XbzStorePriceLine selectLastOfXbzStorePrice(Integer storeId);

    List<XbzStorePriceLine> selectXbzStorePriceLineByStore(Integer storeId);
}
