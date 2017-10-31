var form;
var flag=-1;
layui.config({
	base : 'js',
	version : new Date().getTime()
}).use(['layer','form'], function() {
	var layer = layui.layer, 
	$ = layui.jquery, 
	form = layui.form();

	var loginFlag=true;
	var rememberFlag=1;
	local($,layui);// 读取本地信息
	//登录
	form.on('submit(login)', function(data) {
		 if(loginFlag){
			 $.post("doLogin",{
				 userAccount:data.field.userAccount,
				 pwd:data.field.pwd
			 },function(data){
				 var code =  data.code;
				 if(code!=1000){
					 layer.msg(data.msg);
				 }else{
					 if(flag==1){
						 saveLocal($);
					 }
					 location.href = "index";
				 }
			 },"json");
		 }
		return false;
	});
	
	//记住帐号
	form.on('switch(switcher)', function(data) {
		 flag=-flag;
		 if(flag==-1){
			 localStorage.setItem("userAccount","");
		 }
		return false;
	});
	
});

/**
 * 读取本地信息
 */
function local($,layui) {
	var userAccount = localStorage.getItem("userAccount");
	if (userAccount != null && userAccount != '') {
		 flag=-flag;
		$("#rememberMe").attr("checked", "checked");
		layui.form().render('checkbox');
		$("#userAccount").val(userAccount);
	} else {
		$("#rememberMe").attr("checked", false);
		$("#userAccount").val("");
	}
}


/**
 * 保存账户名
 * @param $ : jquery
 */
function saveLocal($) {
	var userAccount = $("#userAccount").val();
	localStorage.setItem("userAccount", userAccount);
}