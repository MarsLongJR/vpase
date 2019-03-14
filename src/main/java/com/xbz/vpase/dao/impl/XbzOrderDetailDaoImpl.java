package com.xbz.vpase.dao.impl;

import com.xbz.vpase.dao.XbzOrderDetailDao;
import com.xbz.vpase.dao.base.impl.BaseDaoImpl;
import com.xbz.vpase.persistent.entity.XbzOrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("xbzOrderDetailDao")
public class XbzOrderDetailDaoImpl extends BaseDaoImpl<XbzOrderDetail> implements XbzOrderDetailDao {

    @Override
    public List<XbzOrderDetail> selectXbzOrderDetailByOrderId(Long orderId) {
        return sqlSessionTemplate.selectList("XbzOrderDetail.selectXbzOrderDetailByOrderId",orderId);
    }
}
