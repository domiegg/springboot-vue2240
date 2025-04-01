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

import com.entity.Shejizhanshi;
import com.server.ShejizhanshiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShejizhanshiController {
	@Resource
	private ShejizhanshiServer shejizhanshiService;


   
	@RequestMapping("addShejizhanshi.do")
	public String addShejizhanshi(HttpServletRequest request,Shejizhanshi shejizhanshi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shejizhanshi.setAddtime(time.toString().substring(0, 19));
		shejizhanshiService.add(shejizhanshi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shejizhanshiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shejizhanshiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShejizhanshi.do")
	public String doUpdateShejizhanshi(int id,ModelMap map,Shejizhanshi shejizhanshi){
		shejizhanshi=shejizhanshiService.getById(id);
		map.put("shejizhanshi", shejizhanshi);
		return "shejizhanshi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shejizhanshiDetail.do")
	public String shejizhanshiDetail(int id,ModelMap map,Shejizhanshi shejizhanshi){
		shejizhanshi=shejizhanshiService.getById(id);
		map.put("shejizhanshi", shejizhanshi);
		return "shejizhanshi_detail";
	}
//	前台详细
	@RequestMapping("sjzsDetail.do")
	public String sjzsDetail(int id,ModelMap map,Shejizhanshi shejizhanshi){
		shejizhanshi=shejizhanshiService.getById(id);
		map.put("shejizhanshi", shejizhanshi);
		return "shejizhanshidetail";
	}
//	
	@RequestMapping("updateShejizhanshi.do")
	public String updateShejizhanshi(int id,ModelMap map,Shejizhanshi shejizhanshi,HttpServletRequest request,HttpSession session){
		shejizhanshiService.update(shejizhanshi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shejizhanshiList.do";
	}

//	分页查询
	@RequestMapping("shejizhanshiList.do")
	public String shejizhanshiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejizhanshi shejizhanshi, String shejibianhao, String shejimingcheng, String mobanleixing, String shejihuitu, String shejishuoming, String shejishi, String jiage1,String jiage2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(shejihuitu==null||shejihuitu.equals("")){pmap.put("shejihuitu", null);}else{pmap.put("shejihuitu", shejihuitu);}		if(shejishuoming==null||shejishuoming.equals("")){pmap.put("shejishuoming", null);}else{pmap.put("shejishuoming", shejishuoming);}		if(shejishi==null||shejishi.equals("")){pmap.put("shejishi", null);}else{pmap.put("shejishi", shejishi);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		
		int total=shejizhanshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejizhanshi> list=shejizhanshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejizhanshi_list";
	}
	
	@RequestMapping("shejizhanshiList2.do")
	public String shejizhanshiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejizhanshi shejizhanshi, String shejibianhao, String shejimingcheng, String mobanleixing, String shejihuitu, String shejishuoming, String shejishi, String jiage1,String jiage2){
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
		if(shejihuitu==null||shejihuitu.equals("")){pmap.put("shejihuitu", null);}else{pmap.put("shejihuitu", shejihuitu);}
		if(shejishuoming==null||shejishuoming.equals("")){pmap.put("shejishuoming", null);}else{pmap.put("shejishuoming", shejishuoming);}
		if(shejishi==null||shejishi.equals("")){pmap.put("shejishi", null);}else{pmap.put("shejishi", shejishi);}
		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
		
		int total=shejizhanshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejizhanshi> list=shejizhanshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejizhanshi_list2";
	}
	
	@RequestMapping("shejizhanshiList3.do")
	public String shejizhanshiList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejizhanshi shejizhanshi, String shejibianhao, String shejimingcheng, String mobanleixing, String shejihuitu, String shejishuoming, String shejishi, String jiage1,String jiage2){
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
		if(shejihuitu==null||shejihuitu.equals("")){pmap.put("shejihuitu", null);}else{pmap.put("shejihuitu", shejihuitu);}
		if(shejishuoming==null||shejishuoming.equals("")){pmap.put("shejishuoming", null);}else{pmap.put("shejishuoming", shejishuoming);}
		if(shejishi==null||shejishi.equals("")){pmap.put("shejishi", null);}else{pmap.put("shejishi", shejishi);}
		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
		
		int total=shejizhanshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejizhanshi> list=shejizhanshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejizhanshi_list3";
	}
	
	@RequestMapping("shejizhanshiList4.do")
	public String shejizhanshiList4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejizhanshi shejizhanshi, String shejibianhao, String shejimingcheng, String mobanleixing, String shejihuitu, String shejishuoming, String shejishi, String jiage1,String jiage2){
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
		if(shejihuitu==null||shejihuitu.equals("")){pmap.put("shejihuitu", null);}else{pmap.put("shejihuitu", shejihuitu);}
		if(shejishuoming==null||shejishuoming.equals("")){pmap.put("shejishuoming", null);}else{pmap.put("shejishuoming", shejishuoming);}
		if(shejishi==null||shejishi.equals("")){pmap.put("shejishi", null);}else{pmap.put("shejishi", shejishi);}
		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}
		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}
		
		int total=shejizhanshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejizhanshi> list=shejizhanshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejizhanshi_list4";
	}
	
	
	
	@RequestMapping("sjzsList.do")
	public String sjzsList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejizhanshi shejizhanshi, String shejibianhao, String shejimingcheng, String mobanleixing, String shejihuitu, String shejishuoming, String shejishi, String jiage1,String jiage2){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(shejihuitu==null||shejihuitu.equals("")){pmap.put("shejihuitu", null);}else{pmap.put("shejihuitu", shejihuitu);}		if(shejishuoming==null||shejishuoming.equals("")){pmap.put("shejishuoming", null);}else{pmap.put("shejishuoming", shejishuoming);}		if(shejishi==null||shejishi.equals("")){pmap.put("shejishi", null);}else{pmap.put("shejishi", shejishi);}		if(jiage1==null||jiage1.equals("")){pmap.put("jiage1", null);}else{pmap.put("jiage1", jiage1);}		if(jiage2==null||jiage2.equals("")){pmap.put("jiage2", null);}else{pmap.put("jiage2", jiage2);}		
		int total=shejizhanshiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejizhanshi> list=shejizhanshiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejizhanshilist";
	}
	
	@RequestMapping("deleteShejizhanshi.do")
	public String deleteShejizhanshi(int id,HttpServletRequest request){
		shejizhanshiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shejizhanshiList.do";
	}
	
	
}
