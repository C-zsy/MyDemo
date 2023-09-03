package com.chinasoft.demo.controller;

import com.chinasoft.demo.pojo.Goods;
import com.chinasoft.demo.pojo.Material;
import com.chinasoft.demo.service.GoodsService;
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
public class GoodsController extends BaseController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("selectGoods")
    public ModelAndView list(){
        ModelAndView modelAndView=new ModelAndView();
        List<Goods> list=goodsService.selectGoods();
        //System.out.println(list);
        modelAndView.addObject("Goodslist",list);
        modelAndView.setViewName("MaterialList");
        return modelAndView;
    }

    @GetMapping("insertGoods")
    public String insertGoods(HttpSession session){
        return session.getAttribute("user") == null? "redirect:/index" : "material/materialAdd";
        //return "material/materialAdd";
    }

    @PostMapping("insertGoods2")
    public String insertGoods2(Goods goods){
        goodsService.insertGoods(goods);
        return "redirect:queryGoodsList?pageIndex=1&pageSize=3";
    }

    @GetMapping("deleteGoods")
    public String deleteGoods(HttpSession session){
        //判断用户
        return session.getAttribute("user") == null? "redirect:/index" : "redirect:queryGoodsList?pageIndex=1&pageSize=3";
    }

    @GetMapping("delGoods")
    public String delGoods(@RequestParam("ids") String ids){
        int count=goodsService.deleteGoodsByIds(getDeleteData(ids));
        return "redirect:queryGoodsList?pageIndex=1&pageSize=3";
    }


    @GetMapping("updateGoods1")
    public  String updateGoods(HttpSession session){
        return session.getAttribute("user") == null? "redirect:/index" : "redirect:queryGoodsList?pageIndex=1&pageSize=3";
    }

    @GetMapping("updateGoods2")
    public  String updateGoods2(HttpServletRequest request){
        String id = request.getParameter("id");
        System.out.println(id);
        request.setAttribute("goodsId",id);
        return "material/materialUpdate";
    }

    @PostMapping("updateGoods3")
    public  String updateGoods3(HttpServletRequest request){
        String id = request.getParameter("materialId");
        System.out.println(id);
        int id_int=Integer.parseInt(id);
        String name = request.getParameter("name");
        String count = request.getParameter("count");
        int count_int=Integer.parseInt(count);
        String price = request.getParameter("price");
        float price_float=Float.parseFloat(price);
        System.out.println(price_float);
        String inDate = request.getParameter("InDate");
        String outDate = request.getParameter("OutDate");
        goodsService.updateGoods(name,count_int,price_float,inDate,outDate,id_int);
        return "redirect:queryGoodsList?pageIndex=1&pageSize=3";
    }

    @PostMapping("goodsSearch")
    public String searchList(HttpServletRequest request) {
        Map<String, Object> map = getParamMap(request);
        System.out.println("map:" + map.toString());
        List<Map<String, Object>> list = goodsService.searchList(map);
        request.setAttribute("searchList", list);
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map1 = list.get(i);
            System.out.println("map1:" + map1.toString());
            //System.out.println(map1.get("admin_account"));
        }
        return "material/materialSearchList";
    }

    @GetMapping("queryGoodsList")
    public ModelAndView queryUserList(HttpServletRequest request,HttpSession session){

        Map<String,Object> dataMap=getParamMap(request);
        //System.out.println(dataMap);
//        dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
//        dataMap.put("list",userService.queryUserList(dataMap));
        // dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
        List list=goodsService.queryGoodsList(getPageBean(dataMap,goodsService.selectManageCount(dataMap)));
        session.setAttribute("queryList",list);
        System.out.println(list);
        dataMap.put("list",list);
        //dataMap.put("list",materialService.queryTypeList(getPageBean(dataMap,materialService.selectManageCount(dataMap))));
        //request.setAttribute("map",dataMap);
        return new ModelAndView("materialList",dataMap);
    }

    @PostMapping("queryGoodsList2")
    public ModelAndView queryUserList2(HttpServletRequest request,HttpSession session){

        Map<String,Object> dataMap=getParamMap(request);
        //System.out.println(dataMap);
//        dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
//        dataMap.put("list",userService.queryUserList(dataMap));
        // dataMap=getPageBean(dataMap,userService.selectUserManageCount(dataMap));
        List list=goodsService.queryGoodsList(getPageBean(dataMap,goodsService.selectManageCount(dataMap)));
        session.setAttribute("queryList",list);
        //System.out.println(list);
        dataMap.put("list",list);
        //dataMap.put("list",materialService.queryTypeList(getPageBean(dataMap,materialService.selectManageCount(dataMap))));
        //request.setAttribute("map",dataMap);
        return new ModelAndView("material/materialSearchList",dataMap);
    }
}
