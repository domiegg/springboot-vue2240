package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.KucunxinxiMapper;
import com.entity.Kucunxinxi;
import com.server.KucunxinxiServer;
@Service
public class KucunxinxiServerImpi implements KucunxinxiServer {
   @Resource
   private KucunxinxiMapper gdao;
	@Override
	public int add(Kucunxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Kucunxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Kucunxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Kucunxinxi> getsykucunxinxi1(Map<String, Object> map) {
		return gdao.getsykucunxinxi1(map);
	}
	public List<Kucunxinxi> getsykucunxinxi2(Map<String, Object> map) {
		return gdao.getsykucunxinxi2(map);
	}
	public List<Kucunxinxi> getsykucunxinxi3(Map<String, Object> map) {
		return gdao.getsykucunxinxi3(map);
	}
	
	@Override
	public Kucunxinxi quchongKucunxinxi(Map<String, Object> account) {
		return gdao.quchongKucunxinxi(account);
	}

	@Override
	public List<Kucunxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Kucunxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Kucunxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

