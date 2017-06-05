/**
 * 初始化执行的内容
 */
$(function(){
    //鼠标停留切换图片
    $("#submit").hover(
        function() {
            $("#submit").attr("src", "./images/regist2.jpg");
        },
        function() {
            $("#submit").attr("src", "./images/regist1.jpg");
        }
    );
});
/*
 * 校验登录名
 */
function checkForm(){
    var value = $("#loginname").val();
    if(value.length > 20) {
        alert("用户名不能超过20！");
        return false;
    }
    var value = $("#reloginpass").val();
    if(value != $("#loginpass").val()) {
        alert("确认密码输入错误");
        return false;
    }
    return true;
}







