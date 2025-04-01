package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Kucunzhanshi;

public interface KucunzhanshiServer {

  public int add(Kucunzhanshi po);

  public int update(Kucunzhanshi po);
  
  
  
  public int delete(int id);

  public List<Kucunzhanshi> getAll(Map<String,Object> map);
  public List<Kucunzhanshi> getsykucunzhanshi1(Map<String,Object> map);
  public List<Kucunzhanshi> getsykucunzhanshi2(Map<String,Object> map);
  public List<Kucunzhanshi> getsykucunzhanshi3(Map<String,Object> map);
  public Kucunzhanshi quchongKucunzhanshi(Map<String, Object> acount);

  public Kucunzhanshi getById( int id);

  public List<Kucunzhanshi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Kucunzhanshi> select(Map<String, Object> map);
}
//	所有List
