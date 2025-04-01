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

import com.entity.Shejihuihua;
import com.server.ShejihuihuaServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShejihuihuaController {
	@Resource
	private ShejihuihuaServer shejihuihuaService;


   
	@RequestMapping("addShejihuihua.do")
	public String addShejihuihua(HttpServletRequest request,Shejihuihua shejihuihua,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shejihuihua.setAddtime(time.toString().substring(0, 19));
		shejihuihuaService.add(shejihuihua);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shejihuihuaList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shejihuihuaList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShejihuihua.do")
	public String doUpdateShejihuihua(int id,ModelMap map,Shejihuihua shejihuihua){
		shejihuihua=shejihuihuaService.getById(id);
		map.put("shejihuihua", shejihuihua);
		return "shejihuihua_updt";
	}
	
	
	
	@RequestMapping("doUpdateShejihuihualb.do")
	public String doUpdateShejihuihualb(int id,ModelMap map,Shejihuihua shejihuihua){
		shejihuihua=shejihuihuaService.getById(id);
		map.put("shejihuihua", shejihuihua);
		return "shejihuihua_updtlb";
	}
	
@RequestMapping("updateShejihuihualb.do")
	public String updateShejihuihualb(int id,ModelMap map,Shejihuihua shejihuihua){
		shejihuihuaService.updatelb(shejihuihua);
		return "redirect:shejihuihuaList.do";
	}
	
//	后台详细
	@RequestMapping("shejihuihuaDetail.do")
	public String shejihuihuaDetail(int id,ModelMap map,Shejihuihua shejihuihua){
		shejihuihua=shejihuihuaService.getById(id);
		map.put("shejihuihua", shejihuihua);
		return "shejihuihua_detail";
	}
//	前台详细
	@RequestMapping("sjhhDetail.do")
	public String sjhhDetail(int id,ModelMap map,Shejihuihua shejihuihua){
		shejihuihua=shejihuihuaService.getById(id);
		map.put("shejihuihua", shejihuihua);
		return "shejihuihuadetail";
	}
//	
	@RequestMapping("updateShejihuihua.do")
	public String updateShejihuihua(int id,ModelMap map,Shejihuihua shejihuihua,HttpServletRequest request,HttpSession session){
		shejihuihuaService.update(shejihuihua);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shejihuihuaList.do";
	}

//	分页查询
	@RequestMapping("shejihuihuaList.do")
	public String shejihuihuaList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejihuihua shejihuihua, String shejibianhao, String shejimingcheng, String mobanleixing, String shejihuitu, String wenjian, String shejishuoming, String fabushijian1,String fabushijian2, String shejishi, String huifu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(shejihuitu==null||shejihuitu.equals("")){pmap.put("shejihuitu", null);}else{pmap.put("shejihuitu", shejihuitu);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(shejishuoming==null||shejishuoming.equals("")){pmap.put("shejishuoming", null);}else{pmap.put("shejishuoming", shejishuoming);}		if(fabushijian1==null||fabushijian1.equals("")){pmap.put("fabushijian1", null);}else{pmap.put("fabushijian1", fabushijian1);}		if(fabushijian2==null||fabushijian2.equals("")){pmap.put("fabushijian2", null);}else{pmap.put("fabushijian2", fabushijian2);}		if(shejishi==null||shejishi.equals("")){pmap.put("shejishi", null);}else{pmap.put("shejishi", shejishi);}		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}		
		int total=shejihuihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejihuihua> list=shejihuihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejihuihua_list";
	}
	
	@RequestMapping("shejihuihuaList2.do")
	public String shejihuihuaList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejihuihua shejihuihua, String shejibianhao, String shejimingcheng, String mobanleixing, String shejihuitu, String wenjian, String shejishuoming, String fabushijian1,String fabushijian2, String shejishi, String huifu, String issh,HttpServletRequest request){
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
		
		pmap.put("shejishi", (String)request.getSession().getAttribute("username"));
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(shejihuitu==null||shejihuitu.equals("")){pmap.put("shejihuitu", null);}else{pmap.put("shejihuitu", shejihuitu);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(shejishuoming==null||shejishuoming.equals("")){pmap.put("shejishuoming", null);}else{pmap.put("shejishuoming", shejishuoming);}		if(fabushijian1==null||fabushijian1.equals("")){pmap.put("fabushijian1", null);}else{pmap.put("fabushijian1", fabushijian1);}		if(fabushijian2==null||fabushijian2.equals("")){pmap.put("fabushijian2", null);}else{pmap.put("fabushijian2", fabushijian2);}		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}		
		
		int total=shejihuihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejihuihua> list=shejihuihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejihuihua_list2";
	}	
	@RequestMapping("shejihuihuaList3.do")
	public String shejihuihuaList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejihuihua shejihuihua, String shejibianhao, String shejimingcheng, String mobanleixing, String shejihuitu, String wenjian, String shejishuoming, String fabushijian1,String fabushijian2, String shejishi, String huifu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}
		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}
		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}
		if(shejihuitu==null||shejihuitu.equals("")){pmap.put("shejihuitu", null);}else{pmap.put("shejihuitu", shejihuitu);}
		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}
		if(shejishuoming==null||shejishuoming.equals("")){pmap.put("shejishuoming", null);}else{pmap.put("shejishuoming", shejishuoming);}
		if(fabushijian1==null||fabushijian1.equals("")){pmap.put("fabushijian1", null);}else{pmap.put("fabushijian1", fabushijian1);}
		if(fabushijian2==null||fabushijian2.equals("")){pmap.put("fabushijian2", null);}else{pmap.put("fabushijian2", fabushijian2);}
		if(shejishi==null||shejishi.equals("")){pmap.put("shejishi", null);}else{pmap.put("shejishi", shejishi);}
		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
		
		int total=shejihuihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejihuihua> list=shejihuihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejihuihua_list3";
	}
	
	@RequestMapping("shejihuihuaList4.do")
	public String shejihuihuaList4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejihuihua shejihuihua, String shejibianhao, String shejimingcheng, String mobanleixing, String shejihuitu, String wenjian, String shejishuoming, String fabushijian1,String fabushijian2, String shejishi, String huifu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}
		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}
		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}
		if(shejihuitu==null||shejihuitu.equals("")){pmap.put("shejihuitu", null);}else{pmap.put("shejihuitu", shejihuitu);}
		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}
		if(shejishuoming==null||shejishuoming.equals("")){pmap.put("shejishuoming", null);}else{pmap.put("shejishuoming", shejishuoming);}
		if(fabushijian1==null||fabushijian1.equals("")){pmap.put("fabushijian1", null);}else{pmap.put("fabushijian1", fabushijian1);}
		if(fabushijian2==null||fabushijian2.equals("")){pmap.put("fabushijian2", null);}else{pmap.put("fabushijian2", fabushijian2);}
		if(shejishi==null||shejishi.equals("")){pmap.put("shejishi", null);}else{pmap.put("shejishi", shejishi);}
		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}
		
		int total=shejihuihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejihuihua> list=shejihuihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejihuihua_list4";
	}
	
	@RequestMapping("sjhhList.do")
	public String sjhhList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejihuihua shejihuihua, String shejibianhao, String shejimingcheng, String mobanleixing, String shejihuitu, String wenjian, String shejishuoming, String fabushijian1,String fabushijian2, String shejishi, String huifu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(shejihuitu==null||shejihuitu.equals("")){pmap.put("shejihuitu", null);}else{pmap.put("shejihuitu", shejihuitu);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(shejishuoming==null||shejishuoming.equals("")){pmap.put("shejishuoming", null);}else{pmap.put("shejishuoming", shejishuoming);}		if(fabushijian1==null||fabushijian1.equals("")){pmap.put("fabushijian1", null);}else{pmap.put("fabushijian1", fabushijian1);}		if(fabushijian2==null||fabushijian2.equals("")){pmap.put("fabushijian2", null);}else{pmap.put("fabushijian2", fabushijian2);}		if(shejishi==null||shejishi.equals("")){pmap.put("shejishi", null);}else{pmap.put("shejishi", shejishi);}		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}		
		int total=shejihuihuaService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejihuihua> list=shejihuihuaService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejihuihualist";
	}
	
	@RequestMapping("deleteShejihuihua.do")
	public String deleteShejihuihua(int id,HttpServletRequest request){
		shejihuihuaService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shejihuihuaList.do";
	}
	
	
}
