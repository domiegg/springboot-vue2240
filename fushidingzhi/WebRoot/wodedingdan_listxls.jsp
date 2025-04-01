<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="wodedingdanhsgb" scope="page" class="com.bean.WodedingdanBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=wodedingdan.xls");
%>
<html>
  <head>
    <title>我的订单</title>
  </head>

  <body >
 <%
			String sql="select * from wodedingdan  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>设计编号</td>    <td align='center'>设计名称</td>    <td align='center'>模板类型</td>    <td align='center'>价格</td>    <td align='center'>订单数量</td>    <td align='center'>订单价格</td>    <td align='center'>联系电话</td>    <td align='center'>收货地址</td>    <td  width='65' align='center'>创建时间</td>    <td align='center'>购买人</td>    <td  width='80' align='center'>是否支付</td>    <td  width='80' align='center'>是否审核</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=wodedingdanhsgb.getAllWodedingdan(14);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shejibianhao}</td>    <td>${u.shejimingcheng}</td>    <td>${u.mobanleixing}</td>    <td>${u.jiage}</td>    <td>${u.dingdanshuliang}</td>    <td>${u.dingdanjiage}</td>    <td>${u.lianxidianhua}</td>    <td>${u.shouhuodizhi}</td>    <td>${u.chuangjianshijian}</td>    <td>${u.goumairen}</td>    <td align='center'>${u.goumairen}</td>    <td align='center'>${u.issh} <input type="button" value="审核" onclick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=wodedingdan'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

