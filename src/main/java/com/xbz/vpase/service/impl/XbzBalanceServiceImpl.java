package com.xbz.vpase.service.impl;

import com.xbz.vpase.dao.XbzBalanceDao;
import com.xbz.vpase.persistent.entity.XbzBalance;
import com.xbz.vpase.request.XbzBalanceRequest;
import com.xbz.vpase.service.XbzBalanceService;
import com.xbz.vpase.service.base.impl.BaseServiceImpl;
import com.xbz.vpase.utils.TextUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XbzBalanceServiceImpl extends BaseServiceImpl<XbzBalance> implements XbzBalanceService {

    @Resource
    private XbzBalanceDao xbzBalanceDao;

    @Resource
    public void setXbzBalanceDao(XbzBalanceDao xbzBalanceDao) {
        this.xbzBalanceDao = xbzBalanceDao;
    }

    private XbzBalanceRequest paramIsNull(Integer userId, Integer sourceId, Short style,Boolean enable, String startDate, String endDate, Integer pageNum, Integer pageSize){
        try {
            XbzBalanceRequest request = new XbzBalanceRequest();
            if(userId!=null){
                request.setUserId(userId);
            }

            if(sourceId!=null){
                request.setSourceId(sourceId);
            }

            if(style!=null){
                request.setStyle(style);
            }

            if(enable!=null){
                request.setEnable(enable);
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


            return request;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<XbzBalance> selectXbzBalanceByUserIdList(Integer userId, Integer sourceId, Short style, Boolean enable,String startDate, String endDate, Integer pageNum, Integer pageSize) {
        try {
            XbzBalanceRequest request = paramIsNull(userId,sourceId,style,enable,startDate,endDate,pageNum,pageSize);
            if(request!=null){
                List<XbzBalance> balances = xbzBalanceDao.selectXbzBalanceByUserIdList(request);
                return balances;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer selectXbzBalanceByUserIdCount(Integer userId, Integer sourceId, Short style,Boolean enable, String startDate, String endDate) {
        try {
            XbzBalanceRequest request = paramIsNull(userId,sourceId,style,enable,startDate,endDate,null,null);
            if(request!=null){
                Integer totalCount = xbzBalanceDao.selectXbzBalanceByUserIdCount(request);
                return totalCount;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<XbzBalance> selectXbzBalanceGroupByUserList(Integer userId, Integer sourceId, Short style,Boolean enable, String startDate, String endDate, Integer pageNum, Integer pageSize) {
        try {
            XbzBalanceRequest request = paramIsNull(userId,sourceId,style,enable,startDate,endDate,pageNum,pageSize);
            List<XbzBalance> balances = xbzBalanceDao.selectXbzBalanceGroupByUserList(request);
            return balances;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer selectXbzBalanceGroupByUserCount(Integer userId, Integer sourceId, Short style, Boolean enable,String startDate, String endDate) {
        try {
            XbzBalanceRequest request = paramIsNull(userId,sourceId,style,enable,startDate,endDate,null,null);
            Integer totalCount = xbzBalanceDao.selectXbzBalanceGroupByUserCount(request);
            return totalCount;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
