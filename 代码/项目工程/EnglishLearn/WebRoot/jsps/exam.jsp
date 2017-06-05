<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试题模块</title>
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
    margin-left:350px;
}
#menu{
    margin-left:250px;
    padding-top:25px;
}
</style>
<body>
<div id="main">
<span id="s1">根据释义填单词</span>
	<div id="menu">
	<form action="word_checkWord.action" method="post">
		<table id=t1 border="1">
			<tr>
				<td width="100">释义</td>
				<td width="100">请填写单词</td>
			</tr>
			<!-- 取出session中的值 -->
			<s:iterator var="c" value="#session.exam">
				<tr>
					<td><s:property value="#c.mean"/></td>
					<td><input type=text required name="<s:property value="#c.id"/>"/></td>
				</tr>
			</s:iterator>
		</table>
		<input type="submit" />
		<a href="word_examPage.action">换一组</a>
		<a href="user_userMenu.action">主菜单</a>
		<s:actionmessage/>
	</form>
	</div>
</div>
</body>
</html>














