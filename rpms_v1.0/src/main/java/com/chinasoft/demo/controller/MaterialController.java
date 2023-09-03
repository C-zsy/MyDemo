package com.chinasoft.demo.controller;

import com.chinasoft.demo.pojo.Material;
import com.chinasoft.demo.service.MaterialService;
import com.chinasoft.demo.service.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.*;


@Controller
public class MaterialController  extends BaseController{

    @Autowired
    private MaterialService materialService;


    @GetMapping("/selecttype")
    public ModelAndView list(){
        ModelAndView modelAndView=new ModelAndView();
        List<Material> list=materialService.SelectMaterial();
        modelAndView.addObject("typelist",list);
        modelAndView.setViewName("typeList");
        return modelAndView;
    }
    @GetMapping("typeAdd")
    public String typeAdd(HttpSession session){
        return session.getAttribute("user") == null? "redirect:/index" : "type/typeAdd";
    }

    @PostMapping("typeAdd")
    public String typeAdd(Material material){
         return materialService.insertType(material);
    }


    @GetMapping("typeUpdate1")
    public String typeUpdate(HttpSession session){
        //判断用户是否已经登录
        return session.getAttribute("user") == null? "redirect:/index" : "redirect:queryTypeList?pageIndex=1&pageSize=3";
       //return "redirect:selecttype";
    }

    @GetMapping("typeUpdate2")
    public String typeUpdate2(HttpServletRequest request){
        String id = request.getParameter("id");
        //System.out.println(id);
        request.setAttribute("newid",id);
        return "type/typeUpdate";
    }

    @PostMapping("typeUpdate3")
    public String typeUpdate3(@RequestParam("typeId") String id,@RequestParam("name") String typeName){
        //int count=materialService.typeUpdate(material);
        int typeId=Integer.parseInt(id);
        materialService.typeUpdate(typeName,typeId);
        return "redirect:queryTypeList?pageIndex=1&pageSize=3";
    }

    @GetMapping("typeDelete")
    public String typeDelete(HttpSession session){
        //判断用户是否已经登录，没登录就返回到登录页面
        return session.getAttribute("user") == null? "redirect:/index" : "redirect:queryTypeList?pageIndex=1&pageSize=3";
    }

    @GetMapping("typeDelete2")
    public String typeDelete2(@RequestParam("ids") String ids){
        //int count=userService.deleteUserByIds(getDeleteData(ids));
        int count=materialService.deleteTypeByIds(getDeleteData(ids));
        System.out.println(getDeleteData(ids));
        return "redirect:queryTypeList?pageIndex=1&pageSize=3";
    }

    @PostMapping("typeSearch")
    public String searchList(HttpServletRequest request){
        Map<String,Object> map=getParamMap(request);
        System.out.println("map:"+map.toString());
        List<Map<String,Object>> list=materialService.searchList(map);
        request.setAttribute("searchList", list);
        for(int i=0;i<list.size();i++){
            Map<String,Object> map1=list.get(i);
            System.out.println("map1:"+map1.toString());
            //System.out.println(map1.get("admin_account"));
        }
        return "type/typeSearchList";

    }



   /* @RequestMapping("index1")
    public String MaterialList(HttpServletRequest request){
        request.setAttribute("list",materialService.SelectMaterial());
        System.out.println(materialService.SelectMaterial());
        return "materialtype";
    }*/

    @GetMapping("queryTypeList")
    public ModelAndView queryUserList(HttpServletRequest request,HttpSession session){

        Map<String,Object> dataMap=getParamMap(request);
        //System.out.println(dataMap);
//        dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
//        dataMap.put("list",userService.queryUserList(dataMap));
        // dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
        List list=materialService.queryTypeList(getPageBean(dataMap,materialService.selectManageCount(dataMap)));
        session.setAttribute("queryList",list);
        //System.out.println(list);
        dataMap.put("list",list);
        //dataMap.put("list",materialService.queryTypeList(getPageBean(dataMap,materialService.selectManageCount(dataMap))));
        //request.setAttribute("map",dataMap);
        return new ModelAndView("typeList",dataMap);
    }

    @PostMapping("queryTypeList2")
    public ModelAndView queryUserList2(HttpServletRequest request,HttpSession session){

        Map<String,Object> dataMap=getParamMap(request);
        //System.out.println(dataMap);
//        dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
//        dataMap.put("list",userService.queryUserList(dataMap));
        // dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
        List list=materialService.queryTypeList(getPageBean(dataMap,materialService.selectManageCount(dataMap)));
        session.setAttribute("queryList",list);
        //System.out.println(list);
        dataMap.put("list",list);
        //dataMap.put("list",materialService.queryTypeList(getPageBean(dataMap,materialService.selectManageCount(dataMap))));
        //request.setAttribute("map",dataMap);
        return new ModelAndView("type/typeSearchList",dataMap);
    }

}
