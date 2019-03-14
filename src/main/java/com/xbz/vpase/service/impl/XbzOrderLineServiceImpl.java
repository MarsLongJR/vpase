package com.xbz.vpase.service.impl;

import com.xbz.vpase.dao.XbzOrderLineDao;
import com.xbz.vpase.persistent.entity.XbzOrderLine;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.service.XbzOrderLineService;
import com.xbz.vpase.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XbzOrderLineServiceImpl extends BaseServiceImpl<XbzOrderLine> implements XbzOrderLineService {

    @Resource
    private XbzOrderLineDao xbzOrderLineDao;

    @Resource
    public void setBaseDao(XbzOrderLineDao xbzOrderLineDao) {
        super.setBaseDao(xbzOrderLineDao);
    }

    @Override
    public List<XbzOrderLine> selectXbzOrderLineByOrderId(Long orderId) {

        try {

            List<XbzOrderLine> lines = xbzOrderLineDao.selectXbzOrderLineByOrderId(orderId);
            return lines;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
