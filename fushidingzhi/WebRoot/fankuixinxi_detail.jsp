<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>反馈信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  反馈信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>反馈编号：</td><td width='39%'>${fankuixinxi.fankuibianhao}</td>     <td width='11%'>标题：</td><td width='39%'>${fankuixinxi.biaoti}</td></tr><tr>     <td width='11%'>反馈内容：</td><td width='39%'>${fankuixinxi.fankuineirong}</td>     <td width='11%'>反馈时间：</td><td width='39%'>${fankuixinxi.fankuishijian}</td></tr><tr>     <td width='11%'>发布人：</td><td width='39%'>${fankuixinxi.faburen}</td>     <td width='11%'>管理员回复：</td><td width='39%'>${fankuixinxi.guanliyuanhuifu}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

