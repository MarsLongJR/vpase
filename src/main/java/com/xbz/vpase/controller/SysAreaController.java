package com.xbz.vpase.controller;

import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.service.SysAreaService;
import com.xbz.vpase.utils.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 区域
 */
@Controller
@RequestMapping("area")
    public class SysAreaController {

    @Autowired
    private SysAreaService sysAreaService;

    /**
     * 区域查询
     * @param
     * @return
     */
    @RequestMapping("selectSysAreaList")
    public  @ResponseBody ResultJson selectSysAreaList(String parentCode, String areaName,String areaCode){
        try {
            ResultJson resultJson = sysAreaService.selectSysAreaList(parentCode, areaName, areaCode);
            return resultJson;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
