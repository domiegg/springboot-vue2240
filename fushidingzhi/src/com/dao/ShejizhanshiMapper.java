package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shejizhanshi;

public interface ShejizhanshiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shejizhanshi record);

    int insertSelective(Shejizhanshi record);

    Shejizhanshi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shejizhanshi record);
	
    int updateByPrimaryKey(Shejizhanshi record);
	public Shejizhanshi quchongShejizhanshi(Map<String, Object> shejibianhao);
	public List<Shejizhanshi> getAll(Map<String, Object> map);
	public List<Shejizhanshi> getsyshejizhanshi1(Map<String, Object> map);
	public List<Shejizhanshi> getsyshejizhanshi3(Map<String, Object> map);
	public List<Shejizhanshi> getsyshejizhanshi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shejizhanshi> getByPage(Map<String, Object> map);
	public List<Shejizhanshi> select(Map<String, Object> map);
//	所有List
}

