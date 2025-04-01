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
		<TITLE>修改模板信息</TITLE>
	    
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="mobanxinxi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateMobanxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改模板信息<input type="hidden" name="id" value="${mobanxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">模板编号：</td><td><input name='mobanbianhao' type='text' id='mobanbianhao' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmobanbianhao' /></td></tr>		<tr ><td width="200">模板名称：</td><td><input name='mobanmingcheng' type='text' id='mobanmingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmobanmingcheng' /></td></tr>		<tr ><td width="200">模板类型：</td><td><input name='mobanleixing' type='text' id='mobanleixing' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmobanleixing' /></td></tr>		<tr ><td width="200">模板图片：</td><td><input name='mobantupian' type='text' id='mobantupian' size='50' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('mobantupian')" style='border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelmobantupian' /></td></tr>		<tr ><td width="200">模板说明：</td><td><textarea name='mobanshuoming' cols='50' rows='5' id='mobanshuoming' onblur='checkform()' style='border:solid 1px #000000; color:#666666' ></textarea>&nbsp;*<label id='clabelmobanshuoming' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.mobanbianhao.value='${mobanxinxi.mobanbianhao}';</script>	<script language="javascript">document.form1.mobanmingcheng.value='${mobanxinxi.mobanmingcheng}';</script>	<script language="javascript">document.form1.mobanleixing.value='${mobanxinxi.mobanleixing}';</script>	<script language="javascript">document.form1.mobantupian.value='${mobanxinxi.mobantupian}';</script>	<script language="javascript">document.form1.mobanshuoming.value='${mobanxinxi.mobanshuoming}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var mobanbianhaoobj = document.getElementById("mobanbianhao"); if(mobanbianhaoobj.value==""){document.getElementById("clabelmobanbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入模板编号</font>";return false;}else{document.getElementById("clabelmobanbianhao").innerHTML="  "; } 	var mobanmingchengobj = document.getElementById("mobanmingcheng"); if(mobanmingchengobj.value==""){document.getElementById("clabelmobanmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入模板名称</font>";return false;}else{document.getElementById("clabelmobanmingcheng").innerHTML="  "; } 	var mobanleixingobj = document.getElementById("mobanleixing"); if(mobanleixingobj.value==""){document.getElementById("clabelmobanleixing").innerHTML="&nbsp;&nbsp;<font color=red>请输入模板类型</font>";return false;}else{document.getElementById("clabelmobanleixing").innerHTML="  "; } 	var mobantupianobj = document.getElementById("mobantupian"); if(mobantupianobj.value==""){document.getElementById("clabelmobantupian").innerHTML="&nbsp;&nbsp;<font color=red>请输入模板图片</font>";return false;}else{document.getElementById("clabelmobantupian").innerHTML="  "; } 	var mobanshuomingobj = document.getElementById("mobanshuoming"); if(mobanshuomingobj.value==""){document.getElementById("clabelmobanshuoming").innerHTML="&nbsp;&nbsp;<font color=red>请输入模板说明</font>";return false;}else{document.getElementById("clabelmobanshuoming").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
