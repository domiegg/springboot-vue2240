package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Mobanxinxi;

public interface MobanxinxiServer {

  public int add(Mobanxinxi po);

  public int update(Mobanxinxi po);
  
  
  
  public int delete(int id);

  public List<Mobanxinxi> getAll(Map<String,Object> map);
  public List<Mobanxinxi> getsymobanxinxi1(Map<String,Object> map);
  public List<Mobanxinxi> getsymobanxinxi2(Map<String,Object> map);
  public List<Mobanxinxi> getsymobanxinxi3(Map<String,Object> map);
  public Mobanxinxi quchongMobanxinxi(Map<String, Object> acount);

  public Mobanxinxi getById( int id);

  public List<Mobanxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Mobanxinxi> select(Map<String, Object> map);
}
//	所有List
