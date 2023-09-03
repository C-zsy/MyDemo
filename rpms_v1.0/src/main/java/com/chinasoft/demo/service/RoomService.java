package com.chinasoft.demo.service;

import com.chinasoft.demo.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
public class RoomService {
    @Autowired
    private RoomMapper roomMapper;

    public String roomAdd(Map<String, Object> map, HttpSession session) {
        roomMapper.roomAdd(map);
        session.setAttribute("room", map);

        return "redirect:/queryRoomList?pageIndex=1&pageSize=3";
    }

    public String roomList(Map<String, Object> map, HttpSession session) {
        List<Map<String, Object>> list = roomMapper.roomList(map);
        session.setAttribute("roomList", list);

        return "redirect:/roomList";
    }

    public String roomSearchList(Map<String, Object> map, HttpSession session) {
        List<Map<String,Object>> list = roomMapper.roomSearchList(map);
        session.setAttribute("roomSearchList", list);

        return "room/roomList";
    }

    public String roomUpdate(Map<String, Object> map, HttpSession session) {
        roomMapper.roomUpdate(map);
        session.setAttribute("roomUpdate", map);

        return "redirect:/queryRoomList?pageIndex=1&pageSize=3";
    }

    public int deleteRoomByIds(List<Integer> list) {
        return roomMapper.deleteRoomByIds(list);
    }

    public List<Map<String, Object>> queryRoomList(Map<String, Object> map) {
        return roomMapper.queryRoomList(map);
    }

    public int selectRoomManageCount(Map<String, Object> map) {
        return roomMapper.selectRoomManageCount(map);
    }
}
