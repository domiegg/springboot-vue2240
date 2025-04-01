package com.entity;

public class Shejizhanshi {
    private Integer id;
	private String shejibianhao;	private String shejimingcheng;	private String mobanleixing;	private String shejihuitu;	private String shejishuoming;	private String shejishi;	private String jiage;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getShejibianhao() {
        return shejibianhao;
    }
    public void setShejibianhao(String shejibianhao) {
        this.shejibianhao = shejibianhao == null ? null : shejibianhao.trim();
    }	public String getShejimingcheng() {
        return shejimingcheng;
    }
    public void setShejimingcheng(String shejimingcheng) {
        this.shejimingcheng = shejimingcheng == null ? null : shejimingcheng.trim();
    }	public String getMobanleixing() {
        return mobanleixing;
    }
    public void setMobanleixing(String mobanleixing) {
        this.mobanleixing = mobanleixing == null ? null : mobanleixing.trim();
    }	public String getShejihuitu() {
        return shejihuitu;
    }
    public void setShejihuitu(String shejihuitu) {
        this.shejihuitu = shejihuitu == null ? null : shejihuitu.trim();
    }	public String getShejishuoming() {
        return shejishuoming;
    }
    public void setShejishuoming(String shejishuoming) {
        this.shejishuoming = shejishuoming == null ? null : shejishuoming.trim();
    }	public String getShejishi() {
        return shejishi;
    }
    public void setShejishi(String shejishi) {
        this.shejishi = shejishi == null ? null : shejishi.trim();
    }	public String getJiage() {
        return jiage;
    }
    public void setJiage(String jiage) {
        this.jiage = jiage == null ? null : jiage.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
