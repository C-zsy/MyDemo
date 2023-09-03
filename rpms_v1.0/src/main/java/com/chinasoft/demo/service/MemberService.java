package com.chinasoft.demo.service;

import com.chinasoft.demo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public String memberAdd(Map<String, Object> map, HttpSession session){
        String result = "";
        int a = memberMapper.memberAdd(map);
        session.setAttribute("member", map);
        result = "redirect:/queryMemberList?pageIndex=1&pageSize=5";

        return result;
    }

    public String memberList(HttpSession session){
        String result = "";
        List<Map<String, Object>> list = memberMapper.memberList();
        System.out.println(list);
        session.setAttribute("listmember", list);
        result = "redirect:/member/memberList";

        return result;
    }

    public String memberUpdate(Map<String, Object> map, HttpSession session){

        String id = (String) map.get("memberId");
        System.out.println(id);
        id = id.replace(",", "");
        map.put("memberId", id);
        memberMapper.memberUpdate(map);
        session.setAttribute("update", map);
        return "redirect:/queryMemberList?pageIndex=1&pageSize=5";

    }

    public List<Map<String,Object>> memberSearchList(Map<String,Object> map){

        return  memberMapper.memberSearchList(map);
    }

    public int memberDelete(List<Integer> ids){

        return memberMapper.memberDelete(ids);
    }

    public List<Map<String,Object>> querymemberList(Map<String, Object> map){

        return memberMapper.querymemberList(map);
    }

    public int selectManageCount(Map<String, Object> map){
        return memberMapper.selectManageCount(map);
    }
}
