package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.WodedingdanMapper;
import com.entity.Wodedingdan;
import com.server.WodedingdanServer;
@Service
public class WodedingdanServerImpi implements WodedingdanServer {
   @Resource
   private WodedingdanMapper gdao;
	@Override
	public int add(Wodedingdan po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Wodedingdan po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Wodedingdan> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Wodedingdan> getsywodedingdan1(Map<String, Object> map) {
		return gdao.getsywodedingdan1(map);
	}
	public List<Wodedingdan> getsywodedingdan2(Map<String, Object> map) {
		return gdao.getsywodedingdan2(map);
	}
	public List<Wodedingdan> getsywodedingdan3(Map<String, Object> map) {
		return gdao.getsywodedingdan3(map);
	}
	
	@Override
	public Wodedingdan quchongWodedingdan(Map<String, Object> account) {
		return gdao.quchongWodedingdan(account);
	}

	@Override
	public List<Wodedingdan> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Wodedingdan> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Wodedingdan getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

