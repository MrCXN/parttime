var tab;
layui.config({
	base : '../js/',
	version : new Date().getTime()
}).use(['paging','laydate','form'], function() {
	var $ = layui.jquery,
		paging = layui.paging(),
		layer = layui.layer, //获取当前窗口的layer对象
		laydate = layui.laydate,
		form = layui.form();
	
	var name =$("#name").val();
	var addBoxIndex = -1;	
		
	
	//分页初始化
	pagingInit();

	//搜索
	$('#search').on('click', function() {
		name =$("#name").val();
		pagingInit();
	});

	
	/**
	 * 页面数据初始化加载
	 */
	function pagingInit(){
		paging.init({
			url: '../company/findSeekUserList', //地址
			elem: '#seekUser', //内容容器
			params: { //发送到服务端的参数
				name:name
			},
			openWait: true, //加载数据时是否显示等待框 
			type: 'post',
			tempElem: '#tpl', //模块容器
			pageConfig: { //分页参数配置
				elem: '#paged', //分页容器
				pageSize:8 //分页大小
			},
			success: function() { //渲染成功的回调
				bind();
			},
			fail: function(msg) { //获取数据失败的回调
				alert('获取数据失败')
			}
		});
	}
	
	/**
	 * 绑定页面事件
	 */
	function bind(){
		//重新渲染复选框
		form.render('checkbox');
		form.on('checkbox(allselector)', function(data) {
			var elem = data.elem;
			$('#content').children('tr').each(function() {
				var $that = $(this);
				//全选或反选
				$that.children('td').eq(0).children('input[type=checkbox]')[0].checked = elem.checked;
				form.render('checkbox');
			});
		});
			
		//绑定所有删除事件
		$('.del').on('click', function(){
			var id = $(this).attr("data-id");
			layer.confirm('真的删除行么', function(index){
				//向服务端发送删除指令
				$.post("../company/delSeekUserById.do",{
					id:id
				},function(data){
					layer.close(index);
					var code =  data.code;
					if(data.code==1000){
						pagingInit();
					}
					layer.msg(data.msg);
				},"json"); 
			});
		})
		
	}
});