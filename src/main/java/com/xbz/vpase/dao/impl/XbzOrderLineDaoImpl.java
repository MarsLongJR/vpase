package com.xbz.vpase.dao.impl;

import com.xbz.vpase.dao.XbzOrderLineDao;
import com.xbz.vpase.dao.base.impl.BaseDaoImpl;
import com.xbz.vpase.persistent.entity.XbzOrderLine;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("xbzOrderLineDao")
public class XbzOrderLineDaoImpl extends BaseDaoImpl<XbzOrderLine> implements XbzOrderLineDao {

    @Override
    public List<XbzOrderLine> selectXbzOrderLineByOrderId(Long orderId) {
        return sqlSessionTemplate.selectList("XbzOrderLine.selectXbzOrderLineByOrderId",orderId);
    }
}
