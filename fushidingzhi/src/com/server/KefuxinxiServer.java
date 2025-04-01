package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Kefuxinxi;

public interface KefuxinxiServer {

  public int add(Kefuxinxi po);

  public int update(Kefuxinxi po);
  
  
  
  public int delete(int id);

  public List<Kefuxinxi> getAll(Map<String,Object> map);
  public List<Kefuxinxi> getsykefuxinxi1(Map<String,Object> map);
  public List<Kefuxinxi> getsykefuxinxi2(Map<String,Object> map);
  public List<Kefuxinxi> getsykefuxinxi3(Map<String,Object> map);
  public Kefuxinxi quchongKefuxinxi(Map<String, Object> acount);

  public Kefuxinxi getById( int id);

  public List<Kefuxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Kefuxinxi> select(Map<String, Object> map);
}
//	所有List
