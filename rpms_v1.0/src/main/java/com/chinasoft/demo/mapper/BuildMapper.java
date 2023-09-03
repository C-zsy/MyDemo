package com.chinasoft.demo.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BuildMapper {
    public int buildAdd(Map<String, Object> map);

    public List<Map<String, Object>> buildList(Map<String, Object> map);

    public List<Map<String, Object>> buildSearchList(Map<String, Object> map);

    public void buildUpdate(Map<String, Object> map);

    public int deleteBuildByIds(List<Integer> list);

    public List<Map<String, Object>> queryBuildList(Map<String, Object> map);

    public int selectBuildManageCount(Map<String, Object> map);
}
