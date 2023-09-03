package com.chinasoft.demo.mapper;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper {
    public Map<String,Object> login(Map<String,Object> map);

    public int register(Map<String, Object> map);
}
