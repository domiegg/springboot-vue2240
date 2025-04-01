package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shejihuihua;

public interface ShejihuihuaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shejihuihua record);

    int insertSelective(Shejihuihua record);

    Shejihuihua selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shejihuihua record);
	int updateByPrimaryKeySelectivelb(Shejihuihua record);
    int updateByPrimaryKey(Shejihuihua record);
	public Shejihuihua quchongShejihuihua(Map<String, Object> shejishi);
	public List<Shejihuihua> getAll(Map<String, Object> map);
	public List<Shejihuihua> getsyshejihuihua1(Map<String, Object> map);
	public List<Shejihuihua> getsyshejihuihua3(Map<String, Object> map);
	public List<Shejihuihua> getsyshejihuihua2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shejihuihua> getByPage(Map<String, Object> map);
	public List<Shejihuihua> select(Map<String, Object> map);
//	所有List
}

