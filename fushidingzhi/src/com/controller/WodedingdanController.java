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

import com.entity.Wodedingdan;
import com.server.WodedingdanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class WodedingdanController {
	@Resource
	private WodedingdanServer wodedingdanService;


   
	@RequestMapping("addWodedingdan.do")
	public String addWodedingdan(HttpServletRequest request,Wodedingdan wodedingdan,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		wodedingdan.setAddtime(time.toString().substring(0, 19));
		wodedingdanService.add(wodedingdan);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "wodedingdanList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:wodedingdanList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateWodedingdan.do")
	public String doUpdateWodedingdan(int id,ModelMap map,Wodedingdan wodedingdan){
		wodedingdan=wodedingdanService.getById(id);
		map.put("wodedingdan", wodedingdan);
		return "wodedingdan_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("wodedingdanDetail.do")
	public String wodedingdanDetail(int id,ModelMap map,Wodedingdan wodedingdan){
		wodedingdan=wodedingdanService.getById(id);
		map.put("wodedingdan", wodedingdan);
		return "wodedingdan_detail";
	}
//	前台详细
	@RequestMapping("wdddDetail.do")
	public String wdddDetail(int id,ModelMap map,Wodedingdan wodedingdan){
		wodedingdan=wodedingdanService.getById(id);
		map.put("wodedingdan", wodedingdan);
		return "wodedingdandetail";
	}
//	
	@RequestMapping("updateWodedingdan.do")
	public String updateWodedingdan(int id,ModelMap map,Wodedingdan wodedingdan,HttpServletRequest request,HttpSession session){
		wodedingdanService.update(wodedingdan);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:wodedingdanList.do";
	}

//	分页查询
	@RequestMapping("wodedingdanList.do")
	public String wodedingdanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wodedingdan wodedingdan, String shejibianhao, String shejimingcheng, String mobanleixing, String jiage, String dingdanshuliang1,String dingdanshuliang2, String dingdanjiage, String lianxidianhua, String shouhuodizhi, String chuangjianshijian1,String chuangjianshijian2, String goumairen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(dingdanshuliang1==null||dingdanshuliang1.equals("")){pmap.put("dingdanshuliang1", null);}else{pmap.put("dingdanshuliang1", dingdanshuliang1);}		if(dingdanshuliang2==null||dingdanshuliang2.equals("")){pmap.put("dingdanshuliang2", null);}else{pmap.put("dingdanshuliang2", dingdanshuliang2);}		if(dingdanjiage==null||dingdanjiage.equals("")){pmap.put("dingdanjiage", null);}else{pmap.put("dingdanjiage", dingdanjiage);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}		
		int total=wodedingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wodedingdan> list=wodedingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wodedingdan_list";
	}
	
	@RequestMapping("wodedingdanList2.do")
	public String wodedingdanList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wodedingdan wodedingdan, String shejibianhao, String shejimingcheng, String mobanleixing, String jiage, String dingdanshuliang1,String dingdanshuliang2, String dingdanjiage, String lianxidianhua, String shouhuodizhi, String chuangjianshijian1,String chuangjianshijian2, String goumairen, String issh,HttpServletRequest request){
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
		
		pmap.put("goumairen", (String)request.getSession().getAttribute("username"));
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(dingdanshuliang1==null||dingdanshuliang1.equals("")){pmap.put("dingdanshuliang1", null);}else{pmap.put("dingdanshuliang1", dingdanshuliang1);}		if(dingdanshuliang2==null||dingdanshuliang2.equals("")){pmap.put("dingdanshuliang2", null);}else{pmap.put("dingdanshuliang2", dingdanshuliang2);}		if(dingdanjiage==null||dingdanjiage.equals("")){pmap.put("dingdanjiage", null);}else{pmap.put("dingdanjiage", dingdanjiage);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}		
		
		int total=wodedingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wodedingdan> list=wodedingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wodedingdan_list2";
	}	
	@RequestMapping("wodedingdanList3.do")
	public String wodedingdanList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wodedingdan wodedingdan, String shejibianhao, String shejimingcheng, String mobanleixing, String jiage, String dingdanshuliang1,String dingdanshuliang2, String dingdanjiage, String lianxidianhua, String shouhuodizhi, String chuangjianshijian1,String chuangjianshijian2, String goumairen, String issh){
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
		if(dingdanshuliang1==null||dingdanshuliang1.equals("")){pmap.put("dingdanshuliang1", null);}else{pmap.put("dingdanshuliang1", dingdanshuliang1);}
		if(dingdanshuliang2==null||dingdanshuliang2.equals("")){pmap.put("dingdanshuliang2", null);}else{pmap.put("dingdanshuliang2", dingdanshuliang2);}
		if(dingdanjiage==null||dingdanjiage.equals("")){pmap.put("dingdanjiage", null);}else{pmap.put("dingdanjiage", dingdanjiage);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}
		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}
		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}
		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}
		
		int total=wodedingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wodedingdan> list=wodedingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wodedingdan_list3";
	}
	
	
	@RequestMapping("wdddList.do")
	public String wdddList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Wodedingdan wodedingdan, String shejibianhao, String shejimingcheng, String mobanleixing, String jiage, String dingdanshuliang1,String dingdanshuliang2, String dingdanjiage, String lianxidianhua, String shouhuodizhi, String chuangjianshijian1,String chuangjianshijian2, String goumairen, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(jiage==null||jiage.equals("")){pmap.put("jiage", null);}else{pmap.put("jiage", jiage);}		if(dingdanshuliang1==null||dingdanshuliang1.equals("")){pmap.put("dingdanshuliang1", null);}else{pmap.put("dingdanshuliang1", dingdanshuliang1);}		if(dingdanshuliang2==null||dingdanshuliang2.equals("")){pmap.put("dingdanshuliang2", null);}else{pmap.put("dingdanshuliang2", dingdanshuliang2);}		if(dingdanjiage==null||dingdanjiage.equals("")){pmap.put("dingdanjiage", null);}else{pmap.put("dingdanjiage", dingdanjiage);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}		if(chuangjianshijian1==null||chuangjianshijian1.equals("")){pmap.put("chuangjianshijian1", null);}else{pmap.put("chuangjianshijian1", chuangjianshijian1);}		if(chuangjianshijian2==null||chuangjianshijian2.equals("")){pmap.put("chuangjianshijian2", null);}else{pmap.put("chuangjianshijian2", chuangjianshijian2);}		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}		
		int total=wodedingdanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Wodedingdan> list=wodedingdanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "wodedingdanlist";
	}
	
	@RequestMapping("deleteWodedingdan.do")
	public String deleteWodedingdan(int id,HttpServletRequest request){
		wodedingdanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:wodedingdanList.do";
	}
	
	
}
