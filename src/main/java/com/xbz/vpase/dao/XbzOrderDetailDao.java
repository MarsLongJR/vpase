package com.xbz.vpase.dao;

import com.xbz.vpase.dao.base.BaseDao;
import com.xbz.vpase.persistent.entity.XbzOrderDetail;

import java.util.List;

public interface XbzOrderDetailDao extends BaseDao<XbzOrderDetail> {

    List<XbzOrderDetail> selectXbzOrderDetailByOrderId(Long orderId);
}
