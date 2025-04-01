package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shejishixinxi;

public interface ShejishixinxiServer {

  public int add(Shejishixinxi po);

  public int update(Shejishixinxi po);
  
  
  
  public int delete(int id);

  public List<Shejishixinxi> getAll(Map<String,Object> map);
  public List<Shejishixinxi> getsyshejishixinxi1(Map<String,Object> map);
  public List<Shejishixinxi> getsyshejishixinxi2(Map<String,Object> map);
  public List<Shejishixinxi> getsyshejishixinxi3(Map<String,Object> map);
  public Shejishixinxi quchongShejishixinxi(Map<String, Object> acount);

  public Shejishixinxi getById( int id);

  public List<Shejishixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shejishixinxi> select(Map<String, Object> map);
}
//	所有List
