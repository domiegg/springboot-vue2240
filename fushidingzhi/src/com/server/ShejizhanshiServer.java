package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shejizhanshi;

public interface ShejizhanshiServer {

  public int add(Shejizhanshi po);

  public int update(Shejizhanshi po);
  
  
  
  public int delete(int id);

  public List<Shejizhanshi> getAll(Map<String,Object> map);
  public List<Shejizhanshi> getsyshejizhanshi1(Map<String,Object> map);
  public List<Shejizhanshi> getsyshejizhanshi2(Map<String,Object> map);
  public List<Shejizhanshi> getsyshejizhanshi3(Map<String,Object> map);
  public Shejizhanshi quchongShejizhanshi(Map<String, Object> acount);

  public Shejizhanshi getById( int id);

  public List<Shejizhanshi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shejizhanshi> select(Map<String, Object> map);
}
//	所有List
