package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Wodedingdan;

public interface WodedingdanServer {

  public int add(Wodedingdan po);

  public int update(Wodedingdan po);
  
  
  
  public int delete(int id);

  public List<Wodedingdan> getAll(Map<String,Object> map);
  public List<Wodedingdan> getsywodedingdan1(Map<String,Object> map);
  public List<Wodedingdan> getsywodedingdan2(Map<String,Object> map);
  public List<Wodedingdan> getsywodedingdan3(Map<String,Object> map);
  public Wodedingdan quchongWodedingdan(Map<String, Object> acount);

  public Wodedingdan getById( int id);

  public List<Wodedingdan> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Wodedingdan> select(Map<String, Object> map);
}
//	所有List
