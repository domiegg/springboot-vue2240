package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Caiwuguanli;

public interface CaiwuguanliServer {

  public int add(Caiwuguanli po);

  public int update(Caiwuguanli po);
  
  
  
  public int delete(int id);

  public List<Caiwuguanli> getAll(Map<String,Object> map);
  public List<Caiwuguanli> getsycaiwuguanli1(Map<String,Object> map);
  public List<Caiwuguanli> getsycaiwuguanli2(Map<String,Object> map);
  public List<Caiwuguanli> getsycaiwuguanli3(Map<String,Object> map);
  public Caiwuguanli quchongCaiwuguanli(Map<String, Object> acount);

  public Caiwuguanli getById( int id);

  public List<Caiwuguanli> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Caiwuguanli> select(Map<String, Object> map);
}
//	所有List
