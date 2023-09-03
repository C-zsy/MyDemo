package com.chinasoft.demo.mapper;

import com.chinasoft.demo.pojo.Material;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MaterialMapper {
    public List<Material> SelectMaterial();

   // public int deleteTypeById(List<Integer> list);

    public int typeUpdate(String typeName,int typeId);

    public int insertType(Material material);
    public int deleteTypeByIds(List<Integer> list);

    public List<Map<String,Object>> searchList(Map<String,Object> map);

    public List<Map<String,Object>> queryTypeList(Map<String, Object> map);

    public int selectManageCount(Map<String, Object> map);
}
