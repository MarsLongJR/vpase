package com.xbz.vpase.dao.impl;

import com.xbz.vpase.dao.XbzBalanceDao;
import com.xbz.vpase.dao.base.impl.BaseDaoImpl;
import com.xbz.vpase.persistent.entity.XbzBalance;
import com.xbz.vpase.request.XbzBalanceRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("xbzBalanceDao")
public class XbzBalanceDaoImpl extends BaseDaoImpl<XbzBalance> implements XbzBalanceDao {
    @Override
    public List<XbzBalance> selectXbzBalanceByUserIdList(XbzBalanceRequest request) {
        return sqlSessionTemplate.selectList("XbzBalance.selectXbzBalanceByUserIdList",request);
    }

    @Override
    public Integer selectXbzBalanceByUserIdCount(XbzBalanceRequest request) {
        return sqlSessionTemplate.selectOne("XbzBalance.selectXbzBalanceByUserIdCount",request);
    }

    @Override
    public List<XbzBalance> selectXbzBalanceGroupByUserList(XbzBalanceRequest request) {
        return sqlSessionTemplate.selectList("XbzBalance.selectXbzBalanceGroupByUserList",request);
    }

    @Override
    public Integer selectXbzBalanceGroupByUserCount(XbzBalanceRequest request) {
        return sqlSessionTemplate.selectOne("XbzBalance.selectXbzBalanceGroupByUserCount",request);
    }
}
