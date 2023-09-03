package com.chinasoft.demo.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PayMapper {

    public int payAdd(Map<String, Object> map);

    public List<Map<String, Object>> payList();

    public Integer payUpdate(Map<String, Object> map);

    public Integer paySend(Map<String, Object> map);

    public List<Map<String, Object>> paySearchList(Map<String,Object> map);

    public int payDelete(List<Integer> ids);

    public List<Map<String,Object>> queryPayList(Map<String, Object> map);

    public int selectManageCount(Map<String, Object> map);

}
