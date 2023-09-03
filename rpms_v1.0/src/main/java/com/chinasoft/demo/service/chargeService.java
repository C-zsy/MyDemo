package com.chinasoft.demo.service;

import com.chinasoft.demo.mapper.chargeMapper;
//import com.chinasoft.demo.mapper.UserMapper;
import com.chinasoft.demo.pojo.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
@Service
public class chargeService {

    @Autowired
    private chargeMapper userMapper;

    public List<Map<String,Object>> selectChargeList(){
        return userMapper.selectChargeList();
    }

    public int insertCharge(Map<String,Object> map){

        return userMapper.insertCharge(map);
    }

    public int updateCharge2(Map<String,Object> map){
        return userMapper.updateCharge2(map);
    }

    public int deleteCharge(List<Integer> list){
        return userMapper.deleteCharge(list);
    }

    public List<Map<String,Object>> queryChargeList(Map<String,Object> map){
        return userMapper.queryChargeList(map);
    }

    public int selectChargeManageCount(Map<String,Object> map){
        return userMapper.selectChargeManageCount(map);
    }
}