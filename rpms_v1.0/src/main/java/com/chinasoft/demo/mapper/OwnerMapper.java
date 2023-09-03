package com.chinasoft.demo.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OwnerMapper {

    public int ownerAdd(Map<String, Object> map);

    public List<Map<String, Object>> ownerList();

    public Integer ownerUpdate(Map<String, Object> map);

    public List<Map<String, Object>> ownerSearchList(Map<String,Object> map);

    public int ownerDelete(List<Integer> ids);

    public List<Map<String,Object>> queryOwnerList(Map<String, Object> map);

    public int selectManageCount(Map<String, Object> map);

    public List<Map<String, Object>> searchList(Map<String, Object> map);

}
