<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>英语学习助手用户</title>
<!--用到的js-->
<script src="${pageContext.request.contextPath}/js/jquery-1.5.1.js"></script>
<script src="${pageContext.request.contextPath}/js/regist.js" ></script>
<link href="${pageContext.request.contextPath}/css/regist.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<s:actionerror />
<div class="MainFrame">
  <div class="divTitle"><span class="spanTitle">英语助手用户注册</span></div>
  <form action="user_regist.action" method="post" id="registFrom" onsubmit="return checkForm();">
	<table class="inter">
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="name" id="loginname" required/></td>
		</tr>
		<tr>
			<td>登录密码：</td>
			<td><input type="password" name="password" id="loginpass" required/></td>
		</tr>
		<tr>
			<td>确认密码：</td>
			<td><input type="password" name="repassword" id="reloginpass" required/></td>
		</tr>
		<tr>
			<td>邮箱：</td>
			<td><input type="email" name="email" id="email" required placeholder="格式务必正确"/></td>
		</tr>
	</table><br>
	<input type="image" src="./images/regist1.jpg" id="submit" class="inter2"/>
  </form>
</div>
</body>
</html>






