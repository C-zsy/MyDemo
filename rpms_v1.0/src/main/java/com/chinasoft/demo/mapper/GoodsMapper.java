package com.chinasoft.demo.mapper;

import com.chinasoft.demo.pojo.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodsMapper {
    public List<Goods> selectGoods();

    public int updateGoods(String materialName,int materialCount,float materialPrice,String materialDate,String materialOutDate,int materialId);

    public int insertGoods(Goods goods);

    public int deleteGoodsByIds(List<Integer> list);

    public List<Map<String,Object>> searchList(Map<String,Object> map);

    public List<Map<String,Object>> queryGoodsList(Map<String, Object> map);

    public int selectManageCount(Map<String, Object> map);

}
