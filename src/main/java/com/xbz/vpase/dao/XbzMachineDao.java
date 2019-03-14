package com.xbz.vpase.dao;

import com.xbz.vpase.dao.base.BaseDao;
import com.xbz.vpase.persistent.entity.XbzMachine;
import com.xbz.vpase.request.XbzMachineRequest;

import java.util.List;

/**
 * @company:www.xinbeize.com
 * @author:Mars
 */

public interface XbzMachineDao extends BaseDao<XbzMachine> {

    void deleteMachineByMachineId(Integer machineId);

    List<XbzMachine> selectMachineList(XbzMachineRequest request);

    Integer selectXbzMachineCount(XbzMachineRequest request);
}
