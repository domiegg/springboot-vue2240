<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="mobanxinxihsgb" scope="page" class="com.bean.MobanxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=mobanxinxi.xls");
%>
<html>
  <head>
    <title>ģ����Ϣ</title>
  </head>

  <body >
 <%
			String sql="select * from mobanxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>ģ����</td>    <td align='center'>ģ������</td>    <td align='center'>ģ������</td>    <td  width='90' align='center'>ģ��ͼƬ</td>        
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=mobanxinxihsgb.getAllMobanxinxi(7);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.mobanbianhao}</td>    <td>${u.mobanmingcheng}</td>    <td>${u.mobanleixing}</td>    <td width='90' align='center'><a href='${u.mobantupian}' target='_blank'><img src='${u.mobantupian}' width=88 height=99 border=0 /></a></td>        
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

