function funUp(){
	var page=document.getElementById("page1").value;
	var p=parseInt(page)-1;
	if(p<1){
		alert("当前已为第一页，无上一页！");
		return;
	}
	window.location.href="word_searchByPage.action?pageNum="+p;
}
function funDown(){
	var page=document.getElementById("page1").value;
	var p=parseInt(page)+1;
	window.location.href="word_searchByPage.action?pageNum="+p;
}
function funJump(){
	var page=document.getElementById("page2").value;
	var p=parseInt(page);
	if(page==""||page==null){
		alert("请输入跳转页面再点跳转！");
		return;
	}else if(p<1){
		alert("页数不能小于1！");
		return;
	}
	window.location.href="word_searchByPage.action?pageNum="+page;
}
function del() {
	var msg = "确认删除？";
	if (confirm(msg)==true){
	    return true;
	}else{
	    return false;
	}
}
//查询函数
function searchWordFun(){
	var word=document.getElementById("searchWord").value;
	if(word==""||word==null){
		alert("请先输入查询的单词或句子！");
		return;
	}
	window.location.href="word_searchWord.action?word="+word;
}








