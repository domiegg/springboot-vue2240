package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Caiwuguanli;
import com.server.CaiwuguanliServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class CaiwuguanliController {
	@Resource
	private CaiwuguanliServer caiwuguanliService;


   
	@RequestMapping("addCaiwuguanli.do")
	public String addCaiwuguanli(HttpServletRequest request,Caiwuguanli caiwuguanli,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		caiwuguanli.setAddtime(time.toString().substring(0, 19));
		caiwuguanliService.add(caiwuguanli);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "caiwuguanliList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:caiwuguanliList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateCaiwuguanli.do")
	public String doUpdateCaiwuguanli(int id,ModelMap map,Caiwuguanli caiwuguanli){
		caiwuguanli=caiwuguanliService.getById(id);
		map.put("caiwuguanli", caiwuguanli);
		return "caiwuguanli_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("caiwuguanliDetail.do")
	public String caiwuguanliDetail(int id,ModelMap map,Caiwuguanli caiwuguanli){
		caiwuguanli=caiwuguanliService.getById(id);
		map.put("caiwuguanli", caiwuguanli);
		return "caiwuguanli_detail";
	}
//	前台详细
	@RequestMapping("cwglDetail.do")
	public String cwglDetail(int id,ModelMap map,Caiwuguanli caiwuguanli){
		caiwuguanli=caiwuguanliService.getById(id);
		map.put("caiwuguanli", caiwuguanli);
		return "caiwuguanlidetail";
	}
//	
	@RequestMapping("updateCaiwuguanli.do")
	public String updateCaiwuguanli(int id,ModelMap map,Caiwuguanli caiwuguanli,HttpServletRequest request,HttpSession session){
		caiwuguanliService.update(caiwuguanli);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:caiwuguanliList.do";
	}

//	分页查询
	@RequestMapping("caiwuguanliList.do")
	public String caiwuguanliList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caiwuguanli caiwuguanli, String caiwubianhao, String biaoti, String yuefen, String dingdanshuliang1,String dingdanshuliang2, String dingdanzongjia1,String dingdanzongjia2, String duizhangzhuangtai, String beizhu, String wenjian, String jilushijian1,String jilushijian2, String jiluru){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(caiwubianhao==null||caiwubianhao.equals("")){pmap.put("caiwubianhao", null);}else{pmap.put("caiwubianhao", caiwubianhao);}		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(yuefen==null||yuefen.equals("")){pmap.put("yuefen", null);}else{pmap.put("yuefen", yuefen);}		if(dingdanshuliang1==null||dingdanshuliang1.equals("")){pmap.put("dingdanshuliang1", null);}else{pmap.put("dingdanshuliang1", dingdanshuliang1);}		if(dingdanshuliang2==null||dingdanshuliang2.equals("")){pmap.put("dingdanshuliang2", null);}else{pmap.put("dingdanshuliang2", dingdanshuliang2);}		if(dingdanzongjia1==null||dingdanzongjia1.equals("")){pmap.put("dingdanzongjia1", null);}else{pmap.put("dingdanzongjia1", dingdanzongjia1);}		if(dingdanzongjia2==null||dingdanzongjia2.equals("")){pmap.put("dingdanzongjia2", null);}else{pmap.put("dingdanzongjia2", dingdanzongjia2);}		if(duizhangzhuangtai==null||duizhangzhuangtai.equals("")){pmap.put("duizhangzhuangtai", null);}else{pmap.put("duizhangzhuangtai", duizhangzhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(jilushijian1==null||jilushijian1.equals("")){pmap.put("jilushijian1", null);}else{pmap.put("jilushijian1", jilushijian1);}		if(jilushijian2==null||jilushijian2.equals("")){pmap.put("jilushijian2", null);}else{pmap.put("jilushijian2", jilushijian2);}		if(jiluru==null||jiluru.equals("")){pmap.put("jiluru", null);}else{pmap.put("jiluru", jiluru);}		
		int total=caiwuguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caiwuguanli> list=caiwuguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caiwuguanli_list";
	}
	
	@RequestMapping("caiwuguanliList2.do")
	public String caiwuguanliList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caiwuguanli caiwuguanli, String caiwubianhao, String biaoti, String yuefen, String dingdanshuliang1,String dingdanshuliang2, String dingdanzongjia1,String dingdanzongjia2, String duizhangzhuangtai, String beizhu, String wenjian, String jilushijian1,String jilushijian2, String jiluru,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("jiluru", (String)request.getSession().getAttribute("username"));
		if(caiwubianhao==null||caiwubianhao.equals("")){pmap.put("caiwubianhao", null);}else{pmap.put("caiwubianhao", caiwubianhao);}		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(yuefen==null||yuefen.equals("")){pmap.put("yuefen", null);}else{pmap.put("yuefen", yuefen);}		if(dingdanshuliang1==null||dingdanshuliang1.equals("")){pmap.put("dingdanshuliang1", null);}else{pmap.put("dingdanshuliang1", dingdanshuliang1);}		if(dingdanshuliang2==null||dingdanshuliang2.equals("")){pmap.put("dingdanshuliang2", null);}else{pmap.put("dingdanshuliang2", dingdanshuliang2);}		if(dingdanzongjia1==null||dingdanzongjia1.equals("")){pmap.put("dingdanzongjia1", null);}else{pmap.put("dingdanzongjia1", dingdanzongjia1);}		if(dingdanzongjia2==null||dingdanzongjia2.equals("")){pmap.put("dingdanzongjia2", null);}else{pmap.put("dingdanzongjia2", dingdanzongjia2);}		if(duizhangzhuangtai==null||duizhangzhuangtai.equals("")){pmap.put("duizhangzhuangtai", null);}else{pmap.put("duizhangzhuangtai", duizhangzhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(jilushijian1==null||jilushijian1.equals("")){pmap.put("jilushijian1", null);}else{pmap.put("jilushijian1", jilushijian1);}		if(jilushijian2==null||jilushijian2.equals("")){pmap.put("jilushijian2", null);}else{pmap.put("jilushijian2", jilushijian2);}		
		
		int total=caiwuguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caiwuguanli> list=caiwuguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caiwuguanli_list2";
	}	
	
	@RequestMapping("cwglList.do")
	public String cwglList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Caiwuguanli caiwuguanli, String caiwubianhao, String biaoti, String yuefen, String dingdanshuliang1,String dingdanshuliang2, String dingdanzongjia1,String dingdanzongjia2, String duizhangzhuangtai, String beizhu, String wenjian, String jilushijian1,String jilushijian2, String jiluru){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(caiwubianhao==null||caiwubianhao.equals("")){pmap.put("caiwubianhao", null);}else{pmap.put("caiwubianhao", caiwubianhao);}		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(yuefen==null||yuefen.equals("")){pmap.put("yuefen", null);}else{pmap.put("yuefen", yuefen);}		if(dingdanshuliang1==null||dingdanshuliang1.equals("")){pmap.put("dingdanshuliang1", null);}else{pmap.put("dingdanshuliang1", dingdanshuliang1);}		if(dingdanshuliang2==null||dingdanshuliang2.equals("")){pmap.put("dingdanshuliang2", null);}else{pmap.put("dingdanshuliang2", dingdanshuliang2);}		if(dingdanzongjia1==null||dingdanzongjia1.equals("")){pmap.put("dingdanzongjia1", null);}else{pmap.put("dingdanzongjia1", dingdanzongjia1);}		if(dingdanzongjia2==null||dingdanzongjia2.equals("")){pmap.put("dingdanzongjia2", null);}else{pmap.put("dingdanzongjia2", dingdanzongjia2);}		if(duizhangzhuangtai==null||duizhangzhuangtai.equals("")){pmap.put("duizhangzhuangtai", null);}else{pmap.put("duizhangzhuangtai", duizhangzhuangtai);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(jilushijian1==null||jilushijian1.equals("")){pmap.put("jilushijian1", null);}else{pmap.put("jilushijian1", jilushijian1);}		if(jilushijian2==null||jilushijian2.equals("")){pmap.put("jilushijian2", null);}else{pmap.put("jilushijian2", jilushijian2);}		if(jiluru==null||jiluru.equals("")){pmap.put("jiluru", null);}else{pmap.put("jiluru", jiluru);}		
		int total=caiwuguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Caiwuguanli> list=caiwuguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "caiwuguanlilist";
	}
	
	@RequestMapping("deleteCaiwuguanli.do")
	public String deleteCaiwuguanli(int id,HttpServletRequest request){
		caiwuguanliService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:caiwuguanliList.do";
	}
	
	
}
