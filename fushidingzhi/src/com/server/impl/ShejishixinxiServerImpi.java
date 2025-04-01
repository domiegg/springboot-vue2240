package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShejishixinxiMapper;
import com.entity.Shejishixinxi;
import com.server.ShejishixinxiServer;
@Service
public class ShejishixinxiServerImpi implements ShejishixinxiServer {
   @Resource
   private ShejishixinxiMapper gdao;
	@Override
	public int add(Shejishixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shejishixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shejishixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shejishixinxi> getsyshejishixinxi1(Map<String, Object> map) {
		return gdao.getsyshejishixinxi1(map);
	}
	public List<Shejishixinxi> getsyshejishixinxi2(Map<String, Object> map) {
		return gdao.getsyshejishixinxi2(map);
	}
	public List<Shejishixinxi> getsyshejishixinxi3(Map<String, Object> map) {
		return gdao.getsyshejishixinxi3(map);
	}
	
	@Override
	public Shejishixinxi quchongShejishixinxi(Map<String, Object> account) {
		return gdao.quchongShejishixinxi(account);
	}

	@Override
	public List<Shejishixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shejishixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shejishixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

