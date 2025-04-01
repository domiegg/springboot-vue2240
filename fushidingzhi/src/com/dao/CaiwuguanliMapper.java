package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Caiwuguanli;

public interface CaiwuguanliMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Caiwuguanli record);

    int insertSelective(Caiwuguanli record);

    Caiwuguanli selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Caiwuguanli record);
	
    int updateByPrimaryKey(Caiwuguanli record);
	public Caiwuguanli quchongCaiwuguanli(Map<String, Object> jiluru);
	public List<Caiwuguanli> getAll(Map<String, Object> map);
	public List<Caiwuguanli> getsycaiwuguanli1(Map<String, Object> map);
	public List<Caiwuguanli> getsycaiwuguanli3(Map<String, Object> map);
	public List<Caiwuguanli> getsycaiwuguanli2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Caiwuguanli> getByPage(Map<String, Object> map);
	public List<Caiwuguanli> select(Map<String, Object> map);
//	所有List
}

