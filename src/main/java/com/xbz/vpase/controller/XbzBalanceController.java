package com.xbz.vpase.controller;

import com.xbz.vpase.persistent.entity.XbzBalance;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.service.XbzBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *交易记录查询
 */
@Controller
@RequestMapping("balance")
public class XbzBalanceController {

    @Autowired
    private XbzBalanceService xbzBalanceService;

    /**
     * 交易记录查询
     * @param userId 会员id
     * @param sourceId 来源id
     * @param style
     * @param startDate 查询开始时间
     * @param endDate 查询结束时间
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("selectXbzBalanceByUserIdPage")
    public @ResponseBody Map<String,Object> selectXbzBalanceByUserIdPage(Integer userId, Integer sourceId, Short style,Boolean enable,  String startDate, String endDate, Integer pageNum, Integer pageSize){
        try {
            Map<String,Object> objectMap = new HashMap<>();
            List<XbzBalance> balanceList = xbzBalanceService.selectXbzBalanceByUserIdList(userId,sourceId,style,enable,startDate,endDate,pageNum,pageSize);
            Integer totalCount = xbzBalanceService.selectXbzBalanceByUserIdCount(userId,sourceId,style,enable,startDate,endDate);
            objectMap.put("list",balanceList);
            objectMap.put("totalCount",totalCount);
            return objectMap;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据查询条件查询用户当前账户余额
     * @param userId
     * @param sourceId
     * @param style
     * @param startDate
     * @param endDate
     * @param enable
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("selectXbzBalanceGroupByUserPage")
    public @ResponseBody Map<String,Object> selectXbzBalanceGroupByUserPage(Integer userId, Integer sourceId, Short style, String startDate, String endDate, Boolean enable,Integer pageNum, Integer pageSize){
        try {
            Map<String,Object> objectMap = new HashMap<>();
            List<XbzBalance> balanceList = xbzBalanceService.selectXbzBalanceGroupByUserList(userId,sourceId,style, enable,startDate,endDate,pageNum,pageSize);
            Integer totalCount = xbzBalanceService.selectXbzBalanceGroupByUserCount(userId,sourceId,style, enable,startDate,endDate);
            objectMap.put("list",balanceList);
            objectMap.put("totalCount",totalCount);
            return objectMap;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
