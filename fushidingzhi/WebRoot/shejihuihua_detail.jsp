<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>设计绘画详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  设计绘画详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>设计编号：</td><td width='39%'>${shejihuihua.shejibianhao}</td><td  rowspan=6 align=center><a href=${shejihuihua.shejihuitu} target=_blank><img src=${shejihuihua.shejihuitu} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>设计名称：</td><td width='39%'>${shejihuihua.shejimingcheng}</td></tr><tr><td width='11%' height=44>模板类型：</td><td width='39%'>${shejihuihua.mobanleixing}</td></tr><tr><td width='11%' height=44>文件：</td><td width='39%'><a href="${shejihuihua.wenjian}">点此下载</a></td></tr><tr><td width='11%' height=44>发布时间：</td><td width='39%'>${shejihuihua.fabushijian}</td></tr><tr><td width='11%' height=44>设计师：</td><td width='39%'>${shejihuihua.shejishi}</td></tr><tr><td width='11%' height=100  >设计说明：</td><td width='39%' colspan=2 height=100 >${shejihuihua.shejishuoming}</td></tr><tr><td width='11%' height=100  >回复：</td><td width='39%' colspan=2 height=100 >${shejihuihua.huifu}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

