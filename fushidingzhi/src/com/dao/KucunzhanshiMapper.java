package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Kucunzhanshi;

public interface KucunzhanshiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kucunzhanshi record);

    int insertSelective(Kucunzhanshi record);

    Kucunzhanshi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kucunzhanshi record);
	
    int updateByPrimaryKey(Kucunzhanshi record);
	public Kucunzhanshi quchongKucunzhanshi(Map<String, Object> xiugairen);
	public List<Kucunzhanshi> getAll(Map<String, Object> map);
	public List<Kucunzhanshi> getsykucunzhanshi1(Map<String, Object> map);
	public List<Kucunzhanshi> getsykucunzhanshi3(Map<String, Object> map);
	public List<Kucunzhanshi> getsykucunzhanshi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Kucunzhanshi> getByPage(Map<String, Object> map);
	public List<Kucunzhanshi> select(Map<String, Object> map);
//	所有List
}

