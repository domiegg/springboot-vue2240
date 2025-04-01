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
		<TITLE>添加我的订单</TITLE>
	    

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
	document.location.href="wodedingdan_add.jsp?id=<%=id%>";
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
			<form action="addWodedingdan.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加我的订单</td>
						</tr>
						<tr ><td width="200">设计编号：</td><td><input name='shejibianhao' type='text' id='shejibianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.shejibianhao.value='<%=connDbBean.readzd("shejizhanshi","shejibianhao","id",request.getParameter("id"))%>';document.form1.shejibianhao.setAttribute("readOnly",'true');</script>		<tr ><td width="200">设计名称：</td><td><input name='shejimingcheng' type='text' id='shejimingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.shejimingcheng.value='<%=connDbBean.readzd("shejizhanshi","shejimingcheng","id",request.getParameter("id"))%>';document.form1.shejimingcheng.setAttribute("readOnly",'true');</script>		<tr ><td width="200">模板类型：</td><td><input name='mobanleixing' type='text' id='mobanleixing' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.mobanleixing.value='<%=connDbBean.readzd("shejizhanshi","mobanleixing","id",request.getParameter("id"))%>';document.form1.mobanleixing.setAttribute("readOnly",'true');</script>		<tr ><td width="200">价格：</td><td><input name='jiage' type='text' id='jiage' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.jiage.value='<%=connDbBean.readzd("shejizhanshi","jiage","id",request.getParameter("id"))%>';document.form1.jiage.setAttribute("readOnly",'true');</script>		<tr ><td width="200">订单数量：</td><td><input name='dingdanshuliang' type='text' id='dingdanshuliang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabeldingdanshuliang' /></td></tr>		<tr ><td width="200">订单价格：</td><td><input name='dingdanjiage' type='text' id='dingdanjiage' value='' onblur='' style='border:solid 1px #000000; color:#666666' readonly='readonly' /> 此项不必填写，系统自动计算</td></tr>		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabellianxidianhua' /></td></tr>		<tr ><td width="200">收货地址：</td><td><input name='shouhuodizhi' type='text' id='shouhuodizhi' value='' onblur='checkform()' size='50' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelshouhuodizhi' /></td></tr>		<tr ><td width="200">创建时间：</td><td><input name='chuangjianshijian' type='text' id='chuangjianshijian' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelchuangjianshijian' /></td></tr>		<tr 0><td width="200">购买人：</td><td><input name='goumairen' type='text' id='goumairen' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabelgoumairen' /></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var dingdanshuliangobj = document.getElementById("dingdanshuliang"); if(dingdanshuliangobj.value==""){document.getElementById("clabeldingdanshuliang").innerHTML="&nbsp;&nbsp;<font color=red>请输入订单数量</font>";return false;}else{document.getElementById("clabeldingdanshuliang").innerHTML="  "; } 	var dingdanshuliangobj = document.getElementById("dingdanshuliang"); if(dingdanshuliangobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(dingdanshuliangobj.value)){document.getElementById("clabeldingdanshuliang").innerHTML=""; }else{document.getElementById("clabeldingdanshuliang").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}      var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value==""){document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>请输入联系电话</font>";return false;}else{document.getElementById("clabellianxidianhua").innerHTML="  "; } 	var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value!=""){ if(/^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxidianhuaobj.value)){document.getElementById("clabellianxidianhua").innerHTML=""; }else{document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>必需手机格式</font>"; return false;}}      var shouhuodizhiobj = document.getElementById("shouhuodizhi"); if(shouhuodizhiobj.value==""){document.getElementById("clabelshouhuodizhi").innerHTML="&nbsp;&nbsp;<font color=red>请输入收货地址</font>";return false;}else{document.getElementById("clabelshouhuodizhi").innerHTML="  "; } 	var chuangjianshijianobj = document.getElementById("chuangjianshijian"); if(chuangjianshijianobj.value==""){document.getElementById("clabelchuangjianshijian").innerHTML="&nbsp;&nbsp;<font color=red>请输入创建时间</font>";return false;}else{document.getElementById("clabelchuangjianshijian").innerHTML="  "; } 	var goumairenobj = document.getElementById("goumairen"); if(goumairenobj.value==""){document.getElementById("clabelgoumairen").innerHTML="&nbsp;&nbsp;<font color=red>请输入购买人</font>";return false;}else{document.getElementById("clabelgoumairen").innerHTML="  "; } 	var dingdanjiagej=1;if(document.getElementById("jiage").value!=""){dingdanjiagej=dingdanjiagej*parseFloat(document.getElementById("jiage").value);}if(document.getElementById("dingdanshuliang").value!=""){dingdanjiagej=dingdanjiagej*parseFloat(document.getElementById("dingdanshuliang").value);}document.getElementById("dingdanjiage").value=dingdanjiagej;	


return true;   
}   
popheight=450;
</script>  
