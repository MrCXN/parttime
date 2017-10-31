var form;
var id=  sessionStorage.advertisingId||0;
layui.config({
	base : '../js/',
	version : new Date().getTime()
}).use(['paging','form','laytpl'], function() {
	var $ = layui.jquery,
		layer = layui.layer, //获取当前窗口的layer对象
		paging = layui.paging(),
		laytpl = layui.laytpl,
		form = layui.form();
	
	
		getAdvertisingById();
	

		// 提交
		form.on('submit(submit)', function(data) {
			var name = data.field.name;
			var salary = data.field.salary;
			var sex = data.field.sex;
			var age = data.field.age;
			
			$.post('../advertising/editAdvertising', {
				id:id,
				name : name,
				salary : salary,
				sex : sex,
				age : age,
			}, function(data) {
				var code = data.code;
				if (code == 1000) {
					var index = parent.layer.getFrameIndex(window.name); // 先得到当前iframe层的索引
					parent.layer.close(index); // 再执行关闭
				} else {
					layer.msg(data.msg);
				}
			}, 'json');
		});
		
		/*
		 * 通过id查询公司
		 */
		function getAdvertisingById(){
			$.post('../advertising/getgetAdvertisingById',{
				id:id
			},function(data){
				var code = data.code;
				if(code==1000){
					var advertising = data.data;
					$("#name").val(advertising.name);
					$("#salary").val(advertising.salary);
					$("#sex").val(advertising.sex);
					$("#age").val(advertising.age);
				}else{
					layui.msg(data.msg);
				}
			},'json');
		}
});
