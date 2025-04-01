package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShejihuihuaMapper;
import com.entity.Shejihuihua;
import com.server.ShejihuihuaServer;
@Service
public class ShejihuihuaServerImpi implements ShejihuihuaServer {
   @Resource
   private ShejihuihuaMapper gdao;
	@Override
	public int add(Shejihuihua po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shejihuihua po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Shejihuihua po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shejihuihua> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shejihuihua> getsyshejihuihua1(Map<String, Object> map) {
		return gdao.getsyshejihuihua1(map);
	}
	public List<Shejihuihua> getsyshejihuihua2(Map<String, Object> map) {
		return gdao.getsyshejihuihua2(map);
	}
	public List<Shejihuihua> getsyshejihuihua3(Map<String, Object> map) {
		return gdao.getsyshejihuihua3(map);
	}
	
	@Override
	public Shejihuihua quchongShejihuihua(Map<String, Object> account) {
		return gdao.quchongShejihuihua(account);
	}

	@Override
	public List<Shejihuihua> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shejihuihua> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shejihuihua getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

