package com.xbz.vpase.service;

import com.xbz.vpase.persistent.entity.XbzBalance;
import com.xbz.vpase.service.base.BaseService;

import java.util.List;

public interface XbzBalanceService extends BaseService<XbzBalance> {

    List<XbzBalance> selectXbzBalanceByUserIdList(Integer userId, Integer sourceId, Short style, Boolean enable, String startDate, String endDate, Integer pageNum, Integer pageSize);

    Integer selectXbzBalanceByUserIdCount(Integer userId, Integer sourceId, Short style,Boolean enable, String startDate, String endDate);

    List<XbzBalance> selectXbzBalanceGroupByUserList(Integer userId, Integer sourceId, Short style, Boolean enable, String startDate, String endDate,Integer pageNum, Integer pageSize);

    Integer selectXbzBalanceGroupByUserCount(Integer userId, Integer sourceId, Short style, Boolean enable,String startDate, String endDate);
}
