package com.wys.demo.web;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.wys.demo.entity.Area;
import com.wys.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    private Map<String,Object> listArea(){
        Map<String,Object>modeMap=new HashMap<String, Object>();
        List<Area> list=areaService.getAreaList();
        modeMap.put("areaList",list);
        return modeMap;
    }
    @RequestMapping(value ="/getareabyid",method = RequestMethod.GET)
   private Map<String,Object>getAreaById(Integer areaId){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        Area area=areaService.getAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }
    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
    private  Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> modelMap=new HashMap<String, Object>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }
    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    private Map<String, Object> modifyArea(@RequestBody Area area)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", areaService.modifyArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/removearea", method = RequestMethod.GET)
    private Map<String, Object> removeArea(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", areaService.deleteArea(areaId));
        return modelMap;
    }



}
