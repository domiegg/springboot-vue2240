<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shejishenhehsgb" scope="page" class="com.bean.ShejishenheBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shejishenhe.xls");
%>
<html>
  <head>
    <title>设计审核</title>
  </head>

  <body >
 <%
			String sql="select * from shejishenhe  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>设计编号</td>    <td align='center'>设计名称</td>    <td align='center'>模板类型</td>    <td  width='90' align='center'>设计绘图</td>    <td  width='90' align='center'>文件</td>        <td  width='65' align='center'>发布时间</td>    <td align='center'>设计人</td>        <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shejishenhehsgb.getAllShejishenhe(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shejibianhao}</td>    <td>${u.shejimingcheng}</td>    <td>${u.mobanleixing}</td>    <td width='90' align='center'><a href='${u.shejihuitu}' target='_blank'><img src='${u.shejihuitu}' width=88 height=99 border=0 /></a></td>    <td width='90' align='center'><a href='${u.wenjian}' target='_blank'>下载</a></td>        <td>${u.fabushijian}</td>    <td>${u.shejiren}</td>        <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=shejishenhe'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

