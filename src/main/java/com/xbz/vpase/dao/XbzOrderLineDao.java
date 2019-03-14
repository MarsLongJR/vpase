package com.xbz.vpase.dao;

import com.xbz.vpase.dao.base.BaseDao;
import com.xbz.vpase.persistent.entity.XbzOrderLine;

import java.util.List;

public interface XbzOrderLineDao extends BaseDao<XbzOrderLine> {

    List<XbzOrderLine> selectXbzOrderLineByOrderId(Long orderId);
}
