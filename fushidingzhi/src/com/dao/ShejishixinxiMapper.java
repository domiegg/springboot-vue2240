package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shejishixinxi;

public interface ShejishixinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shejishixinxi record);

    int insertSelective(Shejishixinxi record);

    Shejishixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shejishixinxi record);
	
    int updateByPrimaryKey(Shejishixinxi record);
	public Shejishixinxi quchongShejishixinxi(Map<String, Object> yonghuming);
	public List<Shejishixinxi> getAll(Map<String, Object> map);
	public List<Shejishixinxi> getsyshejishixinxi1(Map<String, Object> map);
	public List<Shejishixinxi> getsyshejishixinxi3(Map<String, Object> map);
	public List<Shejishixinxi> getsyshejishixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shejishixinxi> getByPage(Map<String, Object> map);
	public List<Shejishixinxi> select(Map<String, Object> map);
//	所有List
}

