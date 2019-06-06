package com.imooc.myo2o.web.superadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.myo2o.dto.AreaExecution;
import com.imooc.myo2o.entity.Area;
import com.imooc.myo2o.entity.ConstantForSuperAdmin;
import com.imooc.myo2o.enums.AreaStateEnum;
import com.imooc.myo2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    AreaService areaService;


    @RequestMapping(value = "/listareas",method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listAreas() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> list = new ArrayList<Area>();
        try {
            list = areaService.getAreaList();
            modelMap.put(ConstantForSuperAdmin.PAGE_SIZE, list);
            modelMap.put(ConstantForSuperAdmin.TOTAL, list.size());

        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
//    @ResponseBody
    private String listAreas1() {

        return "superadmin/login";
    }

    @RequestMapping(value = "/main",method = RequestMethod.GET)
//    @ResponseBody
    private String tomain() {
        System.out.println("我**###############进来了#####################");
        System.out.println("我**###############进来了#####################");
        System.out.println("我**###############进来了#####################");

        System.out.println("我**###############进来了#####################");
        System.out.println("我**###############进来了#####################");
        System.out.println("我**###############进来了#####################");

        return "superadmin/main";
    }

    @RequestMapping(value = "/headlinemanage1", method = RequestMethod.GET)
    private String headLineManagement() {
        System.out.println("我进来了#############headlinemanage#############");
        return "superadmin/headlinemanage";
    }
    @RequestMapping(value = "/shopmanage", method = RequestMethod.GET)
    private String shopManager() {
        System.out.println("我进来了#############shopmanage#############");
        return "superadmin/shopmanage";
    }
    @RequestMapping(value = "/areamanage", method = RequestMethod.GET)
    private String areamanage() {
        System.out.println("我进来了#############areamanage#############");
        return "superadmin/areamanage";
    }
    @RequestMapping(value = "/personinfomanager", method = RequestMethod.GET)
    private String personinfomanager() {
        System.out.println("我进来了#############personinfomanager#############");
        return "superadmin/personinfomanage";
    }

    /**
     * 区域管理 添加新区域
     */
    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> addArea(String areaStr, HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        ObjectMapper mapper = new ObjectMapper();
        Area area = null;
        try {
            area = mapper.readValue(areaStr,Area.class);
            area.setAreaName((area.getAreaName()==null)?null: URLDecoder.decode(area.getAreaName(),"utf-8"));
            area.setAreaDesc((area.getAreaDesc()==null)?null: URLDecoder.decode(area.getAreaDesc(),"utf-8"));
            System.out.println("AreaName:   "+area.getAreaName());
            System.out.println("AreaDesc:  "+area.getAreaDesc());

        } catch (IOException e) {
            modelMap.put("sucess",false);
            modelMap.put("errMsg",e.toString());
        }
        if(area!=null&&area.getAreaName()!=null){
//            areaService
            try{
                AreaExecution ae = areaService.addArea(area);
                if(AreaStateEnum.SUCCESS.getState()==ae.getState()){
                    modelMap.put("success",true);
                }else{
                    modelMap.put("success",false);
                    modelMap.put("errMsg",ae.getStateInfo());
                }
            }catch(RuntimeException e){
                modelMap.put("success",false);
                modelMap.put("errMsg",e.toString());
            return modelMap;
            }

        }else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入区域信息");
        }

        return modelMap;
    }

















}
