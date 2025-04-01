<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>财务管理详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  财务管理详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>财务编号：</td><td width='39%'>${caiwuguanli.caiwubianhao}</td>     <td width='11%'>标题：</td><td width='39%'>${caiwuguanli.biaoti}</td></tr><tr>     <td width='11%'>月份：</td><td width='39%'>${caiwuguanli.yuefen}</td>     <td width='11%'>订单数量：</td><td width='39%'>${caiwuguanli.dingdanshuliang}</td></tr><tr>     <td width='11%'>订单总价：</td><td width='39%'>${caiwuguanli.dingdanzongjia}</td>     <td width='11%'>对账状态：</td><td width='39%'>${caiwuguanli.duizhangzhuangtai}</td></tr><tr>     <td width='11%'>备注：</td><td width='39%'>${caiwuguanli.beizhu}</td>     <td width='11%'>文件：</td><td width='39%'><a href="${caiwuguanli.wenjian}">点此下载</a></td></tr><tr>     <td width='11%'>记录时间：</td><td width='39%'>${caiwuguanli.jilushijian}</td>     <td width='11%'>记录入：</td><td width='39%'>${caiwuguanli.jiluru}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

