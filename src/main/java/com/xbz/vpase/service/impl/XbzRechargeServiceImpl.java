package com.xbz.vpase.service.impl;

import com.xbz.vpase.dao.XbzRechargeDao;
import com.xbz.vpase.persistent.entity.XbzRecharge;
import com.xbz.vpase.request.XbzRechargeRequest;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.service.XbzRechargeService;
import com.xbz.vpase.service.base.impl.BaseServiceImpl;
import com.xbz.vpase.utils.TextUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class XbzRechargeServiceImpl extends BaseServiceImpl<XbzRecharge> implements XbzRechargeService {

    @Resource
    private XbzRechargeDao xbzRechargeDao;

    @Resource
    public void setBaseDao(XbzRechargeDao xbzRechargeDao) {
        super.setBaseDao(xbzRechargeDao);
    }

    private XbzRechargeRequest paramIsNull(Integer userId, Short payType, Boolean enable, Short status, String accounts, String startDate, String endDate,Integer pageNum,Integer pageSize){
        XbzRechargeRequest request = new XbzRechargeRequest();
        try {
            if(userId!=null){
                request.setUserId(userId);
            }
            if(payType!=null){
                request.setPayType(payType);
            }
            if(enable!=null){
                request.setEnable(enable);
            }
            if(status!=null){
                request.setStatus(status);
            }
            if(!TextUtil.isEmpty(accounts)){
                request.setAccounts(BigDecimal.valueOf(Double.valueOf(accounts)));
            }
            if(!TextUtil.isEmpty(startDate)){
                request.setStartDate(startDate+" 00:00:00");
            }
            if(!TextUtil.isEmpty(endDate)){
                request.setEndDate(endDate+" 23:59:59");
            }
            if(pageNum!=null && pageSize!=null){
                request.setPage(pageNum,pageSize);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return request;
    }

    @Override
    public List<XbzRecharge> selectRechargeByUserIdList(Integer userId, Short payType, Boolean enable, Short status, String accounts, String startDate, String endDate, Integer pageNum, Integer pageSize) {
        try {
            XbzRechargeRequest rechargeRequest = paramIsNull(userId,payType,enable,status,accounts,startDate,endDate,pageNum,pageSize);
            if(rechargeRequest!=null){
                List<XbzRecharge> xbzRecharges = xbzRechargeDao.selectRechargeByUserIdList(rechargeRequest);
                return xbzRecharges;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
            return null;
    }

    @Override
    public Integer selectRechargeByUserIdCount(Integer userId, Short payType, Boolean enable, Short status, String accounts, String startDate, String endDate) {
        try {
            XbzRechargeRequest rechargeRequest = paramIsNull(userId,payType,enable,status,accounts,startDate,endDate,null,null);
            if(rechargeRequest!=null){
                Integer totalCount= xbzRechargeDao.selectRechargeByUserIdCount(rechargeRequest);
                return totalCount;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
