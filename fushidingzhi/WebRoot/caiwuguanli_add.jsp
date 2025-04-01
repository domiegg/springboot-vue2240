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
		<TITLE>添加财务管理</TITLE>
	    

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
	document.location.href="caiwuguanli_add.jsp?id=<%=id%>";
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
			<form action="addCaiwuguanli.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加财务管理</td>
						</tr>
						<tr ><td width="200">财务编号：</td><td><input name='caiwubianhao' type='text' id='caiwubianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">标题：</td><td><input name='biaoti' type='text' id='biaoti' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelbiaoti' /></td></tr>		<tr ><td width="200">月份：</td><td><select name='yuefen' id='yuefen'><option value="一月份">一月份</option><option value="二月份">二月份</option><option value="三月份">三月份</option><option value="四月份">四月份</option><option value="五月份">五月份</option><option value="五月份">五月份</option><option value="六月份">六月份</option><option value="七月份">七月份</option><option value="八月份">八月份</option><option value="九月份">九月份</option><option value="十月份">十月份</option><option value="十一月份">十一月份</option><option value="十二月份">十二月份</option></select>&nbsp;*<label id='clabelyuefen' /></td></tr>		<tr ><td width="200">订单数量：</td><td><input name='dingdanshuliang' type='text' id='dingdanshuliang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabeldingdanshuliang' /></td></tr>		<tr ><td width="200">订单总价：</td><td><input name='dingdanzongjia' type='text' id='dingdanzongjia' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabeldingdanzongjia' /></td></tr>		<tr ><td width="200">对账状态：</td><td><select name='duizhangzhuangtai' id='duizhangzhuangtai'><option value="未对账">未对账</option><option value="已核对">已核对</option></select>&nbsp;*<label id='clabelduizhangzhuangtai' /></td></tr>		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='checkform()' style='border:solid 1px #000000; color:#666666' ></textarea>&nbsp;*<label id='clabelbeizhu' /></td></tr>		<tr ><td width="200">文件：</td><td><input name='wenjian' type='text' id='wenjian' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('wenjian')" style='border:solid 1px #000000; color:#666666'/></td></tr>		<tr ><td width="200">记录时间：</td><td><input name='jilushijian' type='text' id='jilushijian' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabeljilushijian' /></td></tr>		<tr 0><td width="200">记录入：</td><td><input name='jiluru' type='text' id='jiluru' onblur='checkform()' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" />&nbsp;*<label id='clabeljiluru' /></td></tr>		
		
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
 
	var biaotiobj = document.getElementById("biaoti"); if(biaotiobj.value==""){document.getElementById("clabelbiaoti").innerHTML="&nbsp;&nbsp;<font color=red>请输入标题</font>";return false;}else{document.getElementById("clabelbiaoti").innerHTML="  "; } 	var yuefenobj = document.getElementById("yuefen"); if(yuefenobj.value==""){document.getElementById("clabelyuefen").innerHTML="&nbsp;&nbsp;<font color=red>请输入月份</font>";return false;}else{document.getElementById("clabelyuefen").innerHTML="  "; } 	var dingdanshuliangobj = document.getElementById("dingdanshuliang"); if(dingdanshuliangobj.value==""){document.getElementById("clabeldingdanshuliang").innerHTML="&nbsp;&nbsp;<font color=red>请输入订单数量</font>";return false;}else{document.getElementById("clabeldingdanshuliang").innerHTML="  "; } 	var dingdanshuliangobj = document.getElementById("dingdanshuliang"); if(dingdanshuliangobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(dingdanshuliangobj.value)){document.getElementById("clabeldingdanshuliang").innerHTML=""; }else{document.getElementById("clabeldingdanshuliang").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}      var dingdanzongjiaobj = document.getElementById("dingdanzongjia"); if(dingdanzongjiaobj.value==""){document.getElementById("clabeldingdanzongjia").innerHTML="&nbsp;&nbsp;<font color=red>请输入订单总价</font>";return false;}else{document.getElementById("clabeldingdanzongjia").innerHTML="  "; } 	var dingdanzongjiaobj = document.getElementById("dingdanzongjia"); if(dingdanzongjiaobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(dingdanzongjiaobj.value)){document.getElementById("clabeldingdanzongjia").innerHTML=""; }else{document.getElementById("clabeldingdanzongjia").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}      var duizhangzhuangtaiobj = document.getElementById("duizhangzhuangtai"); if(duizhangzhuangtaiobj.value==""){document.getElementById("clabelduizhangzhuangtai").innerHTML="&nbsp;&nbsp;<font color=red>请输入对账状态</font>";return false;}else{document.getElementById("clabelduizhangzhuangtai").innerHTML="  "; } 	var beizhuobj = document.getElementById("beizhu"); if(beizhuobj.value==""){document.getElementById("clabelbeizhu").innerHTML="&nbsp;&nbsp;<font color=red>请输入备注</font>";return false;}else{document.getElementById("clabelbeizhu").innerHTML="  "; } 	var jilushijianobj = document.getElementById("jilushijian"); if(jilushijianobj.value==""){document.getElementById("clabeljilushijian").innerHTML="&nbsp;&nbsp;<font color=red>请输入记录时间</font>";return false;}else{document.getElementById("clabeljilushijian").innerHTML="  "; } 	var jiluruobj = document.getElementById("jiluru"); if(jiluruobj.value==""){document.getElementById("clabeljiluru").innerHTML="&nbsp;&nbsp;<font color=red>请输入记录入</font>";return false;}else{document.getElementById("clabeljiluru").innerHTML="  "; } 	


return true;   
}   
popheight=450;
</script>  
