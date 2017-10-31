var form;
var id= sessionStorage.id||0;
layui.config({
	base : '../js/',
	version : new Date().getTime()
}).use(['paging','form','laytpl'], function() {
	var $ = layui.jquery,
		layer = layui.layer, //获取当前窗口的layer对象
		paging = layui.paging(),
		laytpl = layui.laytpl,
		form = layui.form();
	
	
		getCompanyById();
	
		// 上传照片
		$('#uploadPic').on('change', function() {
			var a = $("#uploadPic").get(0).files[0];
			
			if(a.size>1048576){
				layer.msg("上传的图片过大,请处理后在上传....");
				return;
			}
			var option = {
				url : "../upload/uploadPic",
				type : "post",
				dataType : "json",
				success : function(data) {
					if(data.code!=1000){
						layer.msg(data.msg);
					}else{
						// 对data操作
						// 1、图片回显
						$("#allUrl").attr("src", data.allUrl);
						// 2、设置隐藏域的值
						$("#imgUrl").val(data.imgUrl);
					}
				}
			}
			$("#jvForm").ajaxSubmit(option);
		})
		
		//提交
		form.on('submit(submit)', function(data){
			var name = data.field.name;
			var type = data.field.type;
			var introduce = data.field.introduce;
			var imgUrl = data.field.imgUrl;
			$.post('../company/editCompanyById',{
				id:id,
				name:name,
				type:type,
				introduce:introduce,
				imgUrl:imgUrl
			},function(data){
				var code = data.code;
				if(code==1000){
					var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
					parent.layer.close(index); //再执行关闭  
				}else{
					layer.msg(data.msg);
				}
			},'json');
		});
		
		/*
		 * 通过id查询公司
		 */
		function getCompanyById(){
			$.post('../company/getCompanyById',{
				id:id
			},function(data){
				var code = data.code;
				if(code==1000){
					var company = data.data;
					$("#name").val(company.name);
					$("#introduce").val(company.introduce);
					$("#type").val(company.type);
					$("#imgUrl").val(company.imgUrl);
					$("#allUrl").attr("src",company.imgUrl);
				}else{
					layui.msg(data.msg);
				}
			},'json');
		}
});
