package com.chinasoft.demo.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoomMapper {
    public void roomAdd(Map<String, Object> map);

    public List<Map<String, Object>> roomList(Map<String, Object> map);

    public List<Map<String, Object>> roomSearchList(Map<String, Object> map);

    public void roomUpdate(Map<String, Object> map);

    public int deleteRoomByIds(List<Integer> list);

    public List<Map<String, Object>> queryRoomList(Map<String, Object> map);

    public int selectRoomManageCount(Map<String, Object> map);
}
