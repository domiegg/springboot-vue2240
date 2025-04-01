<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>库存信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  库存信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr> 
     <td width='11%'>设计编号：</td><td width='39%'>${kucunxinxi.shejibianhao}</td>
     <td width='11%'>设计名称：</td><td width='39%'>${kucunxinxi.shejimingcheng}</td></tr><tr>
     <td width='11%'>模板类型：</td><td width='39%'>${kucunxinxi.mobanleixing}</td>
     <td width='11%'>价格：</td><td width='39%'>${kucunxinxi.jiage}</td></tr><tr>
     <td width='11%'>库存数量：</td><td width='39%'>${kucunxinxi.kucunshuliang}</td>
     <td width='11%'>入库日期：</td><td width='39%'>${kucunxinxi.rukuriqi}</td></tr><tr>
     <td width='11%'>修改时间：</td><td width='39%'>${kucunxinxi.xiugaishijian}</td>
     <td width='11%'>修改人：</td><td width='39%'>${kucunxinxi.xiugairen}</td>
     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

