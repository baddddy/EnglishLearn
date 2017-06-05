<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询模块</title>
</head>
<script src="${pageContext.request.contextPath}/js/search.js" ></script>
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
    margin-left:120px;
    padding-top:25px;
}
</style>
<body>
<div id="main">
<span id="s1">查询模块</span>
	<div id="menu">
		<input type="text" id="searchWord" required /><input type="button" value="查询" onclick="searchWordFun();" />
		<table id=t2 border="1">
			<tr>
				<td width="150">单词/例句</td>
				<td width="200">意思</td>
				<td>难度</td>
				<td>是否常用</td>
				<td>删除</td>
				<td>修改</td>
			</tr>
			<!-- 将值栈中的查询结果拿出来 -->
			<s:iterator var="p" value="search">
				<tr>
					<td><s:property value="#p.word"/></td>
					<td><s:property value="#p.mean"/></td>
					<td><s:property value="#p.diff"/></td>
					<td><s:property value="#p.common"/></td>
					<td><a onclick="javascript:return del();" href="word_deleteWord.action?word=<s:property value="#p.word"/>">删除</a></td>
					<td><a href="word_updateWordPage.action?word=<s:property value="#p.word"/>">修改</a></td>
				</tr>
			</s:iterator>
		</table>
		<a href="user_userMenu.action">主菜单</a>
	</div>
</div>
</body>
</html>








