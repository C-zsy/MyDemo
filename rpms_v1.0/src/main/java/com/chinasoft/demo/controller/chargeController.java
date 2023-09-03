package com.chinasoft.demo.controller;


import com.chinasoft.demo.service.chargeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
@Controller
public class chargeController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(chargeController.class);

    @Autowired
    private chargeService userService;

    @GetMapping("chargeAdd")
    public String chargeAdd(){

        return "chargeAdd";
    }

    @PostMapping("chargeAdd")
    public String insertCharge(HttpServletRequest request){
        //userService.insertBuild(getParamMap(request),session);
        Map<String,Object> map=getParamMap(request);
       // System.out.println(map.toString());
        int count=userService.insertCharge(map);

        return "redirect:/queryChargeList?pageIndex=1&pageSize=3";
    }

        @RequestMapping("chargeList")
    public String chargeList(HttpServletRequest request){
        request.setAttribute("list",userService.selectChargeList());
           // System.out.println(userService.selectChargeList());
       // log.info(d.getClass().toString());
        return "chargeList";
    }

    @GetMapping("chargeDelete")
    public String chargedelete(){

        return "redirect:queryChargeList?pageIndex=1&pageSize=3";
    }

    @GetMapping("updateCharge")
    public String updateCharge3(){
        return "redirect:queryChargeList?pageIndex=1&pageSize=3";
    }
    @GetMapping("chargeUpdate")
    public String updateCharge(HttpServletRequest request){
        //userService.insertBuild(getParamMap(request),session);
        Map<String,Object> map=getParamMap(request);
      //  System.out.println(map);
        request.setAttribute("c",map);
        return "chargeUpdate";
    }

    @PostMapping("chargeUpdate")
    public String updateCharge2(HttpServletRequest request){
        Map<String,Object> map=getParamMap(request);
      //  System.out.println(map);
        userService.updateCharge2(map);
        return "redirect:queryChargeList?pageIndex=1&pageSize=3";
    }

    @GetMapping("deleteCharge")
    public String deleteCharge(@RequestParam ("ids") String ids){
        //System.out.println(ids.toString());
        int count=userService.deleteCharge(getDeleteData(ids));
        return "redirect:queryChargeList?pageIndex=1&pageSize=3";
    }


    @GetMapping("queryChargeList")
    public ModelAndView queryUserList(HttpServletRequest request,HttpSession session){

        Map<String,Object> dataMap=getParamMap(request);
        //System.out.println(dataMap);
//        dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
//        dataMap.put("list",userService.queryUserList(dataMap));
        // dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
        List list=userService.queryChargeList(getPageBean(dataMap,userService.selectChargeManageCount(dataMap)));

        session.setAttribute("queryList",list);
        //System.out.println(list);
        dataMap.put("list",list);
        //dataMap.put("list",materialService.queryTypeList(getPageBean(dataMap,materialService.selectManageCount(dataMap))));
        //request.setAttribute("map",dataMap);
        return new ModelAndView("chargeList",dataMap);
    }

    @PostMapping("queryChargeList2")
    public ModelAndView queryUserList2(HttpServletRequest request,HttpSession session){

        Map<String,Object> dataMap=getParamMap(request);
        //System.out.println(dataMap);
//        dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
//        dataMap.put("list",userService.queryUserList(dataMap));
        // dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
        List list=userService.queryChargeList(getPageBean(dataMap,userService.selectChargeManageCount(dataMap)));

        session.setAttribute("queryList",list);
        //System.out.println(list);
        dataMap.put("list",list);
        //dataMap.put("list",materialService.queryTypeList(getPageBean(dataMap,materialService.selectManageCount(dataMap))));
        //request.setAttribute("map",dataMap);
        return new ModelAndView("chargeSearchList",dataMap);
    }
}
