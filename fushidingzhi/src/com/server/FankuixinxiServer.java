package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Fankuixinxi;

public interface FankuixinxiServer {

  public int add(Fankuixinxi po);

  public int update(Fankuixinxi po);
  
  public int updatelb(Fankuixinxi po);
  
  public int delete(int id);

  public List<Fankuixinxi> getAll(Map<String,Object> map);
  public List<Fankuixinxi> getsyfankuixinxi1(Map<String,Object> map);
  public List<Fankuixinxi> getsyfankuixinxi2(Map<String,Object> map);
  public List<Fankuixinxi> getsyfankuixinxi3(Map<String,Object> map);
  public Fankuixinxi quchongFankuixinxi(Map<String, Object> acount);

  public Fankuixinxi getById( int id);

  public List<Fankuixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Fankuixinxi> select(Map<String, Object> map);
}
//	所有List
