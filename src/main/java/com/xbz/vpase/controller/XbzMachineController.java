package com.xbz.vpase.controller;

import com.xbz.vpase.persistent.entity.XbzMachine;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.service.XbzMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @company:www.xinbeize.com
 * @author:Mars
 * 关于机器的增删改查
 */
@Controller
@RequestMapping("machine")
public class XbzMachineController {
    @Autowired
    private XbzMachineService xbzMachineService;

    /**
     * 新增机器
     * @param xbzMachine
     * @return
     */
    @RequestMapping("insertXbzMachine")
    public @ResponseBody
    ResultJson insertXbzMachine(@RequestBody XbzMachine xbzMachine) {
        ResultJson resultJson = new ResultJson();
        try {
            if (xbzMachine != null&&xbzMachine.getMachineType()!=null&&xbzMachine.getMachineName()!=null&&xbzMachine.getMachineCode()!=null&&xbzMachine.getMachineType()!=null) {
                resultJson = xbzMachineService.insertXbzMachine(xbzMachine);
                return resultJson;
            } else {
                resultJson.ResultJson(RetCode.ERROR);
                resultJson.setMessage("增加机器失败");
                return resultJson;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据各个查询（机器名称，机器编号，机器类型，机器状态，存放地址，开机时间，关机时间，货道数量），查询机器
     * @param machineId         机器id
     * @param machineCode       机器编号
     * @param machineType       机器类型
     * @param status            机器状态
     * @param creatorId         创建者id
     * @param connectStatus     连接状态
     * @param temperatureStatus 温度状态
     * @param addressId         存放地址
     * @param creator           创建者
     * @param openTime          开机时间
     * @param offTime           关机时间
     * @param channelNum        货道数量
     * @param province          机器所在地址省份
     * @return machineMap 机器
     */
    @RequestMapping("queryMachinePage")
    public @ResponseBody
    Map<String, Object> queryMachinePage(Integer machineId, String machineName, String machineCode, Short machineType,String startDate,String endDate
            , Short status, Integer creatorId, Boolean connectStatus, Short temperatureStatus , Integer addressId, String creator, String openTime
            , String offTime, Integer channelNum,String province,String city,String adressDetail,Integer pageNum, Integer pageSize ) {
        ResultJson resultJson = new ResultJson();
        Map<String, Object> objectMap = new HashMap<>();
        try {
            List<XbzMachine> xbzMachines = xbzMachineService.selectXbzMachineList(
                    machineId,machineName,machineCode,machineType,startDate,
                    endDate,status,creatorId,connectStatus,temperatureStatus,addressId,
                    creator,openTime,offTime,channelNum,province,city,adressDetail,pageNum,pageSize);
            Integer machineCount = xbzMachineService.selectXbzMachineCount(machineId,machineName,machineCode,machineType
                    ,startDate, endDate,status,creatorId,connectStatus,
                    temperatureStatus,addressId,creator,openTime,offTime,channelNum,province,city,adressDetail);
            objectMap.put("list", xbzMachines);
            objectMap.put("count",machineCount);
            return objectMap;
        } catch (Exception e) {
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
            resultJson.setMessage("操作失败");
            objectMap.put("list", resultJson);
        }
        return null;
    }

    /**
     *修改机器的信息
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
    @RequestMapping("modifyXbzMachine")
    public @ResponseBody
    ResultJson modifyXbzMachine(Integer machineId, String machineName, String machineCode, Short status,
                                Integer creatorId, Integer addressId, String creator, Integer channelNum, String province, String city, String adressDetail) {
        ResultJson resultJson = new ResultJson();
        try {
            resultJson =xbzMachineService.modifyXbzMachine(machineId, machineName, machineCode, status,
                    creatorId, addressId, creator,channelNum,province,city,adressDetail);
            return resultJson;
        } catch (Exception e) {
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return resultJson;
    }

    /**
     * 根据机器的id删除机器
     * @param machineId
     * @return
     */
    @RequestMapping("deleteMachineByMachineId")
    @ResponseBody
    public ResultJson deleteMachineByMachineId(Integer machineId) {
        ResultJson resultJson = new ResultJson();
        try {
            resultJson=xbzMachineService.deleteMachineByMachineId(machineId);
            resultJson.ResultJson(RetCode.OK);
            resultJson.setData("删除机器成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
            resultJson.setData("删除机器失败");
        }
        return resultJson;
    }





}

