package com.chinasoft.demo.controller;

import com.chinasoft.demo.service.MemberService;
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
public class MemberController extends BaseController {

    private static final Logger log= LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;


    @GetMapping("memberAdd")
    public String memberAdd(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "member/memberAdd";
    }

    @PostMapping("memberAdd")
    public String buildAdd(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        return memberService.memberAdd(map, session);
    }

    @GetMapping("memberList")
    public String memberList(HttpSession session){
        memberService.memberList(session);

        return session.getAttribute("user") == null ? "redirect:/index" : "member/memberList";
    }

    @GetMapping("memberUpdate")
    public String memberUpdate(HttpServletRequest session, @RequestParam("id") String id, HttpServletRequest request){
        Map<String, Object> paramMap = getParamMap(request);
        System.out.println("update:" + paramMap);
        request.setAttribute("newId", id);
        return "member/memberUpdate";
    }


    @PostMapping("memberUpdate")
    public String memberUpdate(HttpServletRequest request, HttpSession session){

        Map<String, Object> map = getParamMap(request);
        String id = (String) map.get("memberId");
        id = id.replace(",", "");

        return memberService.memberUpdate(map, session);
    }

    @GetMapping("memberSearchList")
    public String memberSearchList(HttpSession session){
        return session.getAttribute("user") == null ? "redirect:/index" : "member/memberSearchList";
    }

    @PostMapping("memberSearchList")
    public String memberSearchList(HttpServletRequest request, HttpSession session){
        Map<String,Object> map=getParamMap(request);
        System.out.println("map:"+map.toString());
        List<Map<String,Object>> list=memberService.memberSearchList(map);
        session.setAttribute("searchList", list);
        for(int i=0;i<list.size();i++){
            Map<String,Object> map1=list.get(i);
            System.out.println("map1:"+map1.toString());
            //System.out.println(map1.get("admin_account"));
        }
        return "member/memberSearchList";
    }

    @PostMapping("memberDelete")
    public String memberDelete(@RequestParam("checkone") String ids){
        System.out.println(ids);
        memberService.memberDelete(getDeleteData(ids));
        return "redirect:/queryMemberList?pageIndex=1&pageSize=5";
    }

    @GetMapping("queryMemberList")
    public ModelAndView queryMemberList(HttpServletRequest request, HttpSession session){

        Map<String,Object> dataMap=getParamMap(request);
        System.out.println("dataMap:" + dataMap);
        System.out.println("manage:" + memberService.selectManageCount(dataMap));
        List<Map<String, Object>> list = memberService.querymemberList(getPageBean(dataMap, memberService.selectManageCount(dataMap)));
        System.out.println(list);
        session.setAttribute("listQuery", list);
        dataMap.put("list",memberService.querymemberList(getPageBean(dataMap,memberService.selectManageCount(dataMap))));
        return new ModelAndView("member/memberList",dataMap);
    }

    @PostMapping("queryMemberList")
    public ModelAndView queryMemberList1(HttpServletRequest request, HttpSession session){

        Map<String,Object> dataMap=getParamMap(request);
        System.out.println("dataMap:" + dataMap);
        System.out.println("manage:" + memberService.selectManageCount(dataMap));
        List<Map<String, Object>> list = memberService.querymemberList(getPageBean(dataMap, memberService.selectManageCount(dataMap)));
        System.out.println(list);
        session.setAttribute("listQuery", list);
        dataMap.put("list",memberService.querymemberList(getPageBean(dataMap,memberService.selectManageCount(dataMap))));
        return new ModelAndView("member/memberSearchList",dataMap);
    }

}
