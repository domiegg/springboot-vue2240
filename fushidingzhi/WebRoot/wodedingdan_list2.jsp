<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>我的订单查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">我的订单列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="wodedingdanList2.do" name="myform" method="post">
									查询   设计编号：<input name="shejibianhao" type="text" id="shejibianhao" style='border:solid 1px #000000; color:#666666' size="12" />  设计名称：<input name="shejimingcheng" type="text" id="shejimingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  创建时间：<input name="chuangjianshijian1" type="text" id="chuangjianshijian1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />-<input name="chuangjianshijian2" type="text" id="chuangjianshijian2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />  购买人：<input name="goumairen" type="text" id="goumairen" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>设计编号</td>    <td align='center'>设计名称</td>    <td align='center'>模板类型</td>    <td align='center'>价格</td>    <td align='center'>订单数量</td>    <td align='center'>订单价格</td>    <td align='center'>联系电话</td>    <td align='center'>收货地址</td>    <td  width='65' align='center'>创建时间</td>    <td align='center'>购买人</td>    <td  width='80' align='center'>是否支付</td>    <td  width='80' align='center'>是否审核</td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.shejibianhao}</td>    <td>${u.shejimingcheng}</td>    <td>${u.mobanleixing}</td>    <td>${u.jiage}</td>    <td>${u.dingdanshuliang}</td>    <td>${u.dingdanjiage}</td>    <td>${u.lianxidianhua}</td>    <td>${u.shouhuodizhi}</td>    <td>${u.chuangjianshijian}</td>    <td>${u.goumairen}</td>    <td align='center'>${u.goumairen}</td>    <td align='center'>${u.issh} </td>
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateWodedingdan.do?id=${u.id }">编辑</a>  <a href="deleteWodedingdan.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="wodedingdanDetail.do?id=${u.id }">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from wodedingdan where goumairen='"+(String)request.getSession().getAttribute("username")+"'  ";
				if(request.getParameter("shejibianhao")=="" ||request.getParameter("shejibianhao")==null ){}else{String nshejibianhao=new String(request.getParameter("shejibianhao").getBytes("8859_1"));if(nshejibianhao.contains("?")){nshejibianhao=request.getParameter("shejibianhao");}sql=sql+" and shejibianhao like '%"+nshejibianhao+"%'";}if(request.getParameter("shejimingcheng")=="" ||request.getParameter("shejimingcheng")==null ){}else{String nshejimingcheng=new String(request.getParameter("shejimingcheng").getBytes("8859_1"));if(nshejimingcheng.contains("?")){nshejimingcheng=request.getParameter("shejimingcheng");}sql=sql+" and shejimingcheng like '%"+nshejimingcheng+"%'";}if (request.getParameter("chuangjianshijian1")==""  ||request.getParameter("chuangjianshijian1")==null ) {}else{sql=sql+" and chuangjianshijian >= '"+request.getParameter("chuangjianshijian1")+"'";}if (request.getParameter("chuangjianshijian2")==""  ||request.getParameter("chuangjianshijian2")==null ) {}else {sql=sql+" and chuangjianshijian <= '"+request.getParameter("chuangjianshijian2")+"'";}if(request.getParameter("goumairen")=="" ||request.getParameter("goumairen")==null ){}else{String ngoumairen=new String(request.getParameter("goumairen").getBytes("8859_1"));if(ngoumairen.contains("?")){ngoumairen=request.getParameter("goumairen");}sql=sql+" and goumairen like '%"+ngoumairen+"%'";}
			sql+=" order by id desc";
double dingdanjiagez=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						dingdanjiagez=dingdanjiagez+Float.valueOf(RS_result.getString("dingdanjiage")).floatValue();
						
						
			 }
			%>
		共计订单价格:<%=dingdanjiagez%>； 
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="wodedingdanList2.do?page=1" >首页</a>
             <a href="wodedingdanList2.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="wodedingdanList2.do?page=${page.page+1 }">下一页</a>
			<a href="wodedingdanList2.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
