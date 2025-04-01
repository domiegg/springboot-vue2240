package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Fankuixinxi;

public interface FankuixinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fankuixinxi record);

    int insertSelective(Fankuixinxi record);

    Fankuixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fankuixinxi record);
	int updateByPrimaryKeySelectivelb(Fankuixinxi record);
    int updateByPrimaryKey(Fankuixinxi record);
	public Fankuixinxi quchongFankuixinxi(Map<String, Object> faburen);
	public List<Fankuixinxi> getAll(Map<String, Object> map);
	public List<Fankuixinxi> getsyfankuixinxi1(Map<String, Object> map);
	public List<Fankuixinxi> getsyfankuixinxi3(Map<String, Object> map);
	public List<Fankuixinxi> getsyfankuixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Fankuixinxi> getByPage(Map<String, Object> map);
	public List<Fankuixinxi> select(Map<String, Object> map);
//	所有List
}

