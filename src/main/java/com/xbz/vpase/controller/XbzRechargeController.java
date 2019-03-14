package com.xbz.vpase.controller;

import com.xbz.vpase.persistent.entity.XbzRecharge;

import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.service.XbzRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 充值记录查询
 */
@Controller
@RequestMapping("recharge")
public class XbzRechargeController {

    @Autowired
    private XbzRechargeService xbzRechargeService;

    /**
     * 商品的充值记录查询
     * @param userId 用户id
     * @param payType 付款方式
     * @param enable
     * @param status
     * @param accounts
     * @param startDate
     * @param endDate
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("selectRechargeByUserIdPage")
    public @ResponseBody Map<String,Object> selectRechargeByUserIdPage(Integer userId, Short payType, Boolean enable, Short status, String accounts, String startDate, String endDate, Integer pageNum, Integer pageSize){
        try {
            Map<String,Object> objectMap = new HashMap<>();
            List<XbzRecharge> recharges = xbzRechargeService.selectRechargeByUserIdList(userId,payType,enable,status,accounts,startDate,endDate,pageNum,pageSize);
            Integer totalCount = xbzRechargeService.selectRechargeByUserIdCount(userId,payType,enable,status,accounts,startDate,endDate);
            objectMap.put("list",recharges);
            objectMap.put("totalCount",totalCount);
            return objectMap;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据id查询充值记录
     * @param rechargeId
     * @return
     */
    @RequestMapping("selectRechargeById")
    public @ResponseBody ResultJson selectRechargeById(Integer rechargeId){
        ResultJson resultJson = new ResultJson();
        try {
            XbzRecharge recharge = xbzRechargeService.get(rechargeId);
            resultJson.ResultJson(RetCode.OK);
            resultJson.setData(recharge);
        }catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return resultJson;
    }
}
