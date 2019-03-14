package com.xbz.vpase.service;

import com.xbz.vpase.persistent.entity.XbzMachine;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @company:www.xinbeize.com
 * @author:Mars
 */


public interface XbzMachineService extends BaseService<XbzMachine> {
    /*
    根据条件查询机器
     */
    List<XbzMachine> selectXbzMachineList(Integer machineId, String machineName, String machineCode, Short machineType, String startDate, String endDate, Short status, Integer creatorId, Boolean connectStatus, Short temperatureStatus,
                                          Integer addressId, String creator, String openTime, String offTime, Integer channelNum, String province, String city, String adressDetail,
                                          Integer pageNum, Integer pageSize);

    /**
     * 分页查询机器
     *
     * @param machineId
     * @param machineName
     * @param machineCode
     * @param machineType
     * @param startDate
     * @param endDate
     * @param status
     * @param creatorId
     * @param connectStatus
     * @param temperatureStatus
     * @param addressId
     * @param creator
     * @param openTime
     * @param offTime
     * @param channelNum
     * @param province
     * @param city
     * @param adressDetail
     * @param
     * @param
     * @return
     */
    Integer selectXbzMachineCount(Integer machineId, String machineName, String machineCode,
                                  Short machineType, String startDate, String endDate,
                                  Short status, Integer creatorId, Boolean connectStatus,
                                  Short temperatureStatus, Integer addressId, String creator,
                                  String openTime, String offTime, Integer channelNum,
                                  String province, String city, String adressDetail);
    /**
     * 新增机器
     *
     * @param xbzMachine
     * @return
     */
    ResultJson insertXbzMachine(XbzMachine xbzMachine);

    /*
    修改机器信息
     */
    ResultJson modifyXbzMachine(Integer machineId, String machineName, String machineCode, Short status,
                                Integer creatorId, Integer addressId, String creator, Integer channelNum,
                                String province, String city, String adressDetail);

    /**
     * 根据机器id删除机器
     *
     * @param machineId
     * @return
     */
    ResultJson deleteMachineByMachineId(Integer machineId);

}

