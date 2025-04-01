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

import com.entity.Shejishenhe;
import com.server.ShejishenheServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShejishenheController {
	@Resource
	private ShejishenheServer shejishenheService;


   
	@RequestMapping("addShejishenhe.do")
	public String addShejishenhe(HttpServletRequest request,Shejishenhe shejishenhe,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shejishenhe.setAddtime(time.toString().substring(0, 19));
		shejishenheService.add(shejishenhe);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shejishenheList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shejishenheList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShejishenhe.do")
	public String doUpdateShejishenhe(int id,ModelMap map,Shejishenhe shejishenhe){
		shejishenhe=shejishenheService.getById(id);
		map.put("shejishenhe", shejishenhe);
		return "shejishenhe_updt";
	}
	
	
	
	@RequestMapping("doUpdateShejishenhelb.do")
	public String doUpdateShejishenhelb(int id,ModelMap map,Shejishenhe shejishenhe){
		shejishenhe=shejishenheService.getById(id);
		map.put("shejishenhe", shejishenhe);
		return "shejishenhe_updtlb";
	}
	
@RequestMapping("updateShejishenhelb.do")
	public String updateShejishenhelb(int id,ModelMap map,Shejishenhe shejishenhe){
		shejishenheService.updatelb(shejishenhe);
		return "redirect:shejishenheList.do";
	}
	
//	后台详细
	@RequestMapping("shejishenheDetail.do")
	public String shejishenheDetail(int id,ModelMap map,Shejishenhe shejishenhe){
		shejishenhe=shejishenheService.getById(id);
		map.put("shejishenhe", shejishenhe);
		return "shejishenhe_detail";
	}
//	前台详细
	@RequestMapping("sjshDetail.do")
	public String sjshDetail(int id,ModelMap map,Shejishenhe shejishenhe){
		shejishenhe=shejishenheService.getById(id);
		map.put("shejishenhe", shejishenhe);
		return "shejishenhedetail";
	}
//	
	@RequestMapping("updateShejishenhe.do")
	public String updateShejishenhe(int id,ModelMap map,Shejishenhe shejishenhe,HttpServletRequest request,HttpSession session){
		shejishenheService.update(shejishenhe);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shejishenheList.do";
	}

//	分页查询
	@RequestMapping("shejishenheList.do")
	public String shejishenheList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejishenhe shejishenhe, String shejibianhao, String shejimingcheng, String mobanleixing, String shejihuitu, String wenjian, String shejishuoming, String fabushijian1,String fabushijian2, String shejiren, String huifu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(shejihuitu==null||shejihuitu.equals("")){pmap.put("shejihuitu", null);}else{pmap.put("shejihuitu", shejihuitu);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(shejishuoming==null||shejishuoming.equals("")){pmap.put("shejishuoming", null);}else{pmap.put("shejishuoming", shejishuoming);}		if(fabushijian1==null||fabushijian1.equals("")){pmap.put("fabushijian1", null);}else{pmap.put("fabushijian1", fabushijian1);}		if(fabushijian2==null||fabushijian2.equals("")){pmap.put("fabushijian2", null);}else{pmap.put("fabushijian2", fabushijian2);}		if(shejiren==null||shejiren.equals("")){pmap.put("shejiren", null);}else{pmap.put("shejiren", shejiren);}		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}		
		int total=shejishenheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejishenhe> list=shejishenheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejishenhe_list";
	}
	
	@RequestMapping("shejishenheList2.do")
	public String shejishenheList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejishenhe shejishenhe, String shejibianhao, String shejimingcheng, String mobanleixing, String shejihuitu, String wenjian, String shejishuoming, String fabushijian1,String fabushijian2, String shejiren, String huifu, String issh,HttpServletRequest request){
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
		
		pmap.put("shejiren", (String)request.getSession().getAttribute("username"));
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(shejihuitu==null||shejihuitu.equals("")){pmap.put("shejihuitu", null);}else{pmap.put("shejihuitu", shejihuitu);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(shejishuoming==null||shejishuoming.equals("")){pmap.put("shejishuoming", null);}else{pmap.put("shejishuoming", shejishuoming);}		if(fabushijian1==null||fabushijian1.equals("")){pmap.put("fabushijian1", null);}else{pmap.put("fabushijian1", fabushijian1);}		if(fabushijian2==null||fabushijian2.equals("")){pmap.put("fabushijian2", null);}else{pmap.put("fabushijian2", fabushijian2);}		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}		
		
		int total=shejishenheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejishenhe> list=shejishenheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejishenhe_list2";
	}	
	
	@RequestMapping("sjshList.do")
	public String sjshList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejishenhe shejishenhe, String shejibianhao, String shejimingcheng, String mobanleixing, String shejihuitu, String wenjian, String shejishuoming, String fabushijian1,String fabushijian2, String shejiren, String huifu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(shejibianhao==null||shejibianhao.equals("")){pmap.put("shejibianhao", null);}else{pmap.put("shejibianhao", shejibianhao);}		if(shejimingcheng==null||shejimingcheng.equals("")){pmap.put("shejimingcheng", null);}else{pmap.put("shejimingcheng", shejimingcheng);}		if(mobanleixing==null||mobanleixing.equals("")){pmap.put("mobanleixing", null);}else{pmap.put("mobanleixing", mobanleixing);}		if(shejihuitu==null||shejihuitu.equals("")){pmap.put("shejihuitu", null);}else{pmap.put("shejihuitu", shejihuitu);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(shejishuoming==null||shejishuoming.equals("")){pmap.put("shejishuoming", null);}else{pmap.put("shejishuoming", shejishuoming);}		if(fabushijian1==null||fabushijian1.equals("")){pmap.put("fabushijian1", null);}else{pmap.put("fabushijian1", fabushijian1);}		if(fabushijian2==null||fabushijian2.equals("")){pmap.put("fabushijian2", null);}else{pmap.put("fabushijian2", fabushijian2);}		if(shejiren==null||shejiren.equals("")){pmap.put("shejiren", null);}else{pmap.put("shejiren", shejiren);}		if(huifu==null||huifu.equals("")){pmap.put("huifu", null);}else{pmap.put("huifu", huifu);}		
		int total=shejishenheService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejishenhe> list=shejishenheService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejishenhelist";
	}
	
	@RequestMapping("deleteShejishenhe.do")
	public String deleteShejishenhe(int id,HttpServletRequest request){
		shejishenheService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shejishenheList.do";
	}
	
	
}
