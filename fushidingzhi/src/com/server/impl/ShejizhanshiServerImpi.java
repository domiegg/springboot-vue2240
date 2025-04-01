package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShejizhanshiMapper;
import com.entity.Shejizhanshi;
import com.server.ShejizhanshiServer;
@Service
public class ShejizhanshiServerImpi implements ShejizhanshiServer {
   @Resource
   private ShejizhanshiMapper gdao;
	@Override
	public int add(Shejizhanshi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shejizhanshi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shejizhanshi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shejizhanshi> getsyshejizhanshi1(Map<String, Object> map) {
		return gdao.getsyshejizhanshi1(map);
	}
	public List<Shejizhanshi> getsyshejizhanshi2(Map<String, Object> map) {
		return gdao.getsyshejizhanshi2(map);
	}
	public List<Shejizhanshi> getsyshejizhanshi3(Map<String, Object> map) {
		return gdao.getsyshejizhanshi3(map);
	}
	
	@Override
	public Shejizhanshi quchongShejizhanshi(Map<String, Object> account) {
		return gdao.quchongShejizhanshi(account);
	}

	@Override
	public List<Shejizhanshi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shejizhanshi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shejizhanshi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

