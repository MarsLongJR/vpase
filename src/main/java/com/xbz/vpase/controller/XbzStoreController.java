package com.xbz.vpase.controller;

import com.xbz.vpase.persistent.entity.XbzStore;
import com.xbz.vpase.persistent.entity.XbzStorePriceLine;
import com.xbz.vpase.response.ResultJson;
import com.xbz.vpase.response.RetCode;
import com.xbz.vpase.service.XbzStorePriceLineService;
import com.xbz.vpase.service.XbzStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 关于商品查询，修改，删除以及商品的价修改记录查询
 */
@Controller
@RequestMapping("store")
public class XbzStoreController {

    @Autowired
    private XbzStoreService xbzStoreService;

    @Autowired
    private XbzStorePriceLineService xbzStorePriceLineService;


    /**
     * 添加商品
     * @param xbzStore
     * @return
     */
    @RequestMapping("insetSysStore")
    public @ResponseBody ResultJson insetSysStore(@RequestBody XbzStore xbzStore){
        ResultJson resultJson = new ResultJson();
        try {
            if(xbzStore!=null&&xbzStore.getBarcode()!=null&&xbzStore.getCategoryId()!=null&&xbzStore.getStoreName()!=null){
                resultJson = xbzStoreService.insetSysStore(xbzStore);
            }else{
                resultJson.ResultJson(RetCode.PARAM_NULL);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultJson;
    }

    /**
     * 分页查询商品
     * @param id 商品id
     * @param storeName 商品名称
     * @param barcode 商品条码
     * @param price 商品价格
     * @param startDate 商品添加时间
     * @param endDate 商品添加时间
     * @param enable 是否存在
     * @param  categoryId 商品类别id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("selectXbzStorePage")
    public @ResponseBody Map<String ,Object> selectXbzStorePage(Integer id, String storeName, String barcode,String sysName, String sysCode, String price, String startDate, String endDate, Boolean enable, Integer categoryId,Integer pageNum, Integer pageSize){
        Map<String ,Object> objectMap = new HashMap<>();
        try {
            List<XbzStore> xbzStores = xbzStoreService.selectXbzStoreList(id,storeName,barcode,sysName,sysCode,price,startDate,endDate,enable,categoryId,pageNum,pageSize);
            Integer totalCount = xbzStoreService.selectXbzStoreCount(id,storeName,barcode,sysName,sysCode,price,startDate,endDate,enable,categoryId);
            objectMap.put("list",xbzStores);
            objectMap.put("count",totalCount);
            return objectMap;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 修改商品信息
     * @param id
     * @param storeName
     * @param barcode
     * @param sysName
     * @param sysCode
     * @param price
     * @param enable
     * @param categoryId
     * @return
     */
    @RequestMapping("modifyXbzStore")
    public @ResponseBody ResultJson modifyXbzStore(Integer id, String storeName, String barcode, String sysName, String sysCode,String price, Boolean enable, Integer categoryId){
        ResultJson resultJson = new ResultJson();
        try {
            resultJson = xbzStoreService.modifyXbzStore(id,storeName,barcode,sysName,sysCode,price,enable,categoryId);
            return resultJson;
        }catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return resultJson;

    }


    /**
     * 根据商品id查询商品的所有价格记录
     * @param storeId 商品id
     * @return
     */
    @RequestMapping("selectXbzStorePriceLineByStore")
    public @ResponseBody ResultJson selectXbzStorePriceLineByStore(Integer storeId){
        ResultJson resultJson = new ResultJson();
        try {
            List<XbzStorePriceLine> lines= xbzStorePriceLineService.selectXbzStorePriceLineByStore(storeId);
            resultJson.ResultJson(RetCode.OK);
            resultJson.setData(lines);
        }catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return resultJson;
    }

    /**
     * 查询某个商品的详情
     * @param storeId
     * @return
     */
    @RequestMapping("selectXbzStoreByStoreId")
    public @ResponseBody ResultJson selectXbzStoreByStoreId(Integer storeId){
        ResultJson resultJson = new ResultJson();
        try {
            XbzStore store = xbzStoreService.get(storeId);
            resultJson.ResultJson(RetCode.OK);
            resultJson.setData(store);
        }catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return resultJson;
    }

    /**
     *查询某一商品的详情
     * @param storeId
     * @return
     */
    @RequestMapping("selectXbzStoreById")
    public @ResponseBody ResultJson selectXbzStoreById(Integer storeId){
        ResultJson resultJson = new ResultJson();
        try {
            XbzStore store = xbzStoreService.get(storeId);
            resultJson.setData(store);
            resultJson.ResultJson(RetCode.OK);
        }catch (Exception e){
            e.printStackTrace();
            resultJson.ResultJson(RetCode.ERROR);
        }
        return resultJson;
    }


}
