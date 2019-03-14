package com.xbz.vpase.service;

import com.xbz.vpase.persistent.entity.XbzOrderLine;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.service.base.BaseService;

import java.util.List;

public interface XbzOrderLineService extends BaseService<XbzOrderLine> {

    List<XbzOrderLine> selectXbzOrderLineByOrderId(Long orderId);
}
