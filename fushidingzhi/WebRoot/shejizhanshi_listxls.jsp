<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shejizhanshihsgb" scope="page" class="com.bean.ShejizhanshiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shejizhanshi.xls");
%>
<html>
  <head>
    <title>���չʾ</title>
  </head>

  <body >
 <%
			String sql="select * from shejizhanshi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>��Ʊ��</td>    <td align='center'>�������</td>    <td align='center'>ģ������</td>    <td align='center'>��ƻ�ͼ</td>    <td align='center'>���˵��</td>    <td align='center'>���ʦ</td>    <td align='center'>�۸�</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
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

