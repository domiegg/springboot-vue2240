package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Kefuxinxi;

public interface KefuxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kefuxinxi record);

    int insertSelective(Kefuxinxi record);

    Kefuxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kefuxinxi record);
	
    int updateByPrimaryKey(Kefuxinxi record);
	public Kefuxinxi quchongKefuxinxi(Map<String, Object> kefubianhao);
	public List<Kefuxinxi> getAll(Map<String, Object> map);
	public List<Kefuxinxi> getsykefuxinxi1(Map<String, Object> map);
	public List<Kefuxinxi> getsykefuxinxi3(Map<String, Object> map);
	public List<Kefuxinxi> getsykefuxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Kefuxinxi> getByPage(Map<String, Object> map);
	public List<Kefuxinxi> select(Map<String, Object> map);
//	所有List
}

