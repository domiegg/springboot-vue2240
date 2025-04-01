package com.entity;

public class Mobanxinxi {
    private Integer id;
	private String mobanbianhao;	private String mobanmingcheng;	private String mobanleixing;	private String mobantupian;	private String mobanshuoming;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getMobanbianhao() {
        return mobanbianhao;
    }
    public void setMobanbianhao(String mobanbianhao) {
        this.mobanbianhao = mobanbianhao == null ? null : mobanbianhao.trim();
    }	public String getMobanmingcheng() {
        return mobanmingcheng;
    }
    public void setMobanmingcheng(String mobanmingcheng) {
        this.mobanmingcheng = mobanmingcheng == null ? null : mobanmingcheng.trim();
    }	public String getMobanleixing() {
        return mobanleixing;
    }
    public void setMobanleixing(String mobanleixing) {
        this.mobanleixing = mobanleixing == null ? null : mobanleixing.trim();
    }	public String getMobantupian() {
        return mobantupian;
    }
    public void setMobantupian(String mobantupian) {
        this.mobantupian = mobantupian == null ? null : mobantupian.trim();
    }	public String getMobanshuoming() {
        return mobanshuoming;
    }
    public void setMobanshuoming(String mobanshuoming) {
        this.mobanshuoming = mobanshuoming == null ? null : mobanshuoming.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
