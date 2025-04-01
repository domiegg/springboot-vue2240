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

import com.entity.Kucunzhanshi;
import com.server.KucunzhanshiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class KucunzhanshiController {
	@Resource
	private KucunzhanshiServer kucunzhanshiService;


   
	@RequestMapping("addKucunzhanshi.do")
	public String addKucunzhanshi(HttpServletRequest request,Kucunzhanshi kucunzhanshi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		kucunzhanshi.setAddtime(time.toString().substring(0, 19));
		kucunzhanshiService.add(kucunzhanshi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "kucunzhanshiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:kucunzhanshiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateKucunzhanshi.do")
	public String doUpdateKucunzhanshi(int id,ModelMap map,Kucunzhanshi kucunzhanshi){
		kucunzhanshi=kucunzhanshiService.getById(id);
		map.put("kucunzhanshi", kucunzhanshi);
		return "kucunzhanshi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("kucunzhanshiDetail.do")
	public String kucunzhanshiDetail(int id,ModelMap map,Kucunzhanshi kucunzhanshi){
		kucunzhanshi=kucunzhanshiService.getById(id);
		map.put("kucunzhanshi", kucunzhanshi);
		return "kucunzhanshi_detail";
	}
//	前台详细
	@RequestMapping("kczsDetail.do")
	public String kczsDetail(int id,ModelMap map,Kucunzhanshi kucunzhanshi){
		kucunzhanshi=kucunzhanshiService.getById(id);
		map.put("kucunzhanshi", kucunzhanshi);
		return "kucunzhanshidetail";
	}
//	
	@RequestMapping("updateKucunzhanshi.do")
	public String updateKucunzhanshi(int id,ModelMap map,Kucunzhanshi kucunzhanshi,HttpServletRequest request,HttpSession session){
		kucunzhanshiService.update(kucunzhanshi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:kucunzhanshiList.do";
	}

//	分页查询
	@RequestMapping("kucunzhanshiList.do")
	public String kucunzhanshiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kucunzhanshi kucunzhanshi, String shejibianhao, String shejimingcheng, String mobanleixing, String jiage, String kucunshuliang1,String kucunshuliang2, String rukuriqi1,String rukuriqi2, String xiugaishijian1,String xiugaishijian2, String xiugairen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(kucunshuliang1==null||kucunshuliang1.equals("")){pmap.put("kucunshuliang1", null);}else{pmap.put("kucunshuliang1", kucunshuliang1);}		if(kucunshuliang2==null||kucunshuliang2.equals("")){pmap.put("kucunshuliang2", null);}else{pmap.put("kucunshuliang2", kucunshuliang2);}		if(rukuriqi1==null||rukuriqi1.equals("")){pmap.put("rukuriqi1", null);}else{pmap.put("rukuriqi1", rukuriqi1);}		if(rukuriqi2==null||rukuriqi2.equals("")){pmap.put("rukuriqi2", null);}else{pmap.put("rukuriqi2", rukuriqi2);}		if(xiugaishijian1==null||xiugaishijian1.equals("")){pmap.put("xiugaishijian1", null);}else{pmap.put("xiugaishijian1", xiugaishijian1);}		if(xiugaishijian2==null||xiugaishijian2.equals("")){pmap.put("xiugaishijian2", null);}else{pmap.put("xiugaishijian2", xiugaishijian2);}		if(xiugairen==null||xiugairen.equals("")){pmap.put("xiugairen", null);}else{pmap.put("xiugairen", xiugairen);}		
		int total=kucunzhanshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kucunzhanshi> list=kucunzhanshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kucunzhanshi_list";
	}
	
	@RequestMapping("kucunzhanshiList2.do")
	public String kucunzhanshiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kucunzhanshi kucunzhanshi, String shejibianhao, String shejimingcheng, String mobanleixing, String jiage, String kucunshuliang1,String kucunshuliang2, String rukuriqi1,String rukuriqi2, String xiugaishijian1,String xiugaishijian2, String xiugairen,HttpServletRequest request){
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
		
		pmap.put("xiugairen", (String)request.getSession().getAttribute("username"));
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(kucunshuliang1==null||kucunshuliang1.equals("")){pmap.put("kucunshuliang1", null);}else{pmap.put("kucunshuliang1", kucunshuliang1);}		if(kucunshuliang2==null||kucunshuliang2.equals("")){pmap.put("kucunshuliang2", null);}else{pmap.put("kucunshuliang2", kucunshuliang2);}		if(rukuriqi1==null||rukuriqi1.equals("")){pmap.put("rukuriqi1", null);}else{pmap.put("rukuriqi1", rukuriqi1);}		if(rukuriqi2==null||rukuriqi2.equals("")){pmap.put("rukuriqi2", null);}else{pmap.put("rukuriqi2", rukuriqi2);}		if(xiugaishijian1==null||xiugaishijian1.equals("")){pmap.put("xiugaishijian1", null);}else{pmap.put("xiugaishijian1", xiugaishijian1);}		if(xiugaishijian2==null||xiugaishijian2.equals("")){pmap.put("xiugaishijian2", null);}else{pmap.put("xiugaishijian2", xiugaishijian2);}		
		
		int total=kucunzhanshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kucunzhanshi> list=kucunzhanshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kucunzhanshi_list2";
	}	
	
	@RequestMapping("kczsList.do")
	public String kczsList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kucunzhanshi kucunzhanshi, String shejibianhao, String shejimingcheng, String mobanleixing, String jiage, String kucunshuliang1,String kucunshuliang2, String rukuriqi1,String rukuriqi2, String xiugaishijian1,String xiugaishijian2, String xiugairen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(kucunshuliang1==null||kucunshuliang1.equals("")){pmap.put("kucunshuliang1", null);}else{pmap.put("kucunshuliang1", kucunshuliang1);}		if(kucunshuliang2==null||kucunshuliang2.equals("")){pmap.put("kucunshuliang2", null);}else{pmap.put("kucunshuliang2", kucunshuliang2);}		if(rukuriqi1==null||rukuriqi1.equals("")){pmap.put("rukuriqi1", null);}else{pmap.put("rukuriqi1", rukuriqi1);}		if(rukuriqi2==null||rukuriqi2.equals("")){pmap.put("rukuriqi2", null);}else{pmap.put("rukuriqi2", rukuriqi2);}		if(xiugaishijian1==null||xiugaishijian1.equals("")){pmap.put("xiugaishijian1", null);}else{pmap.put("xiugaishijian1", xiugaishijian1);}		if(xiugaishijian2==null||xiugaishijian2.equals("")){pmap.put("xiugaishijian2", null);}else{pmap.put("xiugaishijian2", xiugaishijian2);}		if(xiugairen==null||xiugairen.equals("")){pmap.put("xiugairen", null);}else{pmap.put("xiugairen", xiugairen);}		
		int total=kucunzhanshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kucunzhanshi> list=kucunzhanshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kucunzhanshilist";
	}
	
	@RequestMapping("deleteKucunzhanshi.do")
	public String deleteKucunzhanshi(int id,HttpServletRequest request){
		kucunzhanshiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:kucunzhanshiList.do";
	}
	
	
}
