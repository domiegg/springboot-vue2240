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
		<TITLE>添加订单管理</TITLE>
	    

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
	document.location.href="dingdanguanli_add.jsp?id=<%=id%>";
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
			<form action="addDingdanguanli.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加订单管理</td>
						</tr>
						<tr ><td width="200">设计编号：</td><td><input name='shejibianhao' type='text' id='shejibianhao' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.shejibianhao.value='<%=connDbBean.readzd("wodedingdan","shejibianhao","id",request.getParameter("id"))%>';document.form1.shejibianhao.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">设计名称：</td><td><input name='shejimingcheng' type='text' id='shejimingcheng' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.shejimingcheng.value='<%=connDbBean.readzd("wodedingdan","shejimingcheng","id",request.getParameter("id"))%>';document.form1.shejimingcheng.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">模板类型：</td><td><input name='mobanleixing' type='text' id='mobanleixing' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.mobanleixing.value='<%=connDbBean.readzd("wodedingdan","mobanleixing","id",request.getParameter("id"))%>';document.form1.mobanleixing.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">订单数量：</td><td><input name='dingdanshuliang' type='text' id='dingdanshuliang' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.dingdanshuliang.value='<%=connDbBean.readzd("wodedingdan","dingdanshuliang","id",request.getParameter("id"))%>';document.form1.dingdanshuliang.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">订单价格：</td><td><input name='dingdanjiage' type='text' id='dingdanjiage' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.dingdanjiage.value='<%=connDbBean.readzd("wodedingdan","dingdanjiage","id",request.getParameter("id"))%>';document.form1.dingdanjiage.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">收货地址：</td><td><input name='shouhuodizhi' type='text' id='shouhuodizhi' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.shouhuodizhi.value='<%=connDbBean.readzd("wodedingdan","shouhuodizhi","id",request.getParameter("id"))%>';document.form1.shouhuodizhi.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.lianxidianhua.value='<%=connDbBean.readzd("wodedingdan","lianxidianhua","id",request.getParameter("id"))%>';document.form1.lianxidianhua.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">购买人：</td><td><input name='goumairen' type='text' id='goumairen' value='' onblur='' style='border:solid 1px #000000; color:#666666'  readonly='readonly' /></td></tr><script language="javascript">document.form1.goumairen.value='<%=connDbBean.readzd("wodedingdan","goumairen","id",request.getParameter("id"))%>';document.form1.goumairen.setAttribute("readOnly",'true');</script>
		<tr ><td width="200">订单状态：</td><td><select name='dingdanzhuangtai' id='dingdanzhuangtai'><option value="订制中">订制中</option><option value="已出货">已出货</option></select>&nbsp;*<label id='clabeldingdanzhuangtai' /></td></tr>
		<tr 0><td width="200">物流状态：</td><td><select name='wuliuzhuangtai' id='wuliuzhuangtai'><option value="未发货">未发货</option><option value="已发货">已发货</option><option value="配送中">配送中</option><option value="已签收">已签收</option></select>&nbsp;*<label id='clabelwuliuzhuangtai' /></td></tr>
		<tr 1><td width="200">物流单号：</td><td><input name='wuliudanhao' type='text' id='wuliudanhao' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelwuliudanhao' /></td></tr>
		<tr 2><td width="200">记录时间：</td><td><input name='jilushijian' type='text' id='jilushijian' value='<%=connDbBean.gettime()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd HH:mm:ss'})" style='width:120px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabeljilushijian' /></td></tr>
		<tr 3><td width="200">记录人：</td><td><input name='jiluren' type='text' id='jiluren' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		
		
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
 
	var dingdanzhuangtaiobj = document.getElementById("dingdanzhuangtai"); if(dingdanzhuangtaiobj.value==""){document.getElementById("clabeldingdanzhuangtai").innerHTML="&nbsp;&nbsp;<font color=red>请输入订单状态</font>";return false;}else{document.getElementById("clabeldingdanzhuangtai").innerHTML="  "; } 
	var wuliuzhuangtaiobj = document.getElementById("wuliuzhuangtai"); if(wuliuzhuangtaiobj.value==""){document.getElementById("clabelwuliuzhuangtai").innerHTML="&nbsp;&nbsp;<font color=red>请输入物流状态</font>";return false;}else{document.getElementById("clabelwuliuzhuangtai").innerHTML="  "; } 
	var wuliudanhaoobj = document.getElementById("wuliudanhao"); if(wuliudanhaoobj.value==""){document.getElementById("clabelwuliudanhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入物流单号</font>";return false;}else{document.getElementById("clabelwuliudanhao").innerHTML="  "; } 
	var wuliudanhaoobj = document.getElementById("wuliudanhao"); if(wuliudanhaoobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(wuliudanhaoobj.value)){document.getElementById("clabelwuliudanhao").innerHTML=""; }else{document.getElementById("clabelwuliudanhao").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var jilushijianobj = document.getElementById("jilushijian"); if(jilushijianobj.value==""){document.getElementById("clabeljilushijian").innerHTML="&nbsp;&nbsp;<font color=red>请输入记录时间</font>";return false;}else{document.getElementById("clabeljilushijian").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  
