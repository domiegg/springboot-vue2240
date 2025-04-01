<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="caiwuguanlihsgb" scope="page" class="com.bean.CaiwuguanliBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=caiwuguanli.xls");
%>
<html>
  <head>
    <title>财务管理</title>
  </head>

  <body >
 <%
			String sql="select * from caiwuguanli  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>财务编号</td>    <td align='center'>标题</td>    <td align='center'>月份</td>    <td align='center'>订单数量</td>    <td align='center'>订单总价</td>    <td align='center'>对账状态</td>        <td  width='90' align='center'>文件</td>    <td  width='65' align='center'>记录时间</td>    <td align='center'>记录入</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=caiwuguanlihsgb.getAllCaiwuguanli(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.caiwubianhao}</td>    <td>${u.biaoti}</td>    <td>${u.yuefen}</td>    <td>${u.dingdanshuliang}</td>    <td>${u.dingdanzongjia}</td>    <td>${u.duizhangzhuangtai}</td>        <td width='90' align='center'><a href='${u.wenjian}' target='_blank'>下载</a></td>    <td>${u.jilushijian}</td>    <td>${u.jiluru}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

