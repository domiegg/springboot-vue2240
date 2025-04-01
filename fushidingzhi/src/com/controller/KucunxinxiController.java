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

import com.entity.Kucunxinxi;
import com.server.KucunxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class KucunxinxiController {
	@Resource
	private KucunxinxiServer kucunxinxiService;


   
	@RequestMapping("addKucunxinxi.do")
	public String addKucunxinxi(HttpServletRequest request,Kucunxinxi kucunxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		kucunxinxi.setAddtime(time.toString().substring(0, 19));
		kucunxinxiService.add(kucunxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "kucunxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:kucunxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateKucunxinxi.do")
	public String doUpdateKucunxinxi(int id,ModelMap map,Kucunxinxi kucunxinxi){
		kucunxinxi=kucunxinxiService.getById(id);
		map.put("kucunxinxi", kucunxinxi);
		return "kucunxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("kucunxinxiDetail.do")
	public String kucunxinxiDetail(int id,ModelMap map,Kucunxinxi kucunxinxi){
		kucunxinxi=kucunxinxiService.getById(id);
		map.put("kucunxinxi", kucunxinxi);
		return "kucunxinxi_detail";
	}
//	前台详细
	@RequestMapping("kcxxDetail.do")
	public String kcxxDetail(int id,ModelMap map,Kucunxinxi kucunxinxi){
		kucunxinxi=kucunxinxiService.getById(id);
		map.put("kucunxinxi", kucunxinxi);
		return "kucunxinxidetail";
	}
//	
	@RequestMapping("updateKucunxinxi.do")
	public String updateKucunxinxi(int id,ModelMap map,Kucunxinxi kucunxinxi,HttpServletRequest request,HttpSession session){
		kucunxinxiService.update(kucunxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:kucunxinxiList.do";
	}

//	分页查询
	@RequestMapping("kucunxinxiList.do")
	public String kucunxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kucunxinxi kucunxinxi, String shejibianhao, String shejimingcheng, String mobanleixing, String jiage, String kucunshuliang1,String kucunshuliang2, String rukuriqi1,String rukuriqi2, String xiugaishijian1,String xiugaishijian2, String xiugairen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(kucunshuliang1==null||kucunshuliang1.equals("")){pmap.put("kucunshuliang1", null);}else{pmap.put("kucunshuliang1", kucunshuliang1);}		if(kucunshuliang2==null||kucunshuliang2.equals("")){pmap.put("kucunshuliang2", null);}else{pmap.put("kucunshuliang2", kucunshuliang2);}		if(rukuriqi1==null||rukuriqi1.equals("")){pmap.put("rukuriqi1", null);}else{pmap.put("rukuriqi1", rukuriqi1);}		if(rukuriqi2==null||rukuriqi2.equals("")){pmap.put("rukuriqi2", null);}else{pmap.put("rukuriqi2", rukuriqi2);}		if(xiugaishijian1==null||xiugaishijian1.equals("")){pmap.put("xiugaishijian1", null);}else{pmap.put("xiugaishijian1", xiugaishijian1);}		if(xiugaishijian2==null||xiugaishijian2.equals("")){pmap.put("xiugaishijian2", null);}else{pmap.put("xiugaishijian2", xiugaishijian2);}		if(xiugairen==null||xiugairen.equals("")){pmap.put("xiugairen", null);}else{pmap.put("xiugairen", xiugairen);}		
		int total=kucunxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kucunxinxi> list=kucunxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kucunxinxi_list";
	}
	
	@RequestMapping("kucunxinxiList2.do")
	public String kucunxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kucunxinxi kucunxinxi, String shejibianhao, String shejimingcheng, String mobanleixing, String jiage, String kucunshuliang1,String kucunshuliang2, String rukuriqi1,String rukuriqi2, String xiugaishijian1,String xiugaishijian2, String xiugairen,HttpServletRequest request){
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
		
		int total=kucunxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kucunxinxi> list=kucunxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kucunxinxi_list2";
	}
	
	@RequestMapping("kucunxinxiList3.do")
	public String kucunxinxiList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kucunxinxi kucunxinxi, String shejibianhao, String shejimingcheng, String mobanleixing, String jiage, String kucunshuliang1,String kucunshuliang2, String rukuriqi1,String rukuriqi2, String xiugaishijian1,String xiugaishijian2, String xiugairen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}
		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}
		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}
		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}
		if(kucunshuliang1==null||kucunshuliang1.equals("")){pmap.put("kucunshuliang1", null);}else{pmap.put("kucunshuliang1", kucunshuliang1);}
		if(kucunshuliang2==null||kucunshuliang2.equals("")){pmap.put("kucunshuliang2", null);}else{pmap.put("kucunshuliang2", kucunshuliang2);}
		if(rukuriqi1==null||rukuriqi1.equals("")){pmap.put("rukuriqi1", null);}else{pmap.put("rukuriqi1", rukuriqi1);}
		if(rukuriqi2==null||rukuriqi2.equals("")){pmap.put("rukuriqi2", null);}else{pmap.put("rukuriqi2", rukuriqi2);}
		if(xiugaishijian1==null||xiugaishijian1.equals("")){pmap.put("xiugaishijian1", null);}else{pmap.put("xiugaishijian1", xiugaishijian1);}
		if(xiugaishijian2==null||xiugaishijian2.equals("")){pmap.put("xiugaishijian2", null);}else{pmap.put("xiugaishijian2", xiugaishijian2);}
		if(xiugairen==null||xiugairen.equals("")){pmap.put("xiugairen", null);}else{pmap.put("xiugairen", xiugairen);}
		
		int total=kucunxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kucunxinxi> list=kucunxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kucunxinxi_list3";
	}	
	
	@RequestMapping("kcxxList.do")
	public String kcxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kucunxinxi kucunxinxi, String shejibianhao, String shejimingcheng, String mobanleixing, String jiage, String kucunshuliang1,String kucunshuliang2, String rukuriqi1,String rukuriqi2, String xiugaishijian1,String xiugaishijian2, String xiugairen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(kucunshuliang1==null||kucunshuliang1.equals("")){pmap.put("kucunshuliang1", null);}else{pmap.put("kucunshuliang1", kucunshuliang1);}		if(kucunshuliang2==null||kucunshuliang2.equals("")){pmap.put("kucunshuliang2", null);}else{pmap.put("kucunshuliang2", kucunshuliang2);}		if(rukuriqi1==null||rukuriqi1.equals("")){pmap.put("rukuriqi1", null);}else{pmap.put("rukuriqi1", rukuriqi1);}		if(rukuriqi2==null||rukuriqi2.equals("")){pmap.put("rukuriqi2", null);}else{pmap.put("rukuriqi2", rukuriqi2);}		if(xiugaishijian1==null||xiugaishijian1.equals("")){pmap.put("xiugaishijian1", null);}else{pmap.put("xiugaishijian1", xiugaishijian1);}		if(xiugaishijian2==null||xiugaishijian2.equals("")){pmap.put("xiugaishijian2", null);}else{pmap.put("xiugaishijian2", xiugaishijian2);}		if(xiugairen==null||xiugairen.equals("")){pmap.put("xiugairen", null);}else{pmap.put("xiugairen", xiugairen);}		
		int total=kucunxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kucunxinxi> list=kucunxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kucunxinxilist";
	}
	
	@RequestMapping("deleteKucunxinxi.do")
	public String deleteKucunxinxi(int id,HttpServletRequest request){
		kucunxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:kucunxinxiList.do";
	}
	
	
}
