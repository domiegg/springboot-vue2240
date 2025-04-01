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
		<TITLE>修改设计审核</TITLE>
	    
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
	document.location.href="shejishenhe_add.jsp?id=<%=id%>";
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
			<form action="updateShejishenhe.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改设计审核<input type="hidden" name="id" value="${shejishenhe.id}" /></td>
						</tr>
						<tr ><td width="200">设计编号：</td><td><input name='shejibianhao' type='text' id='shejibianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">设计名称：</td><td><input name='shejimingcheng' type='text' id='shejimingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelshejimingcheng' /></td></tr>		<tr ><td width="200">模板类型：</td><td><select name='mobanleixing' id='mobanleixing' style=' height:19px; border:solid 1px #000000; color:#666666'><%=connDbBean.hsggetoption("mobanxinxi","mobanleixing")%></select>&nbsp;*<label id='clabelmobanleixing' /></td></tr>		<tr ><td width="200">设计绘图：</td><td><input name='shejihuitu' type='text' id='shejihuitu' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('shejihuitu')" style='border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">文件：</td><td><input name='wenjian' type='text' id='wenjian' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('wenjian')" style='border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">设计说明：</td><td><textarea name='shejishuoming' cols='50' rows='5' id='shejishuoming' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		<tr ><td width="200">发布时间：</td><td><input name='fabushijian' type='text' id='fabushijian' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelfabushijian' /></td></tr>		<tr ><td width="200">设计人：</td><td><input name='shejiren' type='text' id='shejiren' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabelshejiren' /></td></tr>		<tr style='display:none'><td width="200">回复：</td><td><textarea name='huifu' cols='50' rows='5' id='huifu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.shejibianhao.value='${shejishenhe.shejibianhao}';</script>	<script language="javascript">document.form1.shejimingcheng.value='${shejishenhe.shejimingcheng}';</script>	<script language="javascript">document.form1.mobanleixing.value='${shejishenhe.mobanleixing}';</script>	<script language="javascript">document.form1.shejihuitu.value='${shejishenhe.shejihuitu}';</script>	<script language="javascript">document.form1.wenjian.value='${shejishenhe.wenjian}';</script>	<script language="javascript">document.form1.shejishuoming.value='${shejishenhe.shejishuoming}';</script>	<script language="javascript">document.form1.fabushijian.value='${shejishenhe.fabushijian}';</script>	<script language="javascript">document.form1.shejiren.value='${shejishenhe.shejiren}';</script>	<script language="javascript">document.form1.huifu.value='${shejishenhe.huifu}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var shejimingchengobj = document.getElementById("shejimingcheng"); if(shejimingchengobj.value==""){document.getElementById("clabelshejimingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入设计名称</font>";return false;}else{document.getElementById("clabelshejimingcheng").innerHTML="  "; } 	var mobanleixingobj = document.getElementById("mobanleixing"); if(mobanleixingobj.value==""){document.getElementById("clabelmobanleixing").innerHTML="&nbsp;&nbsp;<font color=red>请输入模板类型</font>";return false;}else{document.getElementById("clabelmobanleixing").innerHTML="  "; } 	var fabushijianobj = document.getElementById("fabushijian"); if(fabushijianobj.value==""){document.getElementById("clabelfabushijian").innerHTML="&nbsp;&nbsp;<font color=red>请输入发布时间</font>";return false;}else{document.getElementById("clabelfabushijian").innerHTML="  "; } 	var shejirenobj = document.getElementById("shejiren"); if(shejirenobj.value==""){document.getElementById("clabelshejiren").innerHTML="&nbsp;&nbsp;<font color=red>请输入设计人</font>";return false;}else{document.getElementById("clabelshejiren").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
