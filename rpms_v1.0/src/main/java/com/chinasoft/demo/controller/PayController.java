package com.chinasoft.demo.controller;

import com.chinasoft.demo.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

//@RestController
@Controller
public class PayController extends BaseController {

    private static final Logger log= LoggerFactory.getLogger(PayController.class);

    @Autowired
    private PayService payService;


    @GetMapping("payAdd")
    public String payAdd(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "pay/payAdd";
    }

    @PostMapping("payAdd")
    public String buildAdd(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        return payService.payAdd(map, session);
    }

    @GetMapping("payList")
    public String payList(HttpSession session){
        payService.payList(session);

        return session.getAttribute("user") == null ? "redirect:/index" : "pay/payList";
    }

    @GetMapping("payUpdate")
    public String payUpdate(HttpServletRequest session, @RequestParam("id") String id, HttpServletRequest request){
        Map<String, Object> paramMap = getParamMap(request);
        System.out.println("update:" + paramMap);
        request.setAttribute("newId", id);
        return "pay/payUpdate";
    }


    @PostMapping("payUpdate")
    public String payUpdate(HttpServletRequest request, HttpSession session){

        Map<String, Object> map = getParamMap(request);
        String id = (String) map.get("payId");
        id = id.replace(",", "");

        return payService.payUpdate(map, session);
    }

    @GetMapping("paySend")
    public String paySend(HttpServletRequest session, @RequestParam("id") String id, HttpServletRequest request){
        Map<String, Object> paramMap = getParamMap(request);
        System.out.println("update:" + paramMap);
        request.setAttribute("newId", id);
        return "pay/paySend";
    }

    @PostMapping("paySend")
    public String paySend(HttpServletRequest request, HttpSession session){

        Map<String, Object> map = getParamMap(request);
        String id = (String) map.get("payId");
        id = id.replace(",", "");

        return payService.paySend(map, session);
    }

    @GetMapping("paySearchList")
    public String paySearchList(HttpSession session){
        return session.getAttribute("user") == null ? "redirect:/index" : "pay/paySearchList";
    }

    @PostMapping("paySearchList")
    public String paySearchList(HttpServletRequest request, HttpSession session){
        Map<String,Object> map=getParamMap(request);
        System.out.println("map:"+map.toString());
        List<Map<String,Object>> list=payService.paySearchList(map);
        session.setAttribute("searchList", list);
        for(int i=0;i<list.size();i++){
            Map<String,Object> map1=list.get(i);
            System.out.println("map1:"+map1.toString());
            //System.out.println(map1.get("admin_account"));
        }
        return "pay/paySearchList";
    }

    @PostMapping("payDelete")
    public String payDelete(@RequestParam("checkone") String ids){
        System.out.println(ids);
        payService.payDelete(getDeleteData(ids));
        return "redirect:/queryPayList?pageIndex=1&pageSize=5";
    }

    @GetMapping("queryPayList")
    public ModelAndView querypayList(HttpServletRequest request, HttpSession session){

        Map<String,Object> dataMap=getParamMap(request);
        System.out.println("dataMap:" + dataMap);
        System.out.println("manage:" + payService.selectManageCount(dataMap));
        List<Map<String, Object>> list = payService.queryPayList(getPageBean(dataMap, payService.selectManageCount(dataMap)));
        System.out.println(list);
        session.setAttribute("listQuery", list);
        dataMap.put("list",payService.queryPayList(getPageBean(dataMap,payService.selectManageCount(dataMap))));
        return new ModelAndView("pay/payList",dataMap);
    }

    @PostMapping("queryPayList")
    public ModelAndView queryPayList1(HttpServletRequest request, HttpSession session){

        Map<String,Object> dataMap=getParamMap(request);
        System.out.println("dataMap:" + dataMap);
        System.out.println("manage:" + payService.selectManageCount(dataMap));
        List<Map<String, Object>> list = payService.queryPayList(getPageBean(dataMap, payService.selectManageCount(dataMap)));
        System.out.println(list);
        session.setAttribute("listQuery", list);
        dataMap.put("list",payService.queryPayList(getPageBean(dataMap,payService.selectManageCount(dataMap))));
        return new ModelAndView("pay/paySearchList",dataMap);
    }

}
