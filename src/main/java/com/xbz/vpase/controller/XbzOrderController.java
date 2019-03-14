package com.xbz.vpase.controller;

import com.xbz.vpase.persistent.entity.*;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.service.XbzOrderDetailService;
import com.xbz.vpase.service.XbzOrderLineService;
import com.xbz.vpase.service.XbzOrderService;
import com.xbz.vpase.service.XbzShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *订单的查询，以及订单记录和订单详情
 */
@Controller
@RequestMapping("order")
public class XbzOrderController {

    @Autowired
    private XbzOrderService xbzOrderService;

    @Autowired
    private XbzOrderDetailService xbzOrderDetailService;

    @Autowired
    private XbzOrderLineService xbzOrderLineService;

    @Autowired
    private XbzShoppingCartService xbzShoppingCartService;

    /**
     * 新增订单
     * @param xbzOrder
     * @return
     */
    @RequestMapping("insertXbzOrder")
    public @ResponseBody ResultJson insertXbzOrder(@RequestBody XbzOrder xbzOrder){
        try {
            ResultJson resultJson = new ResultJson();
            if(xbzOrder!=null){
                resultJson = xbzOrderService.insertXbzOrder(xbzOrder);
                return resultJson;
            }else{
                resultJson.ResultJson(RetCode.ERROR);
                return resultJson;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据查询条件查询订单
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
    @RequestMapping("selectXbzOrderPage")
    public @ResponseBody Map<String,Object> selectXbzOrderPage(Long id, String orderCode, String pickupCode, String tel,String linkMan, String totalPrice, Integer orderType,
                                                               String payPrice, Integer userId, Boolean enable,Short distributionType,String machineCode ,Short payType,Short status,
                                                               String startDate,String endDate,Integer pageNum,Integer pageSize){
        try {
            Map<String,Object> objectMap = new HashMap<>();
            List<XbzOrder> orderList = xbzOrderService.selectXbzOrderList(id,orderCode,pickupCode,tel,linkMan,totalPrice,orderType,payPrice,userId,enable,distributionType,machineCode,payType,status,startDate,endDate,pageNum,pageSize);
            Integer totalCount = xbzOrderService.selectXbzOrderCount(id,orderCode,pickupCode,tel,linkMan,totalPrice,orderType,payPrice,userId,enable,distributionType,machineCode,payType,status,startDate,endDate);
            objectMap.put("list",orderList);
            objectMap.put("totalCount",totalCount);
            return objectMap;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据订单Id查询订单详情
     * @param orderId
     * @return
     */
    @RequestMapping("selectXbzOrderDetailByOrderId")
    public @ResponseBody ResultJson selectXbzOrderDetailByOrderId(Long orderId){
        ResultJson resultJson = new ResultJson();
        try {
            resultJson = xbzOrderDetailService.selectXbzOrderDetailByOrderId(orderId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultJson;
    }

    /**
     * 根据订单id查询订单的记录
     * @param orderId
     * @return
     */
    @RequestMapping("selectXbzOrderLineByOrderId")
    public @ResponseBody ResultJson selectXbzOrderLineByOrderId(Long orderId){
        ResultJson resultJson = new ResultJson();
        try {
            List<XbzOrderLine> lines = xbzOrderLineService.selectXbzOrderLineByOrderId(orderId);
            resultJson.ResultJson(RetCode.OK);
            resultJson.setData(lines);
        } catch (Exception e) {
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return resultJson;
    }

    /**
     * 退订单
     * @param orderId
     * @return
     */
    @RequestMapping("refundXbzOrder")
    public @ResponseBody ResultJson refundXbzOrder(Integer orderId){
        ResultJson resultJson = new ResultJson();
        try {
            resultJson = xbzOrderService.refundXbzOrder(orderId);
        }catch (Exception e){
            e.printStackTrace();

        }
        return resultJson;
    }


    /**
     * 根据用户账号查询购物车List列表
     * @param session
     * @return
     */
    @RequestMapping("selectXbzShoppingCartByUserAccount")
    @ResponseBody
    public ResultJson selectXbzShoppingCart(HttpSession session){
        String account=(String)session.getAttribute("account");
        ResultJson resultJson=new ResultJson();
        if (account == null){
            resultJson.ResultJson(RetCode.OK);
            resultJson.setMessage("请登录");
        }
        List<XbzShoppingCart> cartList=xbzShoppingCartService.selectXbzShoppingCartByUserAccount(account);
        resultJson.ResultJson(RetCode.OK);
        resultJson.setData(cartList);
        return  resultJson;
    }

    /**
     * 新增商品
     * @param storeId
     * @param storeCount
     * @param session
     * @return
     */
    @RequestMapping("insertXbzShoppingCart")
    public ResultJson insertXbzShoppingCart(Integer storeId,
                          Integer storeCount,HttpSession session){
        ResultJson resultJson=new ResultJson();
        String account=(String)session.getAttribute("account");
        int success=xbzShoppingCartService.insertXbzShoppingCart(account,storeId,storeCount);
        if(success==1){//新增成功,update,insert
            resultJson.ResultJson(RetCode.OK);
            resultJson.setMessage("新增商品成功");
            return resultJson;
            //我的购物车,做重新查询,新增和更新的数据就会做最新的展示
        }else{
            resultJson.ResultJson(RetCode.OK);
            resultJson.setMessage("新增商品失败");
            return resultJson;
        }
    }

    /**
     * 更新产品的数量
     * @param storeId
     * @param storeCount
     * @param session
     * @return
     */
    @RequestMapping("updateXbzShoppingCartCount")
    public ResultJson updateXbzShoppingCartCount(Integer storeId,Integer storeCount,HttpSession session){
        ResultJson resultJson=new ResultJson();
        String account= (String) session.getAttribute("account");
        xbzShoppingCartService.updateXbzShoppingCartCount(account,storeId,storeCount);
        resultJson.ResultJson(RetCode.OK);
        return resultJson;
    }
}

