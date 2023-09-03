package com.chinasoft.demo.service;

import com.chinasoft.demo.mapper.GoodsMapper;
import com.chinasoft.demo.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> selectGoods(){
        return goodsMapper.selectGoods();
    }
    public int updateGoods(String materialName,int materialCount,float materialPrice,String materialDate,String materialOutDate,int materialId){
        return goodsMapper.updateGoods(materialName,materialCount,materialPrice,materialDate,materialOutDate,materialId);
    }

    public int insertGoods(Goods goods){
        return goodsMapper.insertGoods(goods);
    }

    public int deleteGoodsByIds(List<Integer> list){
        return goodsMapper.deleteGoodsByIds(list);
    }

    public List<Map<String,Object>> searchList(Map<String,Object> map){
        return goodsMapper.searchList(map);
    }

    public int selectManageCount(Map<String, Object> map){
         return goodsMapper.selectManageCount(map);
    }

    public List<Map<String,Object>> queryGoodsList(Map<String, Object> map){
        return goodsMapper.queryGoodsList(map);
    }
}
