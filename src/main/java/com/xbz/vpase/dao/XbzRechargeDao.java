package com.xbz.vpase.dao;

import com.xbz.vpase.dao.base.BaseDao;
import com.xbz.vpase.persistent.entity.XbzRecharge;
import com.xbz.vpase.request.XbzRechargeRequest;

import java.util.List;

public interface XbzRechargeDao extends BaseDao<XbzRecharge> {

    List<XbzRecharge> selectRechargeByUserIdList(XbzRechargeRequest rechargeRequest);

    Integer selectRechargeByUserIdCount(XbzRechargeRequest rechargeRequest);
}
