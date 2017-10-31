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
	var addTime =$("#addTime").val();
	var addBoxIndex = -1;	
		
	//渲染时间
	laydate.render({
	    elem: '#addTime' //指定元素
	});
	
	//分页初始化
	pagingInit();

	//搜索
	$('#search').on('click', function() {
		name =$("#name").val();
		addTime =$("#addTime").val();
		pagingInit();
	});

	//添加餐饮中心
	$('#add').on('click', function() {
		name =$("#name").val();
		addTime =$("#addTime").val();
		if(addBoxIndex !== -1){
			return;
		}
		addBoxIndex = layer.open({
			type: 2,
			title: '添加公司',
			shade: false,
			offset: ['105px', '25%'],
			area: ['750px', '500px'],
			zIndex: 19950924,
			maxmin: true,
			content:'../company/addCompanyIndex?',
			end: function() {
				pagingInit();
				addBoxIndex = -1;
			}
		});
	});
	
	/**
	 * 页面数据初始化加载
	 */
	function pagingInit(){
		paging.init({
			url: '../company/findCompanyList', //地址
			elem: '#company', //内容容器
			params: { //发送到服务端的参数
				name:name,
				addTime:addTime
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
	
		var editBoxIndex=-1;
		//绑定所有编辑事件
		$('.edit').on('click', function(){
			var id = $(this).attr("data-id");
			 sessionStorage.id=id;
			if(editBoxIndex !== -1)
				return;
			//本表单通过ajax加载 --以模板的形式，当然你也可以直接写在页面上读取
			addBoxIndex = layer.open({
			type: 2,
			title: '编辑餐饮中心',
			content: '/company/editCompanyIndex?id='+id,
			shade: false,
			offset: ['105px', '10%'],
			area: ['900px', '500px'],
			zIndex: 19950924,
			maxmin: true,
			end: function() {
				pagingInit();
				addBoxIndex = -1;
			}
		});
		});
			
		//绑定所有删除事件
		$('.del').on('click', function(){
			var id = $(this).attr("data-id");
			layer.confirm('真的删除行么', function(index){
				//向服务端发送删除指令
				$.post("../company/delCompanyById.do",{
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
		
		//绑定查看事件
		$('.select').on('click',function(){
			 name = $(this).attr("data-name");
			 id = $(this).attr("data-id");
			 sessionStorage.id=id;
			var data ={
						"title": name+"公司广告",
						"icon": "&#xe615",
						"href": "../advertising/advertisingIndex",
						"spread": true
					};
			window.parent.tab.tabAdd(data);
		});
	}
});