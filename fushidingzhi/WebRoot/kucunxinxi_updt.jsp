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
		<TITLE>修改库存信息</TITLE>
	    
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
	document.location.href="kucunxinxi_add.jsp?id=<%=id%>";
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
			<form action="updateKucunxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改库存信息<input type="hidden" name="id" value="${kucunxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">设计编号：</td><td><input name='shejibianhao' type='text' id='shejibianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">设计名称：</td><td><input name='shejimingcheng' type='text' id='shejimingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">模板类型：</td><td><input name='mobanleixing' type='text' id='mobanleixing' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr>
		<tr ><td width="200">库存数量：</td><td><input name='kucunshuliang' type='text' id='kucunshuliang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelkucunshuliang' /></td></tr>
		<tr ><td width="200">入库日期：</td><td><input name='rukuriqi' type='text' id='rukuriqi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelrukuriqi' /></td></tr>
		<tr ><td width="200">修改时间：</td><td><input name='xiugaishijian' type='text' id='xiugaishijian' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelxiugaishijian' /></td></tr>
		<tr ><td width="200">修改人：</td><td><input name='xiugairen' type='text' id='xiugairen' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabelxiugairen' /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.shejibianhao.value='${kucunxinxi.shejibianhao}';</script>
	<script language="javascript">document.form1.shejimingcheng.value='${kucunxinxi.shejimingcheng}';</script>
	<script language="javascript">document.form1.mobanleixing.value='${kucunxinxi.mobanleixing}';</script>
	<script language="javascript">document.form1.jiage.value='${kucunxinxi.jiage}';</script>
	<script language="javascript">document.form1.kucunshuliang.value='${kucunxinxi.kucunshuliang}';</script>
	<script language="javascript">document.form1.rukuriqi.value='${kucunxinxi.rukuriqi}';</script>
	<script language="javascript">document.form1.xiugaishijian.value='${kucunxinxi.xiugaishijian}';</script>
	<script language="javascript">document.form1.xiugairen.value='${kucunxinxi.xiugairen}';</script>
	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var kucunshuliangobj = document.getElementById("kucunshuliang"); if(kucunshuliangobj.value==""){document.getElementById("clabelkucunshuliang").innerHTML="&nbsp;&nbsp;<font color=red>请输入库存数量</font>";return false;}else{document.getElementById("clabelkucunshuliang").innerHTML="  "; } 
	
    var rukuriqiobj = document.getElementById("rukuriqi"); if(rukuriqiobj.value==""){document.getElementById("clabelrukuriqi").innerHTML="&nbsp;&nbsp;<font color=red>请输入入库日期</font>";return false;}else{document.getElementById("clabelrukuriqi").innerHTML="  "; } 
	var xiugaishijianobj = document.getElementById("xiugaishijian"); if(xiugaishijianobj.value==""){document.getElementById("clabelxiugaishijian").innerHTML="&nbsp;&nbsp;<font color=red>请输入修改时间</font>";return false;}else{document.getElementById("clabelxiugaishijian").innerHTML="  "; } 
	var xiugairenobj = document.getElementById("xiugairen"); if(xiugairenobj.value==""){document.getElementById("clabelxiugairen").innerHTML="&nbsp;&nbsp;<font color=red>请输入修改人</font>";return false;}else{document.getElementById("clabelxiugairen").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  
