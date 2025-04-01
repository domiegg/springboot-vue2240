package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CaiwuguanliMapper;
import com.entity.Caiwuguanli;
import com.server.CaiwuguanliServer;
@Service
public class CaiwuguanliServerImpi implements CaiwuguanliServer {
   @Resource
   private CaiwuguanliMapper gdao;
	@Override
	public int add(Caiwuguanli po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Caiwuguanli po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Caiwuguanli> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Caiwuguanli> getsycaiwuguanli1(Map<String, Object> map) {
		return gdao.getsycaiwuguanli1(map);
	}
	public List<Caiwuguanli> getsycaiwuguanli2(Map<String, Object> map) {
		return gdao.getsycaiwuguanli2(map);
	}
	public List<Caiwuguanli> getsycaiwuguanli3(Map<String, Object> map) {
		return gdao.getsycaiwuguanli3(map);
	}
	
	@Override
	public Caiwuguanli quchongCaiwuguanli(Map<String, Object> account) {
		return gdao.quchongCaiwuguanli(account);
	}

	@Override
	public List<Caiwuguanli> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Caiwuguanli> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Caiwuguanli getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

