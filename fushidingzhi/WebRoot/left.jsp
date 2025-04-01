<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
<head>
<title>left</title><script src="js/menu.js"></script>


<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
body {
	background-color: #fbf6f2;
	
}
.STYLE2 {color: #FFFFFF}
.STYLE3 {color: #6d1d0a}
-->
</style><meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table id="__01" width="184" border="0" cellpadding="0" cellspacing="0">
	
	
		  
		  
          <tr>
            <td><table id="__01" width="184" border="0" cellpadding="0" cellspacing="0">
              <tr onClick="show('1')" style="cursor:pointer;">
                <td width="184"  background="images/hsg4.gif"><table width="100%" height="26" border="0" cellpadding="0" cellspacing="0">
                   <tr>
                      <td width="14%"  height="25" align="center" valign="bottom">&nbsp;</td>
                      <td width="86%" height="25"><span class="STYLE3"><strong>权限管理</strong></span></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td width="184"  style="display:none"  id="show1">
				<table width="91%" border="0" align="center" cellpadding="0" cellspacing="0">
				    <tr>
					 <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
					  <td ><a href="mod.jsp" target="mainFrame">个人密码管理</a></td>
					</tr>
					<tr>
					 <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
					  <td ><a href="allusers_add.jsp" target="mainFrame">管理员添加</a></td>
					</tr>
					<tr>
					 <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
					  <td ><a href="allusersList.do" target="mainFrame">管理员管理</a></td>
					</tr>
					<tr>
					 <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
					  <td ><a href="shejishixinxi_add.jsp" target="mainFrame">设计师权限添加</a></td>
					</tr>
					<tr>
					 <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
					  <td ><a href="shejishixinxiList.do" target="mainFrame">设计师信息管理</a></td>
					</tr>
					<tr>
					 <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
					  <td ><a href="kefuxinxi_add.jsp" target="mainFrame">客服权限添加</a></td>
					</tr>
					<tr>
					 <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
					  <td ><a href="kefuxinxiList.do" target="mainFrame">客服信息管理</a></td>
					</tr>
					<tr>
					 <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
					  <td ><a href="yonghuxinxi_add.jsp" target="mainFrame">用户权限添加</a></td>
					</tr>
					<tr>
					 <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
					  <td ><a href="yonghuxinxiList.do" target="mainFrame">用户信息管理</a></td>
					</tr>
				  </table></td>
              </tr>
			  
              
            </table></td>
          </tr>
		  
		  
          <tr>
            <td><table id="__01" width="184" border="0" cellpadding="0" cellspacing="0">
              <tr onClick="show('2')" style="cursor:pointer;">
                <td width="184" background="images/hsg4.gif"><table width="100%" height="26" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="14%"  height="26" align="center" valign="bottom">&nbsp;</td>
                      <td width="86%"><span class="STYLE3"><strong>设计管理</strong></span></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td width="184"  style="display:none"  id="show2"><table width="91%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                      <td ><a href="mobanxinxi_add.jsp" target="mainFrame">模板数据添加</a></td>
                    </tr>
                    <tr>
                      <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                      <td ><a href="mobanxinxiList.do" target="mainFrame">模板数据查询</a></td>
                    </tr>
					<tr>
                      <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                      <td ><a href="shejihuihuaList3.do" target="mainFrame">设计绘画添加</a></td>
                    </tr>
                    <tr>
                      <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                      <td ><a href="shejizhanshiList.do" target="mainFrame">设计绘画查询</a></td>
                    </tr>
					
                </table></td>
              </tr>
             
            </table></td>
          </tr>
          <tr>
            <td><table id="__01" width="184" border="0" cellpadding="0" cellspacing="0">
              <tr onClick="show('3')" style="cursor:pointer;">
                <td width="184" background="images/hsg4.gif"><table width="100%" height="26" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="14%"  height="26" align="center" valign="bottom">&nbsp;</td>
                      <td width="86%"><span class="STYLE3"><strong>审核管理</strong></span></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td width="184"   style="display:none"  id="show3"><table width="91%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                      <td ><a href="shejihuihuaList.do" target="mainFrame">设计审核</a></td>
                    </tr>
                    <tr>
                      <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                      <td ><a href="wodedingdanList.do" target="mainFrame">订单审核</a></td>
                    </tr>
					 <tr>
                      <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                      <td ><a href="caiwuguanliList.do" target="mainFrame">财务审核</a></td>
                    </tr>
                    
                </table></td>
              </tr>
            
            </table></td>
          </tr>
          <tr>
            <td><table id="__01" width="184" border="0" cellpadding="0" cellspacing="0">
              <tr onClick="show('4')" style="cursor:pointer;">
                <td width="184" background="images/hsg4.gif"><table width="100%" height="26" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="14%"  height="26" align="center" valign="bottom">&nbsp;</td>
                      <td width="86%"><span class="STYLE3"><strong>订单管理</strong></span></td>
                    </tr>
                </table></td>
              </tr>
              <tr>
                <td width="184"   style="display:none"  id="show4"><table width="91%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                      <td ><a href="wodedingdanList3.do" target="mainFrame">订单信息创建</a></td>
                    </tr>
                    <tr>
                      <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                      <td ><a href="dingdanguanliList.do" target="mainFrame">订单信息查询</a></td>
                    </tr>
					 
                </table></td>
              </tr>
             
            </table></td>
          </tr>
          <tr>
            <td><table id="__01" width="184" border="0" cellpadding="0" cellspacing="0">
              <tr onClick="show('5')" style="cursor:pointer;">
                <td width="184" background="images/hsg4.gif"><table width="100%" height="26" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="14%"  height="26" align="center" valign="bottom">&nbsp;</td>
                      <td width="86%"><span class="STYLE3"><strong>客服反馈</strong></span></td>
                    </tr>
                </table></td>
              </tr>

              <tr>
                <td width="184"   style="display:none"  id="show5"><table width="91%" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                      <td ><a href="fankuixinxiList.do" target="mainFrame">客服反馈</a></td>
                    </tr>
					 
                    
                </table></td>
              </tr>
             
            </table>
			</td>
          </tr>
          <tr>
            <td>
              <table id="__01" width="184" border="0" cellpadding="0" cellspacing="0">
                <tr onClick="show('6')" style="cursor:pointer;">
                  <td width="184" background="images/hsg4.gif"><table width="100%" height="26" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                      <td width="14%"  height="26" align="center" valign="bottom">&nbsp;</td>
                      <td width="86%"><span class="STYLE3"><strong>财务管理</strong></span></td>
                    </tr>
                  </table></td>
                </tr>
                <tr>
                  <td width="184"   style="display:none"  id="show6"><table width="91%" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                        <td ><a href="caiwuguanli_add.jsp" target="mainFrame">入账管理</a></td>
                      </tr>
                      <tr>
                        <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                        <td ><a href="caiwuguanliList.do" target="mainFrame">对账查询</a></td>
                      </tr>
		
                  </table></td>
                </tr>
               
              </table>
			  </td>
          </tr>
		  
		  <tr>
            <td>
              <table id="__01" width="184" border="0" cellpadding="0" cellspacing="0">
                <tr onClick="show('7')" style="cursor:pointer;">
                  <td width="184" background="images/hsg4.gif"><table width="100%" height="26" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                      <td width="14%"  height="26" align="center" valign="bottom">&nbsp;</td>
                      <td width="86%"><span class="STYLE3"><strong>仓库管理</strong></span></td>
                    </tr>
                  </table></td>
                </tr>
                <tr>
                  <td width="184"   style="display:none"  id="show7"><table width="91%" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                        <td ><a href="shejizhanshiList2.do" target="mainFrame">入库添加</a></td>
                      </tr>
                     <tr>
                        <td width="36" height="22" align="center"><img src="images/hsg5.gif"></td>
                        <td ><a href="kucunxinxiList.do" target="mainFrame">库存查询</a></td>
                      </tr>
                  </table></td>
                </tr>
               
              </table>
			  </td>
          </tr>
		  
          
               
              </table>
			  </td>
          </tr>
         <!-- <tr>
            <td>
              <table id="__01" width="184" border="0" cellpadding="0" cellspacing="0">
                <tr >
                  <td width="184" background="images/hsg4.gif"><table width="100%" height="26" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="90%"  height="26" align="center" valign="bottom"><span class="STYLE3"><strong>系统版权</strong></span></td>
                        <td width="10%">&nbsp;</td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td width="184"    id="submenu7"><table width="91%" border="0" align="center" cellpadding="0" cellspacing="0">
                      <tr>
                        <td colspan="2" align="center"><p>&nbsp;</p>
                        </td>
                      </tr>
                      
                  </table></td>
                </tr>
              
              </table></td>
          </tr>-->
        </table></td>
	</tr>
	
</table>
</body>
</html>