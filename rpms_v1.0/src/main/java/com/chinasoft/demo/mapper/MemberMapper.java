package com.chinasoft.demo.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MemberMapper {

    public int memberAdd(Map<String, Object> map);

    public List<Map<String, Object>> memberList();

    public Integer memberUpdate(Map<String, Object> map);

    public List<Map<String, Object>> memberSearchList(Map<String,Object> map);

    public int memberDelete(List<Integer> ids);

    public List<Map<String,Object>> querymemberList(Map<String, Object> map);

    public int selectManageCount(Map<String, Object> map);

}
