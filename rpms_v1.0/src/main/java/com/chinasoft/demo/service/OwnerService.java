package com.chinasoft.demo.service;

import com.chinasoft.demo.mapper.OwnerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class OwnerService {

    @Autowired
    private OwnerMapper ownerMapper;

    public String ownerAdd(Map<String, Object> map, HttpSession session){
        String result = "";
        int a = ownerMapper.ownerAdd(map);
        session.setAttribute("owner", map);
        result = "redirect:/queryOwnerList?pageIndex=1&pageSize=5";

        return result;
    }

    public String ownerList(HttpSession session){
        String result = "";
        List<Map<String, Object>> list = ownerMapper.ownerList();
        System.out.println(list);
        session.setAttribute("listOwner", list);
        result = "redirect:/owner/ownerList";

        return result;
    }

//    public String ownerUpdate(Integer id, HttpSession session){
////        System.out.println(id);
////        int id_new = Integer.parseInt(id);
////        Map<String, Object> update = ownerMapper.ownerUpdate(id);
//        ownerMapper.ownerUpdate(id);
//        return "redirect:/ownerList";
//
//    }

    public String ownerUpdate(Map<String, Object> map, HttpSession session){
//        System.out.println(id);
//        int id_new = Integer.parseInt(id);
//        Map<String, Object> update = ownerMapper.ownerUpdate(id);
        String id = (String) map.get("ownerId");
        System.out.println(id);
        id = id.replace(",", "");
        map.put("ownerId", id);
        ownerMapper.ownerUpdate(map);
        session.setAttribute("update", map);
        return "redirect:/queryOwnerList?pageIndex=1&pageSize=5";

    }

    public List<Map<String,Object>> ownerSearchList(Map<String,Object> map){

        return  ownerMapper.ownerSearchList(map);
    }

    public int ownerDelete(List<Integer> ids){
//        String result = "";
//        int a = ownerMapper.ownerDelete(ids);
//        result = "redirect:/owner/ownerList";

        return ownerMapper.ownerDelete(ids);
    }

    public List<Map<String,Object>> queryOwnerList(Map<String, Object> map){

        return ownerMapper.queryOwnerList(map);
    }

    public int selectManageCount(Map<String, Object> map){
        return ownerMapper.selectManageCount(map);
    }

    public String searchList(Map<String, Object> map, HttpSession session) {
        List<Map<String, Object>> list = ownerMapper.ownerSearchList(map);
        session.setAttribute("Search", list);

        return "redirect:/";
    }
}
