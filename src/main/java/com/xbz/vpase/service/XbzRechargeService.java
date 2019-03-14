package com.xbz.vpase.service;

import com.xbz.vpase.persistent.entity.XbzRecharge;
import com.xbz.vpase.service.base.BaseService;

import java.util.List;

public interface XbzRechargeService extends BaseService<XbzRecharge> {

    List<XbzRecharge> selectRechargeByUserIdList(Integer userId, Short payType, Boolean enable, Short status, String accounts, String startDate, String endDate, Integer pageNum, Integer pageSize);

    Integer selectRechargeByUserIdCount(Integer userId, Short payType, Boolean enable, Short status, String accounts, String startDate, String endDate);
}
