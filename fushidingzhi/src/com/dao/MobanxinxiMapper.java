package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Mobanxinxi;

public interface MobanxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mobanxinxi record);

    int insertSelective(Mobanxinxi record);

    Mobanxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mobanxinxi record);
	
    int updateByPrimaryKey(Mobanxinxi record);
	public Mobanxinxi quchongMobanxinxi(Map<String, Object> mobanbianhao);
	public List<Mobanxinxi> getAll(Map<String, Object> map);
	public List<Mobanxinxi> getsymobanxinxi1(Map<String, Object> map);
	public List<Mobanxinxi> getsymobanxinxi3(Map<String, Object> map);
	public List<Mobanxinxi> getsymobanxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Mobanxinxi> getByPage(Map<String, Object> map);
	public List<Mobanxinxi> select(Map<String, Object> map);
//	所有List
}

