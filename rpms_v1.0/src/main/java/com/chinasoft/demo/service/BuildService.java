package com.chinasoft.demo.service;

import com.chinasoft.demo.mapper.BuildMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BuildService {
    @Autowired
    private BuildMapper buildMapper;

    public String buildAdd(Map<String, Object> map, HttpSession session) {
        int a = buildMapper.buildAdd(map);
        session.setAttribute("build", map);

        //return "redirect:/buildList";
        return "redirect:/queryBuildList?pageIndex=1&pageSize=3";
    }

    public String buildList(Map<String, Object> map, HttpSession session) {
        List<Map<String,Object>> list = buildMapper.buildList(map);
        session.setAttribute("buildList", list);

        return "redirect:/buildList";
    }

    public String buildSearchList(Map<String, Object> map, HttpSession session) {
        List<Map<String,Object>> list = buildMapper.buildSearchList(map);
        session.setAttribute("buildSearchList", list);

        return "build/buildList";
    }

    public String buildUpdate(Map<String, Object> map, HttpSession session) {
        buildMapper.buildUpdate(map);
        //session.setAttribute("list", map);
        //System.out.println(map.toString());

        return "redirect:/queryBuildList?pageIndex=1&pageSize=3";
    }

    public int deleteBuildByIds(List<Integer> list) {

        return buildMapper.deleteBuildByIds(list);
    }

    public List<Map<String, Object>> queryBuildList(Map<String, Object> map) {
        return buildMapper.queryBuildList(map);
    }

    public int selectBuildManageCount(Map<String, Object> map) {
        return buildMapper.selectBuildManageCount(map);
    }
}
