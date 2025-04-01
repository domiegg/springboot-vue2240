package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shejihuihua;

public interface ShejihuihuaServer {

  public int add(Shejihuihua po);

  public int update(Shejihuihua po);
  
  public int updatelb(Shejihuihua po);
  
  public int delete(int id);

  public List<Shejihuihua> getAll(Map<String,Object> map);
  public List<Shejihuihua> getsyshejihuihua1(Map<String,Object> map);
  public List<Shejihuihua> getsyshejihuihua2(Map<String,Object> map);
  public List<Shejihuihua> getsyshejihuihua3(Map<String,Object> map);
  public Shejihuihua quchongShejihuihua(Map<String, Object> acount);

  public Shejihuihua getById( int id);

  public List<Shejihuihua> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shejihuihua> select(Map<String, Object> map);
}
//	所有List
