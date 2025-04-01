package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.MobanxinxiMapper;
import com.entity.Mobanxinxi;
import com.server.MobanxinxiServer;
@Service
public class MobanxinxiServerImpi implements MobanxinxiServer {
   @Resource
   private MobanxinxiMapper gdao;
	@Override
	public int add(Mobanxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Mobanxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Mobanxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Mobanxinxi> getsymobanxinxi1(Map<String, Object> map) {
		return gdao.getsymobanxinxi1(map);
	}
	public List<Mobanxinxi> getsymobanxinxi2(Map<String, Object> map) {
		return gdao.getsymobanxinxi2(map);
	}
	public List<Mobanxinxi> getsymobanxinxi3(Map<String, Object> map) {
		return gdao.getsymobanxinxi3(map);
	}
	
	@Override
	public Mobanxinxi quchongMobanxinxi(Map<String, Object> account) {
		return gdao.quchongMobanxinxi(account);
	}

	@Override
	public List<Mobanxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Mobanxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Mobanxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

