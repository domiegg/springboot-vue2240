package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Dingdanguanli;

public interface DingdanguanliServer {

  public int add(Dingdanguanli po);

  public int update(Dingdanguanli po);
  
  
  
  public int delete(int id);

  public List<Dingdanguanli> getAll(Map<String,Object> map);
  public List<Dingdanguanli> getsydingdanguanli1(Map<String,Object> map);
  public List<Dingdanguanli> getsydingdanguanli2(Map<String,Object> map);
  public List<Dingdanguanli> getsydingdanguanli3(Map<String,Object> map);
  public Dingdanguanli quchongDingdanguanli(Map<String, Object> acount);

  public Dingdanguanli getById( int id);

  public List<Dingdanguanli> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Dingdanguanli> select(Map<String, Object> map);
}
//	所有List
