<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="kucunxinxihsgb" scope="page" class="com.bean.KucunxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=kucunxinxi.xls");
%>
<html>
  <head>
    <title>库存信息</title>
  </head>

  <body >
 <%
			String sql="select * from kucunxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">   
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>设计编号</td>
    <td align='center'>设计名称</td>
    <td align='center'>模板类型</td>
    <td align='center'>价格</td>
    <td align='center'>库存数量</td>
    <td  width='65' align='center'>入库日期</td>
    <td  width='65' align='center'>修改时间</td>
    <td align='center'>修改人</td>
    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=kucunxinxihsgb.getAllKucunxinxi(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shejibianhao}</td>
    <td>${u.shejimingcheng}</td>
    <td>${u.mobanleixing}</td>
    <td>${u.jiage}</td>
    <td>${u.kucunshuliang}</td>
    <td>${u.rukuriqi}</td>
    <td>${u.xiugaishijian}</td>
    <td>${u.xiugairen}</td>
    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

