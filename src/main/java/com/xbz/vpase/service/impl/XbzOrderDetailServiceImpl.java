package com.xbz.vpase.service.impl;

import com.xbz.vpase.dao.XbzOrderDetailDao;
import com.xbz.vpase.dao.XbzOrderLineDao;
import com.xbz.vpase.persistent.entity.XbzOrderDetail;
import com.xbz.vpase.persistent.entity.XbzOrderLine;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.service.XbzOrderDetailService;
import com.xbz.vpase.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XbzOrderDetailServiceImpl extends BaseServiceImpl<XbzOrderDetail> implements XbzOrderDetailService {

    @Resource
    private XbzOrderDetailDao xbzOrderDetailDao;

    @Resource
    public void setBaseDao(XbzOrderDetailDao xbzOrderDetailDao) {
        super.setBaseDao(xbzOrderDetailDao);
    }


    @Override
    public ResultJson selectXbzOrderDetailByOrderId(Long orderId) {
        ResultJson resultJson = new ResultJson();
        try {
            List<XbzOrderDetail>  details = xbzOrderDetailDao.selectXbzOrderDetailByOrderId(orderId);
            resultJson.ResultJson(RetCode.OK);
            resultJson.setData(details);
        }catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return resultJson;
    }

}
