<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改单词/例句</title>
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
    margin-left:365px;
}
#menu{
    margin:0 auto 0 auto;
    padding-top:25px;
}
</style>
<body>
<div id="main">
<span id="s1">修改单词/例句</span>
<form action="word_updateWord.action" method="post">
<table id="menu">
	<tr>
	    <td>单词：</td>
        <td><input type="text" name="word" value="<s:property value="model.word"/>" readonly/></td>
	</tr>
	<tr>
	    <td>意思：</td>
        <td><input type="text" name="mean" required/></td>
	</tr>
	<tr>
	    <td><input type="submit" value="修改单词" /></td>
	</tr>
</table>
<a href="user_userMenu.action">主菜单</a>
<s:actionmessage/>
</form>
</div>
</body>
</html>





