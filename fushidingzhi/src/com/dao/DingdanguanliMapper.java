package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Dingdanguanli;

public interface DingdanguanliMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dingdanguanli record);

    int insertSelective(Dingdanguanli record);

    Dingdanguanli selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dingdanguanli record);
	
    int updateByPrimaryKey(Dingdanguanli record);
	public Dingdanguanli quchongDingdanguanli(Map<String, Object> jiluren);
	public List<Dingdanguanli> getAll(Map<String, Object> map);
	public List<Dingdanguanli> getsydingdanguanli1(Map<String, Object> map);
	public List<Dingdanguanli> getsydingdanguanli3(Map<String, Object> map);
	public List<Dingdanguanli> getsydingdanguanli2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Dingdanguanli> getByPage(Map<String, Object> map);
	public List<Dingdanguanli> select(Map<String, Object> map);
//	所有List
}

