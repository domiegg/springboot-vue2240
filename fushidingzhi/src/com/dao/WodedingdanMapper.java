package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Wodedingdan;

public interface WodedingdanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wodedingdan record);

    int insertSelective(Wodedingdan record);

    Wodedingdan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wodedingdan record);
	
    int updateByPrimaryKey(Wodedingdan record);
	public Wodedingdan quchongWodedingdan(Map<String, Object> goumairen);
	public List<Wodedingdan> getAll(Map<String, Object> map);
	public List<Wodedingdan> getsywodedingdan1(Map<String, Object> map);
	public List<Wodedingdan> getsywodedingdan3(Map<String, Object> map);
	public List<Wodedingdan> getsywodedingdan2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Wodedingdan> getByPage(Map<String, Object> map);
	public List<Wodedingdan> select(Map<String, Object> map);
//	所有List
}

