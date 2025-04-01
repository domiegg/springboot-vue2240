package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.KucunzhanshiMapper;
import com.entity.Kucunzhanshi;
import com.server.KucunzhanshiServer;
@Service
public class KucunzhanshiServerImpi implements KucunzhanshiServer {
   @Resource
   private KucunzhanshiMapper gdao;
	@Override
	public int add(Kucunzhanshi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Kucunzhanshi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Kucunzhanshi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Kucunzhanshi> getsykucunzhanshi1(Map<String, Object> map) {
		return gdao.getsykucunzhanshi1(map);
	}
	public List<Kucunzhanshi> getsykucunzhanshi2(Map<String, Object> map) {
		return gdao.getsykucunzhanshi2(map);
	}
	public List<Kucunzhanshi> getsykucunzhanshi3(Map<String, Object> map) {
		return gdao.getsykucunzhanshi3(map);
	}
	
	@Override
	public Kucunzhanshi quchongKucunzhanshi(Map<String, Object> account) {
		return gdao.quchongKucunzhanshi(account);
	}

	@Override
	public List<Kucunzhanshi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Kucunzhanshi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Kucunzhanshi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

