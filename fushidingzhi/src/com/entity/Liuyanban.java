package com.entity;

public class Liuyanban {
    private Integer id;
	private String biaoti;	private String neirong;	private String fabushijian;	private String faburen;	private String kefuhuifu;	private String issh;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBiaoti() {
        return biaoti;
    }
    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti == null ? null : biaoti.trim();
    }	public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
        this.neirong = neirong == null ? null : neirong.trim();
    }	public String getFabushijian() {
        return fabushijian;
    }
    public void setFabushijian(String fabushijian) {
        this.fabushijian = fabushijian == null ? null : fabushijian.trim();
    }	public String getFaburen() {
        return faburen;
    }
    public void setFaburen(String faburen) {
        this.faburen = faburen == null ? null : faburen.trim();
    }	public String getKefuhuifu() {
        return kefuhuifu;
    }
    public void setKefuhuifu(String kefuhuifu) {
        this.kefuhuifu = kefuhuifu == null ? null : kefuhuifu.trim();
    }	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
