package com.chinasoft.demo.service;

import com.chinasoft.demo.mapper.MaterialMapper;
import com.chinasoft.demo.pojo.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    public List<Material> SelectMaterial(){
        return materialMapper.SelectMaterial();
    }

    public String  insertType(Material material){
        materialMapper.insertType(material);
        return "redirect:queryTypeList?pageIndex=1&pageSize=3";
    }
   /* public List<Map<String,Object>>SelectMaterial(){
        return materialMapper.SelectMaterial();
    }
*/
   /* public int insertType(Map<String,Object> map){
        return materialMapper.insertType(map);
    }
*/
    /*public int deleteUserByIds(List<Integer> list){
        return materialMapper.deleteTypeById(list);

    }*/
    public int typeUpdate(String typeName,int typeId){

        return materialMapper.typeUpdate(typeName,typeId);
    }

    public int deleteTypeByIds(List<Integer> list){
        return materialMapper.deleteTypeByIds(list);
    }

    public List<Map<String,Object>> searchList(Map<String,Object> map){
        return materialMapper.searchList(map);
    }

    public List<Map<String,Object>> queryTypeList(Map<String, Object> map){
        return materialMapper.queryTypeList(map);
    }

    public int selectManageCount(Map<String, Object> map){
        return materialMapper.selectManageCount(map);
    }
}
