<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>英语学习助手主界面</title>
</head>
<style>
#main{
    width:800px;
	height:500px;
	border: 1px #CCC solid;
	margin:0 auto 0 auto;
    margin-top:50px;
}
#s1{
    margin-left:330px;
}
#menu{
    margin:0 auto 0 auto;
    padding-top:25px;
}
</style>
<body>
<div id="main">
<span id="s1">英语学习助手主界面</span>
<table id="menu">
	<tr>
		<td>
		<a href="${pageContext.request.contextPath}/word_wordPage.action">录入模块</a>
		</td>
	</tr>
	<tr>
		<td>
		<a href="${pageContext.request.contextPath}/word_examPage.action">试题模块</a>
		</td>
	</tr>
	<tr>
		<td>
		<a href="${pageContext.request.contextPath}/word_searchPage.action?pageNum=1">分页模块</a>
		</td>
	</tr>
	<tr>
		<td>
		<a href="${pageContext.request.contextPath}/word_searchWordPage.action">查询模块</a>
		</td>
	</tr>
	<tr>
		<td>
		<a href="${pageContext.request.contextPath}/word_tranWordPage.action">翻译模块</a>
		</td>
	</tr>
</table>
</div>
</body>
</html>







