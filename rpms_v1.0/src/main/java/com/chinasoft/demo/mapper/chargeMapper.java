package com.chinasoft.demo.mapper;

import com.chinasoft.demo.pojo.Charge;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface chargeMapper {


    public int insertCharge(Map<String,Object> map);

    public List<Map<String,Object>> selectChargeList();

    public int updateCharge2(Map<String,Object> map);

    public int deleteCharge(List<Integer> list);

    public List<Map<String,Object>> queryChargeList(Map<String, Object> map);

    public int selectChargeManageCount(Map<String, Object> map);
}
