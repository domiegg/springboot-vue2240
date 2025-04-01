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

import com.entity.Fankuixinxi;
import com.server.FankuixinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class FankuixinxiController {
	@Resource
	private FankuixinxiServer fankuixinxiService;


   
	@RequestMapping("addFankuixinxi.do")
	public String addFankuixinxi(HttpServletRequest request,Fankuixinxi fankuixinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		fankuixinxi.setAddtime(time.toString().substring(0, 19));
		fankuixinxiService.add(fankuixinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "fankuixinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:fankuixinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateFankuixinxi.do")
	public String doUpdateFankuixinxi(int id,ModelMap map,Fankuixinxi fankuixinxi){
		fankuixinxi=fankuixinxiService.getById(id);
		map.put("fankuixinxi", fankuixinxi);
		return "fankuixinxi_updt";
	}
	
	
	
	@RequestMapping("doUpdateFankuixinxilb.do")
	public String doUpdateFankuixinxilb(int id,ModelMap map,Fankuixinxi fankuixinxi){
		fankuixinxi=fankuixinxiService.getById(id);
		map.put("fankuixinxi", fankuixinxi);
		return "fankuixinxi_updtlb";
	}
	
@RequestMapping("updateFankuixinxilb.do")
	public String updateFankuixinxilb(int id,ModelMap map,Fankuixinxi fankuixinxi){
		fankuixinxiService.updatelb(fankuixinxi);
		return "redirect:fankuixinxiList.do";
	}
	
//	后台详细
	@RequestMapping("fankuixinxiDetail.do")
	public String fankuixinxiDetail(int id,ModelMap map,Fankuixinxi fankuixinxi){
		fankuixinxi=fankuixinxiService.getById(id);
		map.put("fankuixinxi", fankuixinxi);
		return "fankuixinxi_detail";
	}
//	前台详细
	@RequestMapping("fkxxDetail.do")
	public String fkxxDetail(int id,ModelMap map,Fankuixinxi fankuixinxi){
		fankuixinxi=fankuixinxiService.getById(id);
		map.put("fankuixinxi", fankuixinxi);
		return "fankuixinxidetail";
	}
//	
	@RequestMapping("updateFankuixinxi.do")
	public String updateFankuixinxi(int id,ModelMap map,Fankuixinxi fankuixinxi,HttpServletRequest request,HttpSession session){
		fankuixinxiService.update(fankuixinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:fankuixinxiList.do";
	}

//	分页查询
	@RequestMapping("fankuixinxiList.do")
	public String fankuixinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fankuixinxi fankuixinxi, String fankuibianhao, String biaoti, String fankuineirong, String fankuishijian1,String fankuishijian2, String faburen, String guanliyuanhuifu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(fankuibianhao==null||fankuibianhao.equals("")){pmap.put("fankuibianhao", null);}else{pmap.put("fankuibianhao", fankuibianhao);}		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(fankuineirong==null||fankuineirong.equals("")){pmap.put("fankuineirong", null);}else{pmap.put("fankuineirong", fankuineirong);}		if(fankuishijian1==null||fankuishijian1.equals("")){pmap.put("fankuishijian1", null);}else{pmap.put("fankuishijian1", fankuishijian1);}		if(fankuishijian2==null||fankuishijian2.equals("")){pmap.put("fankuishijian2", null);}else{pmap.put("fankuishijian2", fankuishijian2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		if(guanliyuanhuifu==null||guanliyuanhuifu.equals("")){pmap.put("guanliyuanhuifu", null);}else{pmap.put("guanliyuanhuifu", guanliyuanhuifu);}		
		int total=fankuixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fankuixinxi> list=fankuixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fankuixinxi_list";
	}
	
	@RequestMapping("fankuixinxiList2.do")
	public String fankuixinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fankuixinxi fankuixinxi, String fankuibianhao, String biaoti, String fankuineirong, String fankuishijian1,String fankuishijian2, String faburen, String guanliyuanhuifu, String issh,HttpServletRequest request){
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
		
		pmap.put("faburen", (String)request.getSession().getAttribute("username"));
		if(fankuibianhao==null||fankuibianhao.equals("")){pmap.put("fankuibianhao", null);}else{pmap.put("fankuibianhao", fankuibianhao);}		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(fankuineirong==null||fankuineirong.equals("")){pmap.put("fankuineirong", null);}else{pmap.put("fankuineirong", fankuineirong);}		if(fankuishijian1==null||fankuishijian1.equals("")){pmap.put("fankuishijian1", null);}else{pmap.put("fankuishijian1", fankuishijian1);}		if(fankuishijian2==null||fankuishijian2.equals("")){pmap.put("fankuishijian2", null);}else{pmap.put("fankuishijian2", fankuishijian2);}		if(guanliyuanhuifu==null||guanliyuanhuifu.equals("")){pmap.put("guanliyuanhuifu", null);}else{pmap.put("guanliyuanhuifu", guanliyuanhuifu);}		
		
		int total=fankuixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fankuixinxi> list=fankuixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fankuixinxi_list2";
	}	
	
	@RequestMapping("fkxxList.do")
	public String fkxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Fankuixinxi fankuixinxi, String fankuibianhao, String biaoti, String fankuineirong, String fankuishijian1,String fankuishijian2, String faburen, String guanliyuanhuifu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(fankuibianhao==null||fankuibianhao.equals("")){pmap.put("fankuibianhao", null);}else{pmap.put("fankuibianhao", fankuibianhao);}		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(fankuineirong==null||fankuineirong.equals("")){pmap.put("fankuineirong", null);}else{pmap.put("fankuineirong", fankuineirong);}		if(fankuishijian1==null||fankuishijian1.equals("")){pmap.put("fankuishijian1", null);}else{pmap.put("fankuishijian1", fankuishijian1);}		if(fankuishijian2==null||fankuishijian2.equals("")){pmap.put("fankuishijian2", null);}else{pmap.put("fankuishijian2", fankuishijian2);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		if(guanliyuanhuifu==null||guanliyuanhuifu.equals("")){pmap.put("guanliyuanhuifu", null);}else{pmap.put("guanliyuanhuifu", guanliyuanhuifu);}		
		int total=fankuixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Fankuixinxi> list=fankuixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "fankuixinxilist";
	}
	
	@RequestMapping("deleteFankuixinxi.do")
	public String deleteFankuixinxi(int id,HttpServletRequest request){
		fankuixinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:fankuixinxiList.do";
	}
	
	
}
