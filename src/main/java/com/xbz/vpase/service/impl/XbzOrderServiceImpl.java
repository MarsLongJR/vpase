package com.xbz.vpase.service.impl;

import com.xbz.vpase.dao.XbzBalanceDao;
import com.xbz.vpase.dao.XbzOrderDao;
import com.xbz.vpase.dao.XbzOrderDetailDao;
import com.xbz.vpase.dao.XbzOrderLineDao;
import com.xbz.vpase.persistent.entity.XbzBalance;
import com.xbz.vpase.persistent.entity.XbzOrder;
import com.xbz.vpase.persistent.entity.XbzShoppingCart;
import com.xbz.vpase.persistent.entity.XbzOrderDetail;
import com.xbz.vpase.persistent.entity.XbzOrderLine;
import com.xbz.vpase.request.XbzOrderRequest;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.service.XbzOrderService;
import com.xbz.vpase.service.base.impl.BaseServiceImpl;
import com.xbz.vpase.utils.TextUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Date;
import java.util.List;

@Service
public class XbzOrderServiceImpl extends BaseServiceImpl<XbzOrder> implements XbzOrderService {

    @Resource
    private XbzOrderDao xbzOrderDao;

    @Resource
    private XbzOrderDetailDao xbzOrderDetailDao;

    @Resource
    private XbzOrderLineDao xbzOrderLineDao;

    @Resource
    private XbzBalanceDao xbzBalanceDao;

    @Resource
    public void setBaseDao(XbzOrderDao xbzOrderDao) {
        super.setBaseDao(xbzOrderDao);
    }

    /**
     * 判断参数是否为空
     * @param id
     * @param orderCode
     * @param pickupCode
     * @param tel
     * @param linkMan
     * @param totalPrice
     * @param orderType
     * @param payPrice
     * @param userId
     * @param enable
     * @param distributionType
     * @param machineCode
     * @param payType
     * @param startDate
     * @param endDate
     * @param pageNum
     * @param pageSize
     * @return
     */
    private XbzOrderRequest paramIsNull(Long id, String orderCode, String pickupCode, String tel, String linkMan, String totalPrice, Integer orderType, String payPrice,
                                        Integer userId, Boolean enable, Short distributionType, String machineCode, Short payType,Short status,String startDate,String endDate,
                                        Integer pageNum,Integer pageSize){
        XbzOrderRequest request = new XbzOrderRequest();
        try {
            if(id!=null){
                request.setId(id);
            }
            if(!TextUtil.isEmpty(orderCode)){
                request.setOrderCode(orderCode);
            }
            if(!TextUtil.isEmpty(pickupCode)){
                request.setPickupCode(pickupCode);
            }
            if(!TextUtil.isEmpty(tel)){
                request.setTel(tel);
            }
            if(!TextUtil.isEmpty(linkMan)){
                request.setLinkMan(linkMan);
            }
            if(!TextUtil.isEmpty(totalPrice)){
                request.setTotalPrice(BigDecimal.valueOf(Double.valueOf(totalPrice)));
            }
            if(orderType!=null){
                request.setOrderType(orderType);
            }
            if(!TextUtil.isEmpty(payPrice)){
                request.setPayPrice(BigDecimal.valueOf(Double.valueOf(payPrice)));
            }
            if(userId!=null){
                request.setUserId(userId);
            }
            if(enable!=null){
                request.setEnable(enable);
            }
            if(distributionType!=null){
                request.setDistributionType(distributionType);
            }
            if(!TextUtil.isEmpty(machineCode)){
                request.setMachineCode(machineCode);
            }
            if(payType!=null){
                request.setPayType(payType);
            }
            if(!TextUtil.isEmpty(startDate)){
                request.setStartDate(startDate+" 00:00:00");
            }
            if(!TextUtil.isEmpty(endDate)){
                request.setEndDate(endDate+" 23:59:59");
            }
            if(status!=null){
                request.setStatus(status);
            }
            if(pageNum!=null && pageSize!=null){
                request.setPage(pageNum,pageSize);
            }
            return request;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
    /**
     * 新增订单
     * @param xbzOrder
     * @return
     */
    @Override
    public ResultJson insertXbzOrder(XbzOrder xbzOrder) {
        ResultJson resultJson = new ResultJson();
        try {
            List<XbzOrderDetail> details = xbzOrder.getDetails();
            if(details.size()>0){
                xbzOrderDao.save(xbzOrder);
                for (XbzOrderDetail detail : details){
                    detail.setOrderId(xbzOrder.getId());
                    xbzOrderDetailDao.save(detail);
                }

                XbzOrderLine line = new XbzOrderLine();
                line.setOrderId(xbzOrder.getId());
                line.setProcessingTime(new Date());
                line.setStatus((short)1);
                line.setProcessor("");
                line.setProcessorTel("");
                xbzOrderLineDao.save(line);
                resultJson.ResultJson(RetCode.OK);
                resultJson.setMessage("新增成功");
            }else{
                resultJson.ResultJson(RetCode.ERROR);
                resultJson.setMessage("请选择你需要购买的商品");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<XbzOrder> selectXbzOrderList(Long id, String orderCode, String pickupCode, String tel, String linkMan, String totalPrice, Integer orderType, String payPrice,
                                             Integer userId, Boolean enable, Short distributionType, String machineCode, Short payType,Short status,String startDate,String endDate,
                                             Integer pageNum,Integer pageSize) {
        try {

            XbzOrderRequest request = paramIsNull(id, orderCode, pickupCode, tel, linkMan, totalPrice, orderType, totalPrice, userId,enable, distributionType, machineCode, payType, status, startDate, endDate, pageNum, pageSize);
            List<XbzOrder> orders = xbzOrderDao.selectXbzOrderList(request);
            return orders;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer selectXbzOrderCount(Long id, String orderCode, String pickupCode, String tel, String linkMan, String totalPrice, Integer orderType, String payPrice, Integer userId, Boolean enable, Short distributionType, String machineCode, Short payType, Short status, String startDate, String endDate) {
        return null;
    }

    @Override
    public ResultJson refundXbzOrder(Integer orderId) {
        return null;
    }

}
