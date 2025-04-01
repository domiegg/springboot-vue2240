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

import com.entity.Kefuxinxi;
import com.server.KefuxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class KefuxinxiController {
	@Resource
	private KefuxinxiServer kefuxinxiService;


   
	@RequestMapping("addKefuxinxi.do")
	public String addKefuxinxi(HttpServletRequest request,Kefuxinxi kefuxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		kefuxinxi.setAddtime(time.toString().substring(0, 19));
		kefuxinxiService.add(kefuxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "kefuxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:kefuxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateKefuxinxi.do")
	public String doUpdateKefuxinxi(int id,ModelMap map,Kefuxinxi kefuxinxi){
		kefuxinxi=kefuxinxiService.getById(id);
		map.put("kefuxinxi", kefuxinxi);
		return "kefuxinxi_updt";
	}
	
	@RequestMapping("doUpdateKefuxinxi2.do")
	public String doUpdateKefuxinxi2(ModelMap map,Kefuxinxi kefuxinxi,HttpServletRequest request){
		kefuxinxi=kefuxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("kefuxinxi", kefuxinxi);
		return "kefuxinxi_updt2";
	}
	
@RequestMapping("updateKefuxinxi2.do")
	public String updateKefuxinxi2(int id,ModelMap map,Kefuxinxi kefuxinxi){
		kefuxinxiService.update(kefuxinxi);
		return "redirect:doUpdateKefuxinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("kefuxinxiDetail.do")
	public String kefuxinxiDetail(int id,ModelMap map,Kefuxinxi kefuxinxi){
		kefuxinxi=kefuxinxiService.getById(id);
		map.put("kefuxinxi", kefuxinxi);
		return "kefuxinxi_detail";
	}
//	前台详细
	@RequestMapping("kfxxDetail.do")
	public String kfxxDetail(int id,ModelMap map,Kefuxinxi kefuxinxi){
		kefuxinxi=kefuxinxiService.getById(id);
		map.put("kefuxinxi", kefuxinxi);
		return "kefuxinxidetail";
	}
//	
	@RequestMapping("updateKefuxinxi.do")
	public String updateKefuxinxi(int id,ModelMap map,Kefuxinxi kefuxinxi,HttpServletRequest request,HttpSession session){
		kefuxinxiService.update(kefuxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:kefuxinxiList.do";
	}

//	分页查询
	@RequestMapping("kefuxinxiList.do")
	public String kefuxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kefuxinxi kefuxinxi, String kefubianhao, String mima, String xingming, String xingbie, String shouji, String youxiang, String zhaopian, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(kefubianhao==null||kefubianhao.equals("")){pmap.put("kefubianhao", null);}else{pmap.put("kefubianhao", kefubianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=kefuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kefuxinxi> list=kefuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kefuxinxi_list";
	}
	
	
	
	@RequestMapping("kfxxList.do")
	public String kfxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kefuxinxi kefuxinxi, String kefubianhao, String mima, String xingming, String xingbie, String shouji, String youxiang, String zhaopian, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(kefubianhao==null||kefubianhao.equals("")){pmap.put("kefubianhao", null);}else{pmap.put("kefubianhao", kefubianhao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=kefuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kefuxinxi> list=kefuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kefuxinxilist";
	}
	
	@RequestMapping("deleteKefuxinxi.do")
	public String deleteKefuxinxi(int id,HttpServletRequest request){
		kefuxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:kefuxinxiList.do";
	}
	
	@RequestMapping("quchongKefuxinxi.do")
	public void quchongKefuxinxi(Kefuxinxi kefuxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("kefubianhao", kefuxinxi.getKefubianhao());
		   System.out.println("kefubianhao==="+kefuxinxi.getKefubianhao());
		   System.out.println("kefubianhao222==="+kefuxinxiService.quchongKefuxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(kefuxinxiService.quchongKefuxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "客服编号可以用！");
				  
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
