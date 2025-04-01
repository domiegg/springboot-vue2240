<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>财务管理查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">财务管理列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="caiwuguanliList2.do" name="myform" method="post">
									查询   财务编号：<input name="caiwubianhao" type="text" id="caiwubianhao" style='border:solid 1px #000000; color:#666666' size="12" />  标题：<input name="biaoti" type="text" id="biaoti" style='border:solid 1px #000000; color:#666666' size="12" /> 月份：<select name='yuefen' id='yuefen' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="一月份">一月份</option><option value="二月份">二月份</option><option value="三月份">三月份</option><option value="四月份">四月份</option><option value="五月份">五月份</option><option value="五月份">五月份</option><option value="六月份">六月份</option><option value="七月份">七月份</option><option value="八月份">八月份</option><option value="九月份">九月份</option><option value="十月份">十月份</option><option value="十一月份">十一月份</option><option value="十二月份">十二月份</option></select> 对账状态：<select name='duizhangzhuangtai' id='duizhangzhuangtai' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><option value="未对账">未对账</option><option value="已核对">已核对</option></select>
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <td align='center'>财务编号</td>    <td align='center'>标题</td>    <td align='center'>月份</td>    <td align='center'>订单数量</td>    <td align='center'>订单总价</td>    <td align='center'>对账状态</td>        <td  width='90' align='center'>文件</td>    <td  width='65' align='center'>记录时间</td>    <td align='center'>记录入</td>    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <td>${u.caiwubianhao}</td>    <td>${u.biaoti}</td>    <td>${u.yuefen}</td>    <td>${u.dingdanshuliang}</td>    <td>${u.dingdanzongjia}</td>    <td>${u.duizhangzhuangtai}</td>        <td width='90' align='center'><a href='${u.wenjian}' target='_blank'>下载</a></td>    <td>${u.jilushijian}</td>    <td>${u.jiluru}</td>    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateCaiwuguanli.do?id=${u.id }">编辑</a>  <a href="deleteCaiwuguanli.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="caiwuguanliDetail.do?id=${u.id }">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="caiwuguanliList2.do?page=1" >首页</a>
             <a href="caiwuguanliList2.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="caiwuguanliList2.do?page=${page.page+1 }">下一页</a>
			<a href="caiwuguanliList2.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
