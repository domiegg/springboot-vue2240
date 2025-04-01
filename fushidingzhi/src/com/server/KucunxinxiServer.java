package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Kucunxinxi;

public interface KucunxinxiServer {

  public int add(Kucunxinxi po);

  public int update(Kucunxinxi po);
  
  
  
  public int delete(int id);

  public List<Kucunxinxi> getAll(Map<String,Object> map);
  public List<Kucunxinxi> getsykucunxinxi1(Map<String,Object> map);
  public List<Kucunxinxi> getsykucunxinxi2(Map<String,Object> map);
  public List<Kucunxinxi> getsykucunxinxi3(Map<String,Object> map);
  public Kucunxinxi quchongKucunxinxi(Map<String, Object> acount);

  public Kucunxinxi getById( int id);

  public List<Kucunxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Kucunxinxi> select(Map<String, Object> map);
}
//	所有List
