<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>翻译模块</title>
</head>
<script src="${pageContext.request.contextPath}/js/tran.js" ></script>
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
    margin-left:90px;
    padding-top:25px;
}
#area1{
    width:300px;
	height:350px;
}
#area2{
    width:300px;
	height:350px;
}
</style>
<body>
<div id="main">
<span id="s1">翻译句子</span>
	<div id="menu">
		<textarea id="area1" name="areaTran" placeholder="请输入待翻译的内容" style="float:left;"></textarea>
		<input type="text" id="area2" placeholder="翻译结果" value="${areaTran }" />
		<br>
		<input type="button" value="翻译" onclick="funTran();" />
		<a href="user_userMenu.action">主菜单</a>
	</div>
</div>
</body>
</html>






