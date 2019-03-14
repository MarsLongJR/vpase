package com.xbz.vpase.dao.impl;

import com.xbz.vpase.dao.XbzRechargeDao;
import com.xbz.vpase.dao.base.impl.BaseDaoImpl;
import com.xbz.vpase.persistent.entity.XbzRecharge;
import com.xbz.vpase.request.XbzRechargeRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("xbzRechargeDao")
public class XbzRechargeDaoImpl extends BaseDaoImpl<XbzRecharge> implements XbzRechargeDao {

    @Override
    public List<XbzRecharge> selectRechargeByUserIdList(XbzRechargeRequest rechargeRequest) {
        return sqlSessionTemplate.selectList("XbzRecharge.selectRechargeByUserIdList",rechargeRequest);
    }

    @Override
    public Integer selectRechargeByUserIdCount(XbzRechargeRequest rechargeRequest) {
        return sqlSessionTemplate.selectOne("XbzRecharge.selectRechargeByUserIdCount",rechargeRequest);
    }
}
