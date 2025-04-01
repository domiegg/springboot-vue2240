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

import com.entity.Shejishixinxi;
import com.server.ShejishixinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShejishixinxiController {
	@Resource
	private ShejishixinxiServer shejishixinxiService;


   
	@RequestMapping("addShejishixinxi.do")
	public String addShejishixinxi(HttpServletRequest request,Shejishixinxi shejishixinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shejishixinxi.setAddtime(time.toString().substring(0, 19));
		shejishixinxiService.add(shejishixinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shejishixinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shejishixinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShejishixinxi.do")
	public String doUpdateShejishixinxi(int id,ModelMap map,Shejishixinxi shejishixinxi){
		shejishixinxi=shejishixinxiService.getById(id);
		map.put("shejishixinxi", shejishixinxi);
		return "shejishixinxi_updt";
	}
	
	@RequestMapping("doUpdateShejishixinxi2.do")
	public String doUpdateShejishixinxi2(ModelMap map,Shejishixinxi shejishixinxi,HttpServletRequest request){
		shejishixinxi=shejishixinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("shejishixinxi", shejishixinxi);
		return "shejishixinxi_updt2";
	}
	
@RequestMapping("updateShejishixinxi2.do")
	public String updateShejishixinxi2(int id,ModelMap map,Shejishixinxi shejishixinxi){
		shejishixinxiService.update(shejishixinxi);
		return "redirect:doUpdateShejishixinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("shejishixinxiDetail.do")
	public String shejishixinxiDetail(int id,ModelMap map,Shejishixinxi shejishixinxi){
		shejishixinxi=shejishixinxiService.getById(id);
		map.put("shejishixinxi", shejishixinxi);
		return "shejishixinxi_detail";
	}
//	前台详细
	@RequestMapping("sjsxxDetail.do")
	public String sjsxxDetail(int id,ModelMap map,Shejishixinxi shejishixinxi){
		shejishixinxi=shejishixinxiService.getById(id);
		map.put("shejishixinxi", shejishixinxi);
		return "shejishixinxidetail";
	}
//	
	@RequestMapping("updateShejishixinxi.do")
	public String updateShejishixinxi(int id,ModelMap map,Shejishixinxi shejishixinxi,HttpServletRequest request,HttpSession session){
		shejishixinxiService.update(shejishixinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shejishixinxiList.do";
	}

//	分页查询
	@RequestMapping("shejishixinxiList.do")
	public String shejishixinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejishixinxi shejishixinxi, String yonghuming, String mima, String xingming, String xingbie, String jibie, String shouji, String youxiang, String dizhi, String zhaopian, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(jibie==null||jibie.equals("")){pmap.put("jibie", null);}else{pmap.put("jibie", jibie);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=shejishixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejishixinxi> list=shejishixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejishixinxi_list";
	}
	
	
	
	@RequestMapping("sjsxxList.do")
	public String sjsxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shejishixinxi shejishixinxi, String yonghuming, String mima, String xingming, String xingbie, String jibie, String shouji, String youxiang, String dizhi, String zhaopian, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(jibie==null||jibie.equals("")){pmap.put("jibie", null);}else{pmap.put("jibie", jibie);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=shejishixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shejishixinxi> list=shejishixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shejishixinxilist";
	}
	
	@RequestMapping("deleteShejishixinxi.do")
	public String deleteShejishixinxi(int id,HttpServletRequest request){
		shejishixinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shejishixinxiList.do";
	}
	
	@RequestMapping("quchongShejishixinxi.do")
	public void quchongShejishixinxi(Shejishixinxi shejishixinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yonghuming", shejishixinxi.getYonghuming());
		   System.out.println("yonghuming==="+shejishixinxi.getYonghuming());
		   System.out.println("yonghuming222==="+shejishixinxiService.quchongShejishixinxi(map));
		   JSONObject obj=new JSONObject();
		   if(shejishixinxiService.quchongShejishixinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "用户名可以用！");
				  
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
