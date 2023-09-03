package com.chinasoft.demo.controller;

import com.chinasoft.demo.service.RoomService;
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

@Controller
public class RoomController extends BaseController{
    @Autowired
    private RoomService roomService;

    @GetMapping("roomAdd")
    public String roomAdd(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "room/roomAdd";
    }

    @PostMapping("roomAdd")
    public String roomAdd(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);

        return roomService.roomAdd(map, session);
    }

    @GetMapping("roomList")
    public String roomList(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        roomService.roomList(map, session);

        return session.getAttribute("user") == null ? "redirect:/index" : "room/roomList";
    }

    @PostMapping("roomList")
    public String roomList1(HttpServletRequest request, HttpSession session) {
//        Map<String, Object> map = getParamMap(request);
//        roomService.roomList(map, session);

        return "redirect:/roomList";
    }

    @GetMapping("roomSearchList")
    public String roomSearchList(HttpSession session) {
        return session.getAttribute("user") == null ? "redirect:/index" : "room/roomSearchList";
    }

    @PostMapping("roomSearchList")
    public String roomSearchList(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        roomService.roomSearchList(map, session);

        return "redirect:/roomSearchList";
    }

    @GetMapping("roomUpdate")
    public String roomUpdate(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);
        session.setAttribute("Id", map.get("id"));

        return session.getAttribute("user") == null ? "redirect:/index" : "room/roomUpdate";
    }

    @PostMapping("roomUpdate")
    public String roomUpdate1(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = getParamMap(request);

        return roomService.roomUpdate(map, session);
    }

    @PostMapping("roomDelete")
    public String roomDelete(@RequestParam("checkone") String ids) {
        int count = roomService.deleteRoomByIds(getDeleteData(ids));

        return "redirect:/queryRoomList?pageIndex=1&pageSize=3";
    }

    @GetMapping("queryRoomList")
    public ModelAndView queryRoomList(HttpServletRequest request, HttpSession session) {
        Map<String, Object> dataMap = getParamMap(request);
        //System.out.println(dataMap.toString());
        dataMap = getPageBean(dataMap, roomService.selectRoomManageCount(dataMap));
        List<Map<String, Object>> maps = roomService.queryRoomList(dataMap);
        session.setAttribute("queryList", maps);
        dataMap.put("list", maps);
        return session.getAttribute("user") == null ? new ModelAndView("index", dataMap) : new ModelAndView("room/roomList", dataMap);
    }
}
