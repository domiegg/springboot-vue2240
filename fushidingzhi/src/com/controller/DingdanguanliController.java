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

import com.entity.Dingdanguanli;
import com.server.DingdanguanliServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class DingdanguanliController {
	@Resource
	private DingdanguanliServer dingdanguanliService;


   
	@RequestMapping("addDingdanguanli.do")
	public String addDingdanguanli(HttpServletRequest request,Dingdanguanli dingdanguanli,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		dingdanguanli.setAddtime(time.toString().substring(0, 19));
		dingdanguanliService.add(dingdanguanli);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "dingdanguanliList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:dingdanguanliList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateDingdanguanli.do")
	public String doUpdateDingdanguanli(int id,ModelMap map,Dingdanguanli dingdanguanli){
		dingdanguanli=dingdanguanliService.getById(id);
		map.put("dingdanguanli", dingdanguanli);
		return "dingdanguanli_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("dingdanguanliDetail.do")
	public String dingdanguanliDetail(int id,ModelMap map,Dingdanguanli dingdanguanli){
		dingdanguanli=dingdanguanliService.getById(id);
		map.put("dingdanguanli", dingdanguanli);
		return "dingdanguanli_detail";
	}
//	前台详细
	@RequestMapping("ddglDetail.do")
	public String ddglDetail(int id,ModelMap map,Dingdanguanli dingdanguanli){
		dingdanguanli=dingdanguanliService.getById(id);
		map.put("dingdanguanli", dingdanguanli);
		return "dingdanguanlidetail";
	}
//	
	@RequestMapping("updateDingdanguanli.do")
	public String updateDingdanguanli(int id,ModelMap map,Dingdanguanli dingdanguanli,HttpServletRequest request,HttpSession session){
		dingdanguanliService.update(dingdanguanli);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:dingdanguanliList.do";
	}

//	分页查询
	@RequestMapping("dingdanguanliList.do")
	public String dingdanguanliList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdanguanli dingdanguanli, String shejibianhao, String shejimingcheng, String mobanleixing, String dingdanshuliang, String dingdanjiage, String shouhuodizhi, String lianxidianhua, String goumairen, String dingdanzhuangtai, String wuliuzhuangtai, String wuliudanhao1,String wuliudanhao2, String jilushijian1,String jilushijian2, String jiluren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(dingdanshuliang==null||dingdanshuliang.equals("")){pmap.put("dingdanshuliang", null);}else{pmap.put("dingdanshuliang", dingdanshuliang);}		if(dingdanjiage==null||dingdanjiage.equals("")){pmap.put("dingdanjiage", null);}else{pmap.put("dingdanjiage", dingdanjiage);}		if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}		if(wuliuzhuangtai==null||wuliuzhuangtai.equals("")){pmap.put("wuliuzhuangtai", null);}else{pmap.put("wuliuzhuangtai", wuliuzhuangtai);}		if(wuliudanhao1==null||wuliudanhao1.equals("")){pmap.put("wuliudanhao1", null);}else{pmap.put("wuliudanhao1", wuliudanhao1);}		if(wuliudanhao2==null||wuliudanhao2.equals("")){pmap.put("wuliudanhao2", null);}else{pmap.put("wuliudanhao2", wuliudanhao2);}		if(jilushijian1==null||jilushijian1.equals("")){pmap.put("jilushijian1", null);}else{pmap.put("jilushijian1", jilushijian1);}		if(jilushijian2==null||jilushijian2.equals("")){pmap.put("jilushijian2", null);}else{pmap.put("jilushijian2", jilushijian2);}		if(jiluren==null||jiluren.equals("")){pmap.put("jiluren", null);}else{pmap.put("jiluren", jiluren);}		
		int total=dingdanguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdanguanli> list=dingdanguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdanguanli_list";
	}
	
	
		@RequestMapping("dingdanguanliList2.do")
	public String dingdanguanliList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdanguanli dingdanguanli, String shejibianhao, String shejimingcheng, String mobanleixing, String dingdanshuliang, String dingdanjiage, String shouhuodizhi, String lianxidianhua, String goumairen, String dingdanzhuangtai, String wuliuzhuangtai, String wuliudanhao1,String wuliudanhao2, String jilushijian1,String jilushijian2, String jiluren, String issh,HttpServletRequest request){
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
		
		pmap.put("jiluren", (String)request.getSession().getAttribute("username"));
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(dingdanshuliang==null||dingdanshuliang.equals("")){pmap.put("dingdanshuliang", null);}else{pmap.put("dingdanshuliang", dingdanshuliang);}		if(dingdanjiage==null||dingdanjiage.equals("")){pmap.put("dingdanjiage", null);}else{pmap.put("dingdanjiage", dingdanjiage);}		if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}		if(wuliuzhuangtai==null||wuliuzhuangtai.equals("")){pmap.put("wuliuzhuangtai", null);}else{pmap.put("wuliuzhuangtai", wuliuzhuangtai);}		if(wuliudanhao1==null||wuliudanhao1.equals("")){pmap.put("wuliudanhao1", null);}else{pmap.put("wuliudanhao1", wuliudanhao1);}		if(wuliudanhao2==null||wuliudanhao2.equals("")){pmap.put("wuliudanhao2", null);}else{pmap.put("wuliudanhao2", wuliudanhao2);}		if(jilushijian1==null||jilushijian1.equals("")){pmap.put("jilushijian1", null);}else{pmap.put("jilushijian1", jilushijian1);}		if(jilushijian2==null||jilushijian2.equals("")){pmap.put("jilushijian2", null);}else{pmap.put("jilushijian2", jilushijian2);}		
		
		int total=dingdanguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdanguanli> list=dingdanguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdanguanli_list2";
	}
		@RequestMapping("dingdanguanliList3.do")
	public String dingdanguanliList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdanguanli dingdanguanli, String shejibianhao, String shejimingcheng, String mobanleixing, String dingdanshuliang, String dingdanjiage, String shouhuodizhi, String lianxidianhua, String goumairen, String dingdanzhuangtai, String wuliuzhuangtai, String wuliudanhao1,String wuliudanhao2, String jilushijian1,String jilushijian2, String jiluren, String issh,HttpServletRequest request){
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
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}
		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}
		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}
		if(dingdanshuliang==null||dingdanshuliang.equals("")){pmap.put("dingdanshuliang", null);}else{pmap.put("dingdanshuliang", dingdanshuliang);}
		if(dingdanjiage==null||dingdanjiage.equals("")){pmap.put("dingdanjiage", null);}else{pmap.put("dingdanjiage", dingdanjiage);}
		if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}
		if(wuliuzhuangtai==null||wuliuzhuangtai.equals("")){pmap.put("wuliuzhuangtai", null);}else{pmap.put("wuliuzhuangtai", wuliuzhuangtai);}
		if(wuliudanhao1==null||wuliudanhao1.equals("")){pmap.put("wuliudanhao1", null);}else{pmap.put("wuliudanhao1", wuliudanhao1);}
		if(wuliudanhao2==null||wuliudanhao2.equals("")){pmap.put("wuliudanhao2", null);}else{pmap.put("wuliudanhao2", wuliudanhao2);}
		if(jilushijian1==null||jilushijian1.equals("")){pmap.put("jilushijian1", null);}else{pmap.put("jilushijian1", jilushijian1);}
		if(jilushijian2==null||jilushijian2.equals("")){pmap.put("jilushijian2", null);}else{pmap.put("jilushijian2", jilushijian2);}
		
		
		int total=dingdanguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdanguanli> list=dingdanguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdanguanli_list3";
	}
	
	@RequestMapping("ddglList.do")
	public String ddglList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Dingdanguanli dingdanguanli, String shejibianhao, String shejimingcheng, String mobanleixing, String dingdanshuliang, String dingdanjiage, String shouhuodizhi, String lianxidianhua, String goumairen, String dingdanzhuangtai, String wuliuzhuangtai, String wuliudanhao1,String wuliudanhao2, String jilushijian1,String jilushijian2, String jiluren, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(dingdanshuliang==null||dingdanshuliang.equals("")){pmap.put("dingdanshuliang", null);}else{pmap.put("dingdanshuliang", dingdanshuliang);}		if(dingdanjiage==null||dingdanjiage.equals("")){pmap.put("dingdanjiage", null);}else{pmap.put("dingdanjiage", dingdanjiage);}		if(shouhuodizhi==null||shouhuodizhi.equals("")){pmap.put("shouhuodizhi", null);}else{pmap.put("shouhuodizhi", shouhuodizhi);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(goumairen==null||goumairen.equals("")){pmap.put("goumairen", null);}else{pmap.put("goumairen", goumairen);}		if(dingdanzhuangtai==null||dingdanzhuangtai.equals("")){pmap.put("dingdanzhuangtai", null);}else{pmap.put("dingdanzhuangtai", dingdanzhuangtai);}		if(wuliuzhuangtai==null||wuliuzhuangtai.equals("")){pmap.put("wuliuzhuangtai", null);}else{pmap.put("wuliuzhuangtai", wuliuzhuangtai);}		if(wuliudanhao1==null||wuliudanhao1.equals("")){pmap.put("wuliudanhao1", null);}else{pmap.put("wuliudanhao1", wuliudanhao1);}		if(wuliudanhao2==null||wuliudanhao2.equals("")){pmap.put("wuliudanhao2", null);}else{pmap.put("wuliudanhao2", wuliudanhao2);}		if(jilushijian1==null||jilushijian1.equals("")){pmap.put("jilushijian1", null);}else{pmap.put("jilushijian1", jilushijian1);}		if(jilushijian2==null||jilushijian2.equals("")){pmap.put("jilushijian2", null);}else{pmap.put("jilushijian2", jilushijian2);}		if(jiluren==null||jiluren.equals("")){pmap.put("jiluren", null);}else{pmap.put("jiluren", jiluren);}		
		int total=dingdanguanliService.getCount(pmap);
		pageBean.setTotal(total);
		List<Dingdanguanli> list=dingdanguanliService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "dingdanguanlilist";
	}
	
	
	
	@RequestMapping("deleteDingdanguanli.do")
	public String deleteDingdanguanli(int id,HttpServletRequest request){
		dingdanguanliService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:dingdanguanliList.do";
	}
	
	
}
