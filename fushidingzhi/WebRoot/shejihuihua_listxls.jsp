<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shejihuihuahsgb" scope="page" class="com.bean.ShejihuihuaBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shejihuihua.xls");
%>
<html>
  <head>
    <title>��ƻ滭</title>
  </head>

  <body >
 <%
			String sql="select * from shejihuihua  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>��Ʊ��</td>    <td align='center'>�������</td>    <td align='center'>ģ������</td>    <td  width='90' align='center'>��ƻ�ͼ</td>    <td  width='90' align='center'>�ļ�</td>        <td  width='65' align='center'>����ʱ��</td>    <td align='center'>���ʦ</td>        <td  width='80' align='center'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=shejihuihuahsgb.getAllShejihuihua(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shejibianhao}</td>    <td>${u.shejimingcheng}</td>    <td>${u.mobanleixing}</td>    <td width='90' align='center'><a href='${u.shejihuitu}' target='_blank'><img src='${u.shejihuitu}' width=88 height=99 border=0 /></a></td>    <td width='90' align='center'><a href='${u.wenjian}' target='_blank'>����</a></td>        <td>${u.fabushijian}</td>    <td>${u.shejishi}</td>        <td align='center'>${u.issh} <input type="button" value="���" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=shejihuihua'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

