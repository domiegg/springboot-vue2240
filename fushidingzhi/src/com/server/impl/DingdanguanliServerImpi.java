package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DingdanguanliMapper;
import com.entity.Dingdanguanli;
import com.server.DingdanguanliServer;
@Service
public class DingdanguanliServerImpi implements DingdanguanliServer {
   @Resource
   private DingdanguanliMapper gdao;
	@Override
	public int add(Dingdanguanli po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Dingdanguanli po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Dingdanguanli> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Dingdanguanli> getsydingdanguanli1(Map<String, Object> map) {
		return gdao.getsydingdanguanli1(map);
	}
	public List<Dingdanguanli> getsydingdanguanli2(Map<String, Object> map) {
		return gdao.getsydingdanguanli2(map);
	}
	public List<Dingdanguanli> getsydingdanguanli3(Map<String, Object> map) {
		return gdao.getsydingdanguanli3(map);
	}
	
	@Override
	public Dingdanguanli quchongDingdanguanli(Map<String, Object> account) {
		return gdao.quchongDingdanguanli(account);
	}

	@Override
	public List<Dingdanguanli> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Dingdanguanli> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Dingdanguanli getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

