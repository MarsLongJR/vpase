package com.xbz.vpase.service.impl;

import com.xbz.vpase.dao.XbzMachineDao;
import com.xbz.vpase.persistent.entity.XbzMachine;
import com.xbz.vpase.request.XbzMachineRequest;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.service.XbzMachineService;
import com.xbz.vpase.service.base.impl.BaseServiceImpl;
import com.xbz.vpase.utils.TextUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @company:www.xinbeize.com
 * @author:Mars
 */
@Service
public class XbzMachineServiceImpl extends BaseServiceImpl<XbzMachine> implements XbzMachineService {
    @Resource
    private XbzMachineDao xbzMachineDao;
    @Resource
    public void setBaseDao(XbzMachineDao xbzMachineDao) {
        super.setBaseDao(xbzMachineDao);
    }
    /*
    参数是否为空
     */
    private XbzMachineRequest paramIsNull(Integer machineId, String machineName, String machineCode, Short machineType,String startDate,String endDate
            , Short status, Integer creatorId, Boolean connectStatus, Short temperatureStatus
            , Integer addressId, String creator, String openTime, String offTime, Integer channelNum,String province,String city,String adressDetail,Integer pageNum, Integer pageSize){
      try {
          XbzMachineRequest request = new XbzMachineRequest();
          if (machineId != null) {
              request.setId(machineId);
          }
          if (machineCode!=null){
              request.setMachineCode(machineCode);
          }
          if (!TextUtil.isEmpty(machineName)) {
              request.setMachineName(machineName);
          }
          if (machineType != null) {
              request.setMachineType(machineType);
          }
          if (!TextUtil.isEmpty(startDate)) {
              request.setStartDate(startDate + " 00:00:00");
          }
          if (!TextUtil.isEmpty(endDate)) {
              request.setEndDate(endDate + "23:59:59");
          }
          if (status != null) {
              request.setStatus(status);
          }
          if (creatorId != null) {
              request.setCreatorId(creatorId);
          }
          if (creator != null) {
              request.setCreator(creator);
          }
         /* Boolean connectStatus, Short temperatureStatus
                  , Integer addressId, String creator, Date openTime, Date offTime, Integer channelNum*/
          if (connectStatus != null) {
              request.setConnectStatus(connectStatus);
          }
          if (temperatureStatus != null) {
              request.setTemperatureStatus(temperatureStatus);
          }
          if (addressId != null) {
              request.setAddressId(addressId);
          }
          if (openTime != null) {
              request.setOpenTime(openTime);
          }
          if (offTime != null) {
              request.setOffTime(offTime);
          }
          if (channelNum != null) {
              request.setChannelNum(channelNum);
          }
          if (province!=null){
              request.setProvince(province);
          }
          if (city!=null){
              request.setCity(city);
          }
          if (adressDetail!=null){
              request.setAdressDetail(adressDetail);
          }
          if(pageNum!=null && pageSize!=null){
              request.setPage(pageNum,pageSize);
          }
          return request;
      }catch (Exception e){
          e.printStackTrace();
          return null;
      }
    }

    /*
   根据条件查询机器
    */
    @Override
    public List<XbzMachine> selectXbzMachineList(Integer machineId, String machineName, String machineCode, Short machineType,
                                             String startDate, String endDate, Short status, Integer creatorId, Boolean connectStatus,
                                             Short temperatureStatus, Integer addressId, String creator, String openTime, String offTime,
                                                 Integer channelNum,String province,String city,String adressDetail,
                                                 Integer pageNum, Integer pageSize) {
        try{
            XbzMachineRequest request=paramIsNull(machineId,machineName,machineCode,machineType,startDate,
                    endDate,status,creatorId,connectStatus,temperatureStatus,addressId,
                    creator,openTime,offTime,channelNum,province,city,adressDetail,pageNum,pageSize);
            List<XbzMachine> xbzMachines=xbzMachineDao.selectMachineList(request);
            return xbzMachines;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 分页查询
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
     * @return
     */
    @Override
    public Integer selectXbzMachineCount(Integer machineId, String machineName, String machineCode, Short machineType, String startDate, String endDate, Short status, Integer creatorId, Boolean connectStatus, Short temperatureStatus, Integer addressId, String creator, String openTime, String offTime, Integer channelNum, String province, String city, String adressDetail) {
        try {
            XbzMachineRequest request=paramIsNull(machineId,machineName,machineCode,machineType,startDate,
                    endDate,status,creatorId,connectStatus,temperatureStatus,addressId,
                    creator,openTime,offTime,channelNum,province,city,adressDetail,null,null);
            Integer machineCount=xbzMachineDao.selectXbzMachineCount(request);
            return machineCount;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 新增机器
     * @param xbzMachine
     * @return
     */
    @Override
    public ResultJson insertXbzMachine(XbzMachine xbzMachine) {
        ResultJson resultJson=new ResultJson();
        try{
            xbzMachineDao.save(xbzMachine);
            resultJson.ResultJson(RetCode.OK);
            resultJson.setMessage("新增机器成功");
        }catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson((RetCode.ERROR));
            resultJson.setMessage("新增机器失败");
        }
        return resultJson;
    }

    /**
     *修改机器参数
     * @param machineId
     * @param machineName
     * @param machineCode
     * @param status
     * @param creatorId
     * @param addressId
     * @param creator
     * @param channelNum
     * @return
     */
    @Override
    public ResultJson modifyXbzMachine(Integer machineId, String machineName, String machineCode, Short status,
                                       Integer creatorId, Integer addressId, String creator, Integer channelNum,String province, String city, String adressDetail) {
        ResultJson resultJson=new ResultJson();
        try {
            XbzMachine machine=xbzMachineDao.get(machineId);
            if(machine!=null){
                if(!TextUtil.isEmpty(machineName)){
                    machine.setMachineName(machineName);
                }
                if(!TextUtil.isEmpty(machineCode)){
                    machine.setMachineCode(machineCode);
                }
                if(status!=null){
                    machine.setStatus(status);
                }
                if(creatorId!=null){
                    machine.setCreatorId(creatorId);
                }
                if(addressId!=null){
                machine.setAddressId(addressId);
                }
                if(!TextUtil.isEmpty(creator)){
                    machine.setCreator(creator);
                }
                if (channelNum!=null){
                    machine.setChannelNum(channelNum);
                }
                if (province!=null){
                    machine.setProvince(province);
                }
                if (city!=null){
                    machine.setCity(city);
                }
                if (adressDetail!=null){
                    machine.setAdressDetail(adressDetail);
                }
                xbzMachineDao.save(machine);
                resultJson.ResultJson(RetCode.OK);
                resultJson.setMessage("修改成功");
            }

        }
        catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
            resultJson.setMessage("修改失败");
        return resultJson;
    }
    return resultJson;

    }

    /**
     * 根据机器id删除机器
     * @param machineId
     * @return
     */
    @Override
    public ResultJson deleteMachineByMachineId(Integer machineId) {
            ResultJson resultJson=new ResultJson();
        try {
            xbzMachineDao.deleteMachineByMachineId(machineId);
            resultJson.ResultJson(RetCode.OK);
            resultJson.setMessage("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return resultJson;
    }


}


