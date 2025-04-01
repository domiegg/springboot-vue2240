package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.KefuxinxiMapper;
import com.entity.Kefuxinxi;
import com.server.KefuxinxiServer;
@Service
public class KefuxinxiServerImpi implements KefuxinxiServer {
   @Resource
   private KefuxinxiMapper gdao;
	@Override
	public int add(Kefuxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Kefuxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Kefuxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Kefuxinxi> getsykefuxinxi1(Map<String, Object> map) {
		return gdao.getsykefuxinxi1(map);
	}
	public List<Kefuxinxi> getsykefuxinxi2(Map<String, Object> map) {
		return gdao.getsykefuxinxi2(map);
	}
	public List<Kefuxinxi> getsykefuxinxi3(Map<String, Object> map) {
		return gdao.getsykefuxinxi3(map);
	}
	
	@Override
	public Kefuxinxi quchongKefuxinxi(Map<String, Object> account) {
		return gdao.quchongKefuxinxi(account);
	}

	@Override
	public List<Kefuxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Kefuxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Kefuxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

