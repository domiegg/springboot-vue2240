package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shejishenhe;

public interface ShejishenheMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shejishenhe record);

    int insertSelective(Shejishenhe record);

    Shejishenhe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shejishenhe record);
	int updateByPrimaryKeySelectivelb(Shejishenhe record);
    int updateByPrimaryKey(Shejishenhe record);
	public Shejishenhe quchongShejishenhe(Map<String, Object> shejiren);
	public List<Shejishenhe> getAll(Map<String, Object> map);
	public List<Shejishenhe> getsyshejishenhe1(Map<String, Object> map);
	public List<Shejishenhe> getsyshejishenhe3(Map<String, Object> map);
	public List<Shejishenhe> getsyshejishenhe2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shejishenhe> getByPage(Map<String, Object> map);
	public List<Shejishenhe> select(Map<String, Object> map);
//	所有List
}

