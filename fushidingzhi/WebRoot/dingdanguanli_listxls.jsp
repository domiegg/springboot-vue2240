<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="dingdanguanlihsgb" scope="page" class="com.bean.DingdanguanliBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=dingdanguanli.xls");
%>
<html>
  <head>
    <title>��������</title>
  </head>

  <body >
 <%
			String sql="select * from dingdanguanli  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>��Ʊ��</td>
    <td align='center'>�������</td> 
    <td align='center'>ģ������</td>
    <td align='center'>��������</td>
    <td align='center'>�����۸�</td>
    <td align='center'>�ջ���ַ</td>
    <td align='center'>��ϵ�绰</td>
    <td align='center'>������</td>
    <td align='center'>����״̬</td>
    <td align='center'>����״̬</td>
    <td align='center'>��������</td>
    <td  width='95' align='center'>��¼ʱ��</td>
    <td align='center'>��¼��</td>
    <td  width='80' align='center'>�Ƿ����</td>
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=dingdanguanlihsgb.getAllDingdanguanli(16);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shejibianhao}</td>
    <td>${u.shejimingcheng}</td>
    <td>${u.mobanleixing}</td>
    <td>${u.dingdanshuliang}</td>
    <td>${u.dingdanjiage}</td>
    <td>${u.shouhuodizhi}</td>
    <td>${u.lianxidianhua}</td>
    <td>${u.goumairen}</td>
    <td>${u.dingdanzhuangtai}</td>
    <td>${u.wuliuzhuangtai}</td>
    <td>${u.wuliudanhao}</td>
    <td>${u.jilushijian}</td>
    <td>${u.jiluren}</td>
    <td align='center'>${u.issh} <input type="button" value="���" onClick="javascript:location.href='sh.jsp?id=${u.id}&yuan=${u.issh}&tablename=dingdanguanli'"/></td>
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

