package com.chinasoft.demo.service;

import com.chinasoft.demo.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class PayService {

    @Autowired
    private PayMapper payMapper;

    public String payAdd(Map<String, Object> map, HttpSession session){
        String result = "";
        int a = payMapper.payAdd(map);
        session.setAttribute("pay", map);
        result = "redirect:/queryPayList?pageIndex=1&pageSize=5";

        return result;
    }

    public String payList(HttpSession session){
        String result = "";
        List<Map<String, Object>> list = payMapper.payList();
        System.out.println(list);
        session.setAttribute("listpay", list);
        result = "redirect:/pay/payList";

        return result;
    }

    public String payUpdate(Map<String, Object> map, HttpSession session){

        String id = (String) map.get("payId");
        System.out.println(id);
        id = id.replace(",", "");
        map.put("payId", id);
        payMapper.payUpdate(map);
        session.setAttribute("update", map);
        return "redirect:/queryPayList?pageIndex=1&pageSize=5";

    }

    public String paySend(Map<String, Object> map, HttpSession session){

        String id = (String) map.get("payId");
        System.out.println(id);
        id = id.replace(",", "");
        map.put("payId", id);
        payMapper.paySend(map);
        session.setAttribute("update", map);
        return "redirect:/queryPayList?pageIndex=1&pageSize=5";

    }

    public List<Map<String,Object>> paySearchList(Map<String,Object> map){

        return  payMapper.paySearchList(map);
    }

    public int payDelete(List<Integer> ids){

        return payMapper.payDelete(ids);
    }

    public List<Map<String,Object>> queryPayList(Map<String, Object> map){

        return payMapper.queryPayList(map);
    }

    public int selectManageCount(Map<String, Object> map){
        return payMapper.selectManageCount(map);
    }
}
