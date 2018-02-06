$(function() {
	$('img.lazy').lazyload({
		threshold : 100, // 当图片顶部距离显示区域还有100像素时，就开始加载
		placeholder : "img/grey.gif", // 图片未加载时，占位
		effect : "fadeIn", // 图片出现的效果，值有show(直接显示),fadeIn(淡入),slideDown(下拉)
		effect_speed : 1000, // 效果出现的时间
		event : 'scroll', // 滚动滚轮时触发，可以是：click、mouseover等
		data_attribute : 'original', // img标签中保存url的自定义属性，默认：data-original
		skip_invisible : true, // 是否跳过已经隐藏的图片（display:none）
		failure_limit : 2, // 此处的failure_limit用于限制如果出现N个才终止
		appear : function() { // 当图片位置刚出现在视图时，触发此事件
			$(this).attr('th:src');
		},
		load : function() { // 当图片路径加载之后，触发此事件
			$(this).attr('th:src');
		}

	});

	// 图片弹出层
	$(".imgLayBg").height($(document).height());
	$(".imgClaose").click(function() {
		$(".imgLayBg,.imglayBox").hide()
	});
	$(".imgShow").click(function() {
		$(".img_html").html($(this).find(".hidden").html());
		$(".imgLayBg").show();
		$(".imglayBox").fadeIn(300)
	});

	// 选择下拉框
	$("#imgTheme").select2({
		placeholder : "请选择",
		dropdownParent : $("#modalAddImg"),
		allowClear : true
	});

	// 上传图片
	$('#submitUpload').click(function() {
		$.ajax({
			type : "post",
			url : "addImg",
			data : {
				'imgTheme' : $('#imgTheme').val(),
				'imgComment' : $('#commentImg').val(),
			},
			dataType : "json",
			async : false,
			success : function(data) {
				
			},
			error : function(data, error) {
				alert("faild! " + error);
			}
		});
	});

	$('#fileImg').uploadify({
		swf : 'lib/uploadify.swf',
		uploader : 'uploadImg',
		auto : true, // 文件添加到队列后自动上传
		successTimeout : 9999999,
		fileSizeLimit : '1000 MB',
		fileTypeExts : '*.jpeg;*.jpg;*.png;*.bmp',
		multi : false,
		// 返回一个错误，选择文件的时候触发
		onSelectError : function(file, errorCode, errorMsg) {
			alert(errorCode, {skin : 'layui-layer-molv'});
			switch (errorCode) {
			case -100:
				alert("上传的文件数量已经超出系统限制的" + $('#fileImg').uploadify('settings',
								'queueSizeLimit') + "个文件！", {skin : 'layui-layer-molv'});
				break;
			case -110:
				alert("文件 [" + file.name + "] 大小超出系统限制的" + $('#fileImg').uploadify('settings',
								'fileSizeLimit') + "大小！", {skin : 'layui-layer-molv'});
				break;
			case -120:
				alert("文件 [" + file.name + "] 大小异常！", {skin : 'layui-layer-molv'});
				break;
			case -130:
				alert("文件 [" + file.name + "] 类型不正确！", {skin : 'layui-layer-molv'});
				break;
			}
			alert(errorMsg, {skin : 'layui-layer-molv'});
		},
		onFallback : function() {
			alert("您未安装FLASH控件，无法上传图片。", {skin : 'layui-layer-molv'});
		},
		onUploadSuccess : function(file, data, response) {
			// TODO
		}
	});
})