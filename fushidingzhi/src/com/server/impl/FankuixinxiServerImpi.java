package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.FankuixinxiMapper;
import com.entity.Fankuixinxi;
import com.server.FankuixinxiServer;
@Service
public class FankuixinxiServerImpi implements FankuixinxiServer {
   @Resource
   private FankuixinxiMapper gdao;
	@Override
	public int add(Fankuixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Fankuixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	@Override
	public int updatelb(Fankuixinxi po) {
		return gdao.updateByPrimaryKeySelectivelb(po);
	}
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Fankuixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Fankuixinxi> getsyfankuixinxi1(Map<String, Object> map) {
		return gdao.getsyfankuixinxi1(map);
	}
	public List<Fankuixinxi> getsyfankuixinxi2(Map<String, Object> map) {
		return gdao.getsyfankuixinxi2(map);
	}
	public List<Fankuixinxi> getsyfankuixinxi3(Map<String, Object> map) {
		return gdao.getsyfankuixinxi3(map);
	}
	
	@Override
	public Fankuixinxi quchongFankuixinxi(Map<String, Object> account) {
		return gdao.quchongFankuixinxi(account);
	}

	@Override
	public List<Fankuixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Fankuixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Fankuixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

