<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri='/struts-tags' prefix='s' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="cache-control" content="no-cache" />
	<title>新闻中国</title>
	
	<link href="CSS/main.css" rel="stylesheet" type="text/css" />
	<script language="javascript">
		function check(){
			var username = document.getElementById("username");
			var password = document.getElementById("password");
			if(username.value == ""){
				alert("用户名不能为空！请重新填入！");
				username.focus();	
				return false;
			}else if(password.value == ""){
				alert("密码不能为空！请重新填入！");
				password.focus();
				return false;
			}
			return true;
		}
		
		function focusOnLogin(){
			var password = document.getElementById("password");
			if( password != null )
				password.focus();	
		}
	</script>
</head>
<body onload="focusOnLogin()">
<div id="header">
	<div id="top_login">	
	<s:if test="#session.admin==null">
		<form action="validateLogin" method="post" onsubmit="return check()">
		    <label>用户名</label>
			<input type="text" id="username"  name="username" value="" class="login_input" />
			<label> 密&#160;&#160;码 </label>
			<input type="password" id="password" name="password" value="" class="login_input" />
			<input type="submit" class="login_sub" value="登录" />
			<label id="error"> </label>			
		</form>
	</s:if>
	<s:if test="#session.admin!=null">
		欢迎您 ：<s:property value="#session.admin.username" />  &nbsp; &nbsp; &nbsp;<a href="/admin">登录控制台</a> &nbsp; <a href="loginout">退出</a>
	</s:if>
  </div>
  <div id="nav">
	  <table>
	    <tr>
	    	<td><div id="logo"> <img src="Images/logo.jpg" alt="新闻" /> </div></td>
	    	<td><img src="Images/a_b01.gif" alt="" /></td>
	    </tr>
	  </table>
    <!--mainnav end-->
  </div>
</div>
</body>
</html>

