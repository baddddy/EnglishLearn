function funTran(){
	var a1=document.getElementById("area1").value;
	if(a1==""||a1==null){
		alert("请输入翻译内容！");
		return;
	}
	window.location.href="word_tranWord.action?areaTran="+a1;
}