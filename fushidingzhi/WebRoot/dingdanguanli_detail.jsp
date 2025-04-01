<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>订单管理详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>
 
  <body >

  订单管理详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>设计编号：</td><td width='39%'>${dingdanguanli.shejibianhao}</td>
     <td width='11%'>设计名称：</td><td width='39%'>${dingdanguanli.shejimingcheng}</td></tr><tr>
     <td width='11%'>模板类型：</td><td width='39%'>${dingdanguanli.mobanleixing}</td>
     <td width='11%'>订单数量：</td><td width='39%'>${dingdanguanli.dingdanshuliang}</td></tr><tr>
     <td width='11%'>订单价格：</td><td width='39%'>${dingdanguanli.dingdanjiage}</td>
     <td width='11%'>收货地址：</td><td width='39%'>${dingdanguanli.shouhuodizhi}</td></tr><tr>
     <td width='11%'>联系电话：</td><td width='39%'>${dingdanguanli.lianxidianhua}</td>
     <td width='11%'>购买人：</td><td width='39%'>${dingdanguanli.goumairen}</td></tr><tr>
     <td width='11%'>订单状态：</td><td width='39%'>${dingdanguanli.dingdanzhuangtai}</td>
     <td width='11%'>物流状态：</td><td width='39%'>${dingdanguanli.wuliuzhuangtai}</td></tr><tr>
     <td width='11%'>物流单号：</td><td width='39%'>${dingdanguanli.wuliudanhao}</td>
     <td width='11%'>记录时间：</td><td width='39%'>${dingdanguanli.jilushijian}</td></tr><tr>
     <td width='11%'>记录人：</td><td width='39%'>${dingdanguanli.jiluren}</td>
     <td>&nbsp;</td><td>&nbsp;</td></tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

