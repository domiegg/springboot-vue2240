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

import com.entity.Mobanxinxi;
import com.server.MobanxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class MobanxinxiController {
	@Resource
	private MobanxinxiServer mobanxinxiService;


   
	@RequestMapping("addMobanxinxi.do")
	public String addMobanxinxi(HttpServletRequest request,Mobanxinxi mobanxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		mobanxinxi.setAddtime(time.toString().substring(0, 19));
		mobanxinxiService.add(mobanxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "mobanxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:mobanxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateMobanxinxi.do")
	public String doUpdateMobanxinxi(int id,ModelMap map,Mobanxinxi mobanxinxi){
		mobanxinxi=mobanxinxiService.getById(id);
		map.put("mobanxinxi", mobanxinxi);
		return "mobanxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("mobanxinxiDetail.do")
	public String mobanxinxiDetail(int id,ModelMap map,Mobanxinxi mobanxinxi){
		mobanxinxi=mobanxinxiService.getById(id);
		map.put("mobanxinxi", mobanxinxi);
		return "mobanxinxi_detail";
	}
//	前台详细
	@RequestMapping("mbxxDetail.do")
	public String mbxxDetail(int id,ModelMap map,Mobanxinxi mobanxinxi){
		mobanxinxi=mobanxinxiService.getById(id);
		map.put("mobanxinxi", mobanxinxi);
		return "mobanxinxidetail";
	}
//	
	@RequestMapping("updateMobanxinxi.do")
	public String updateMobanxinxi(int id,ModelMap map,Mobanxinxi mobanxinxi,HttpServletRequest request,HttpSession session){
		mobanxinxiService.update(mobanxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:mobanxinxiList.do";
	}

//	分页查询
	@RequestMapping("mobanxinxiList.do")
	public String mobanxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Mobanxinxi mobanxinxi, String mobanbianhao, String mobanmingcheng, String mobanleixing, String mobantupian, String mobanshuoming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(mobanbianhao==null||mobanbianhao.equals("")){pmap.put("mobanbianhao", null);}else{pmap.put("mobanbianhao", mobanbianhao);}		if(mobanmingcheng==null||mobanmingcheng.equals("")){pmap.put("mobanmingcheng", null);}else{pmap.put("mobanmingcheng", mobanmingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(mobantupian==null||mobantupian.equals("")){pmap.put("mobantupian", null);}else{pmap.put("mobantupian", mobantupian);}		if(mobanshuoming==null||mobanshuoming.equals("")){pmap.put("mobanshuoming", null);}else{pmap.put("mobanshuoming", mobanshuoming);}		
		int total=mobanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Mobanxinxi> list=mobanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "mobanxinxi_list";
	}
	
	@RequestMapping("mobanxinxiList2.do")
	public String mobanxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Mobanxinxi mobanxinxi, String mobanbianhao, String mobanmingcheng, String mobanleixing, String mobantupian, String mobanshuoming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(mobanbianhao==null||mobanbianhao.equals("")){pmap.put("mobanbianhao", null);}else{pmap.put("mobanbianhao", mobanbianhao);}
		if(mobanmingcheng==null||mobanmingcheng.equals("")){pmap.put("mobanmingcheng", null);}else{pmap.put("mobanmingcheng", mobanmingcheng);}
		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}
		if(mobantupian==null||mobantupian.equals("")){pmap.put("mobantupian", null);}else{pmap.put("mobantupian", mobantupian);}
		if(mobanshuoming==null||mobanshuoming.equals("")){pmap.put("mobanshuoming", null);}else{pmap.put("mobanshuoming", mobanshuoming);}
		
		int total=mobanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Mobanxinxi> list=mobanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "mobanxinxi_list2";
	}
	
	@RequestMapping("mbxxList.do")
	public String mbxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Mobanxinxi mobanxinxi, String mobanbianhao, String mobanmingcheng, String mobanleixing, String mobantupian, String mobanshuoming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(mobanbianhao==null||mobanbianhao.equals("")){pmap.put("mobanbianhao", null);}else{pmap.put("mobanbianhao", mobanbianhao);}		if(mobanmingcheng==null||mobanmingcheng.equals("")){pmap.put("mobanmingcheng", null);}else{pmap.put("mobanmingcheng", mobanmingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(mobantupian==null||mobantupian.equals("")){pmap.put("mobantupian", null);}else{pmap.put("mobantupian", mobantupian);}		if(mobanshuoming==null||mobanshuoming.equals("")){pmap.put("mobanshuoming", null);}else{pmap.put("mobanshuoming", mobanshuoming);}		
		int total=mobanxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Mobanxinxi> list=mobanxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "mobanxinxilist";
	}
	
	@RequestMapping("deleteMobanxinxi.do")
	public String deleteMobanxinxi(int id,HttpServletRequest request){
		mobanxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:mobanxinxiList.do";
	}
	
	@RequestMapping("quchongMobanxinxi.do")
	public void quchongMobanxinxi(Mobanxinxi mobanxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("mobanbianhao", mobanxinxi.getMobanbianhao());
		   System.out.println("mobanbianhao==="+mobanxinxi.getMobanbianhao());
		   System.out.println("mobanbianhao222==="+mobanxinxiService.quchongMobanxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(mobanxinxiService.quchongMobanxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "模板编号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
