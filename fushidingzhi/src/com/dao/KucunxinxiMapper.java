package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Kucunxinxi;

public interface KucunxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kucunxinxi record);

    int insertSelective(Kucunxinxi record);

    Kucunxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kucunxinxi record);
	
    int updateByPrimaryKey(Kucunxinxi record);
	public Kucunxinxi quchongKucunxinxi(Map<String, Object> xiugairen);
	public List<Kucunxinxi> getAll(Map<String, Object> map);
	public List<Kucunxinxi> getsykucunxinxi1(Map<String, Object> map);
	public List<Kucunxinxi> getsykucunxinxi3(Map<String, Object> map);
	public List<Kucunxinxi> getsykucunxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Kucunxinxi> getByPage(Map<String, Object> map);
	public List<Kucunxinxi> select(Map<String, Object> map);
//	所有List
}

