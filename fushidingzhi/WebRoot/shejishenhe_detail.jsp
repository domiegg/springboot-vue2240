<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>设计审核详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  设计审核详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>设计编号：</td><td width='39%'>${shejishenhe.shejibianhao}</td><td  rowspan=6 align=center><a href=${shejishenhe.shejihuitu} target=_blank><img src=${shejishenhe.shejihuitu} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>设计名称：</td><td width='39%'>${shejishenhe.shejimingcheng}</td></tr><tr><td width='11%' height=44>模板类型：</td><td width='39%'>${shejishenhe.mobanleixing}</td></tr><tr><td width='11%' height=44>文件：</td><td width='39%'><a href="${shejishenhe.wenjian}">点此下载</a></td></tr><tr><td width='11%' height=44>发布时间：</td><td width='39%'>${shejishenhe.fabushijian}</td></tr><tr><td width='11%' height=44>设计人：</td><td width='39%'>${shejishenhe.shejiren}</td></tr><tr><td width='11%' height=100  >设计说明：</td><td width='39%' colspan=2 height=100 >${shejishenhe.shejishuoming}</td></tr><tr><td width='11%' height=100  >回复：</td><td width='39%' colspan=2 height=100 >${shejishenhe.huifu}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

