package com.chinasoft.demo.controller;

import com.chinasoft.demo.service.BuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class BuildController extends BaseController {
    @Autowired
    private BuildService buildService;

    @GetMapping("buildAdd")
    public String buildAdd(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "build/buildAdd";
    }

    @PostMapping("buildAdd")
    public String buildAdd(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        return buildService.buildAdd(map, session);
    }

    @GetMapping("buildList")
    public String buildList(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        buildService.buildList(map, session);
        return session.getAttribute("user") == null ? "redirect:/index" : "build/buildList";
    }

    @PostMapping("buildList")
    public String buildList1(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);

        return buildService.buildList(map, session);
    }

    @PostMapping("buildDelete")
    public String buildDelete(@RequestParam("checkone") String ids) {
        int count = buildService.deleteBuildByIds(getDeleteData(ids));

        return "redirect:/queryBuildList?pageIndex=1&pageSize=3";
    }

    @GetMapping("buildSearchList")
    public String buildSearchList(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "build/buildSearchList";
    }

    @PostMapping("buildSearchList")
    public String buildSearchList(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        buildService.buildSearchList(map, session);

        return "redirect:/buildSearchList";
    }

    @GetMapping("buildUpdate")
    public String buildUpdate(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        session.setAttribute("Id", map.get("id"));
        //System.out.println("Get:" + map.toString());

        return session.getAttribute("user") == null ? "redirect:/index" : "build/buildUpdate";
    }

    @PostMapping("buildUpdate")
    public String buildUpdate1(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        //System.out.println(map.toString());

        return buildService.buildUpdate(map, session);
    }

    @GetMapping("queryBuildList")
    public ModelAndView queryBuildList(HttpServletRequest request, HttpSession session) {
        Map<String, Object> dataMap = getParamMap(request);
        //System.out.println(dataMap.toString());
        dataMap = getPageBean(dataMap, buildService.selectBuildManageCount(dataMap));
        List<Map<String, Object>> maps = buildService.queryBuildList(dataMap);
        session.setAttribute("queryList", maps);
        dataMap.put("list", maps);
        return session.getAttribute("user") == null ? new ModelAndView("index", dataMap) : new ModelAndView("build/buildList", dataMap);
    }
}
