<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="kucunxinxihsgb" scope="page" class="com.bean.KucunxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=kucunxinxi.xls");
%>
<html>
  <head>
    <title>�����Ϣ</title>
  </head>

  <body >
 <%
			String sql="select * from kucunxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">   
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>��Ʊ��</td>
    <td align='center'>�������</td>
    <td align='center'>ģ������</td>
    <td align='center'>�۸�</td>
    <td align='center'>�������</td>
    <td  width='65' align='center'>�������</td>
    <td  width='65' align='center'>�޸�ʱ��</td>
    <td align='center'>�޸���</td>
    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
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

