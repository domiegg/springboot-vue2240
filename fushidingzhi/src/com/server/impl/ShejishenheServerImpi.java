package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShejishenheMapper;
import com.entity.Shejishenhe;
import com.server.ShejishenheServer;
@Service
public class ShejishenheServerImpi implements ShejishenheServer {
   @Resource
   private ShejishenheMapper gdao;
	@Override
	public int add(Shejishenhe po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shejishenhe po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Shejishenhe po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shejishenhe> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shejishenhe> getsyshejishenhe1(Map<String, Object> map) {
		return gdao.getsyshejishenhe1(map);
	}
	public List<Shejishenhe> getsyshejishenhe2(Map<String, Object> map) {
		return gdao.getsyshejishenhe2(map);
	}
	public List<Shejishenhe> getsyshejishenhe3(Map<String, Object> map) {
		return gdao.getsyshejishenhe3(map);
	}
	
	@Override
	public Shejishenhe quchongShejishenhe(Map<String, Object> account) {
		return gdao.quchongShejishenhe(account);
	}

	@Override
	public List<Shejishenhe> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shejishenhe> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shejishenhe getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

