package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shejishenhe;

public interface ShejishenheServer {

  public int add(Shejishenhe po);

  public int update(Shejishenhe po);
  
  public int updatelb(Shejishenhe po);
  
  public int delete(int id);

  public List<Shejishenhe> getAll(Map<String,Object> map);
  public List<Shejishenhe> getsyshejishenhe1(Map<String,Object> map);
  public List<Shejishenhe> getsyshejishenhe2(Map<String,Object> map);
  public List<Shejishenhe> getsyshejishenhe3(Map<String,Object> map);
  public Shejishenhe quchongShejishenhe(Map<String, Object> acount);

  public Shejishenhe getById( int id);

  public List<Shejishenhe> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shejishenhe> select(Map<String, Object> map);
}
//	所有List
