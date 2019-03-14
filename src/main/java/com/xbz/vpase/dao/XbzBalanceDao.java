package com.xbz.vpase.dao;

import com.xbz.vpase.dao.base.BaseDao;
import com.xbz.vpase.persistent.entity.XbzBalance;
import com.xbz.vpase.request.XbzBalanceRequest;

import java.util.List;

public interface XbzBalanceDao extends BaseDao<XbzBalance> {
    
    List<XbzBalance> selectXbzBalanceByUserIdList(XbzBalanceRequest request);

    Integer selectXbzBalanceByUserIdCount(XbzBalanceRequest request);

    List<XbzBalance> selectXbzBalanceGroupByUserList(XbzBalanceRequest request);

    Integer selectXbzBalanceGroupByUserCount(XbzBalanceRequest request);
}
