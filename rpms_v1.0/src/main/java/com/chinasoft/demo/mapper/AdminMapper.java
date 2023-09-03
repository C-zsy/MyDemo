package com.chinasoft.demo.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminMapper {
    public int roleAdd(Map<String, Object> map);

    public int roleDelete(List<Integer> list);

    public List<Map<String, Object>> roleList(Map<String, Object> map);

    public int roleUpdate(Map<String, Object> map);

    public List<Map<String, Object>> userList(Map<String, Object> map);

    public int userDelete(List<Integer> list);

    public int userUpdate(Map<String, Object> map);

    public List<Map<String, Object>> powerDetails(Map<String, Object> map);

    public List<Map<String, Object>> powerList(Map<String, Object> map);

    public Map<String, Object> powerUpdate(Map<String, Object> map);

    public int deleteRolePowerByIds(List<Integer> list);

    public int rolePowerAdd(Map<String, Object> map);

    public List<Map<String, Object>> rolePowerList(Map<String, Object> map);

    public int rolePowerUpdate(Map<String, Object> map);

    public int rolePowerDelete(List<Integer> list);

    public List<Map<String, Object>> backup(Map<String, Object> map);
}
