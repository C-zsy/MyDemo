package com.chinasoft.demo.controller;

import com.chinasoft.demo.service.OwnerService;
import com.chinasoft.demo.service.UserService;
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
import java.util.*;

//@RestController
@Controller
public class OwnerController extends BaseController {

    private static final Logger log= LoggerFactory.getLogger(OwnerController.class);

    @Autowired
    private OwnerService ownerService;


    @GetMapping("ownerAdd")
    public String ownerAdd(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "owner/ownerAdd";
    }

    @PostMapping("ownerAdd")
    public String buildAdd(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        return ownerService.ownerAdd(map, session);
    }

    @GetMapping("ownerList")
    public String ownerList(HttpSession session){
        ownerService.ownerList(session);

        return session.getAttribute("user") == null ? "redirect:/index" : "owner/ownerList";
    }

    @GetMapping("ownerUpdate")
    public String ownerUpdate(HttpServletRequest session, @RequestParam("id") String id, HttpServletRequest request){
//        System.out.println(id);
//        int anInt = Integer.parseInt(id);
        request.setAttribute("newId", id);
//        return session.getAttribute("user") == null ? "redirect:/index" : "owner/ownerUpdate";
        return "owner/ownerUpdate";
    }


    @PostMapping("ownerUpdate")
    public String ownerUpdate(HttpServletRequest request, HttpSession session){

        Map<String, Object> map = getParamMap(request);
        System.out.println("update:" + map);
        request.setAttribute("c", map);
        String id = (String) map.get("ownerId");
//        id = id.replace(",", "");

//        System.out.println(i + "controller");
        return ownerService.ownerUpdate(map, session);
    }


    @GetMapping("ownerSearchList")
    public String ownerSearchList(HttpSession session){
        return session.getAttribute("user") == null ? "redirect:/index" : "owner/ownerSearchList";
    }

    @PostMapping("ownerSearchList")
    public String ownerSearchList(HttpServletRequest request, HttpSession session){
        Map<String,Object> map=getParamMap(request);
        System.out.println("search_map:"+map);
        List<Map<String,Object>> list=ownerService.ownerSearchList(map);
        session.setAttribute("searchList", list);
        for(int i=0;i<list.size();i++){
            Map<String,Object> map1=list.get(i);
            System.out.println("map1:"+map1.toString());
            //System.out.println(map1.get("admin_account"));
        }
        return "redirect:/ownerSearchList?pageIndex=1&pageSize=5";
    }



    @PostMapping("ownerDelete")
    public String ownerDelete(@RequestParam("checkone") String ids){
//        System.out.println(getDeleteData(ids));
        List<Integer> list = new ArrayList<>();
        ids = ids.replace(",", "");
        int start = 0;
        for (int end = 4; end <= ids.length(); end += 4) {
            String str = ids.substring(start, end);
            list.add(Integer.parseInt(str));
            start = end;
        }
        ownerService.ownerDelete(list);

        return "redirect:/queryOwnerList?pageIndex=1&pageSize=5";
    }

    @GetMapping("queryOwnerList")
    public ModelAndView queryOwnerList(HttpServletRequest request, HttpSession session){

        Map<String,Object> dataMap=getParamMap(request);
        System.out.println("dataMap:" + dataMap);
        System.out.println("manage:" + ownerService.selectManageCount(dataMap));
        List<Map<String, Object>> list = ownerService.queryOwnerList(getPageBean(dataMap, ownerService.selectManageCount(dataMap)));
        System.out.println(list);
        session.setAttribute("listQuery", list);
//        dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
//        dataMap.put("list",userService.queryUserList(dataMap));
        // dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
        dataMap.put("list",ownerService.queryOwnerList(getPageBean(dataMap,ownerService.selectManageCount(dataMap))));
        //request.setAttribute("map",dataMap);
        return session.getAttribute("user") == null ? new ModelAndView("index",dataMap): new ModelAndView("owner/ownerList",dataMap);
    }

    @PostMapping("queryOwnerList")
    public ModelAndView queryOwnerList1(HttpServletRequest request, HttpSession session){

        Map<String,Object> dataMap=getParamMap(request);
        List<Map<String, Object>> list = ownerService.queryOwnerList(getPageBean(dataMap, ownerService.selectManageCount(dataMap)));
        session.setAttribute("listQuery", list);

        dataMap.put("list",ownerService.queryOwnerList(getPageBean(dataMap,ownerService.selectManageCount(dataMap))));
        //request.setAttribute("map",dataMap);
        return session.getAttribute("user") == null ? new ModelAndView("index",dataMap): new ModelAndView("owner/ownerSearchList",dataMap);
    }


}
