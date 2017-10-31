var form;
var companyId = sessionStorage.id||0;
layui.config({
	base : '../js/',
	version : new Date().getTime()
}).use([ 'paging', 'form', 'laytpl' ], function() {
	var $ = layui.jquery, layer = layui.layer, // 获取当前窗口的layer对象
	paging = layui.paging(), laytpl = layui.laytpl, form = layui.form();

	// 提交
	form.on('submit(submit)', function(data) {
		var name = data.field.name;
		var salary = data.field.salary;
		var sex = data.field.sex;
		var age = data.field.age;
		
		$.post('../advertising/saveAdvertising', {
			name : name,
			salary : salary,
			sex : sex,
			age : age,
			companyId:companyId
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
});
