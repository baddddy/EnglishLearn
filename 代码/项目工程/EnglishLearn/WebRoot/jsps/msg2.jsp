<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息通知</title>
</head>
<style>
#main{
    width:500px;
	height:200px;
	border: 1px #CCC solid;
	margin-left:380px;
    margin-top:150px;
}
#menu{
    padding-left:213px;
    padding-top:25px;
}
</style>
<body>
<div id="main">
<span>***************************网页消息***************************</span>
<s:actionmessage/>
<div id="menu">
<a href="user_userMenu.action">主菜单</a>
</div>
</div>
</body>
</html>








