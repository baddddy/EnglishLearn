<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="MainFrame">
    <img src="${ pageContext.request.contextPath }/images/cug1.jpg" class="LeftFrame"/>
	    <div class="LoginTop">
	        <span class="TopTitle">英语学习助手用户登录</span>
	    </div>
		<form action="${ pageContext.request.contextPath }/user_login.action" method="post" id="LoginForm">
		<table>
		<tr>
		    <td>登录名：</td>
			<td><input type="text" name="name" required/></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="password" required/></td>
		</tr>
		</table>
		<br>
		<input type="image" src="${ pageContext.request.contextPath }/images/login.jpg"/>
		&nbsp;<s:actionerror />
		<br><br>
		<b>还未注册？点击<a href="user_registPage.action">此处</a>注册账号。</b>
		</form>
</div>
</body>
</html>




