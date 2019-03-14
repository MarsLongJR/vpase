package com.xbz.vpase.dao.impl;

import com.xbz.vpase.dao.XbzMachineDao;
import com.xbz.vpase.dao.base.impl.BaseDaoImpl;
import com.xbz.vpase.persistent.entity.XbzMachine;
import com.xbz.vpase.request.XbzMachineRequest;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @company:www.xinbeize.com
 * @author:Mars
 */
@Repository("xbzMachineDao")
public class XbzMachineDaoImpl extends BaseDaoImpl<XbzMachine> implements XbzMachineDao  {
    @Override
    public List<XbzMachine> selectMachineList(XbzMachineRequest request) {
        return sqlSessionTemplate.selectList("XbzMachine.selectMachineList",request);
    }

    @Override
    public Integer selectXbzMachineCount(XbzMachineRequest request) {
        return sqlSessionTemplate.selectOne("XbzMachine.selectXbzMachineCount",request);
    }

    @Override
    public void deleteMachineByMachineId(Integer machineId) {
        sqlSessionTemplate.delete("XbzMachine.deleteMachineByMachineId",machineId);
    }


}
