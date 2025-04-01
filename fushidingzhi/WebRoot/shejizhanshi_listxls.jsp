<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shejizhanshihsgb" scope="page" class="com.bean.ShejizhanshiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shejizhanshi.xls");
%>
<html>
  <head>
    <title>设计展示</title>
  </head>

  <body >
 <%
			String sql="select * from shejizhanshi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>设计编号</td>    <td align='center'>设计名称</td>    <td align='center'>模板类型</td>    <td align='center'>设计绘图</td>    <td align='center'>设计说明</td>    <td align='center'>设计师</td>    <td align='center'>价格</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shejizhanshihsgb.getAllShejizhanshi(9);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shejibianhao}</td>    <td>${u.shejimingcheng}</td>    <td>${u.mobanleixing}</td>    <td>${u.shejihuitu}</td>    <td>${u.shejishuoming}</td>    <td>${u.shejishi}</td>    <td>${u.jiage}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

