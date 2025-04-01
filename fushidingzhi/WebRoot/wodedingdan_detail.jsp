<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>我的订单详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  我的订单详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>设计编号：</td><td width='39%'>${wodedingdan.shejibianhao}</td>     <td width='11%'>设计名称：</td><td width='39%'>${wodedingdan.shejimingcheng}</td></tr><tr>     <td width='11%'>模板类型：</td><td width='39%'>${wodedingdan.mobanleixing}</td>     <td width='11%'>价格：</td><td width='39%'>${wodedingdan.jiage}</td></tr><tr>     <td width='11%'>订单数量：</td><td width='39%'>${wodedingdan.dingdanshuliang}</td>     <td width='11%'>订单价格：</td><td width='39%'>${wodedingdan.dingdanjiage}</td></tr><tr>     <td width='11%'>联系电话：</td><td width='39%'>${wodedingdan.lianxidianhua}</td>     <td width='11%'>收货地址：</td><td width='39%'>${wodedingdan.shouhuodizhi}</td></tr><tr>     <td width='11%'>创建时间：</td><td width='39%'>${wodedingdan.chuangjianshijian}</td>     <td width='11%'>购买人：</td><td width='39%'>${wodedingdan.goumairen}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

