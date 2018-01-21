$(function() {
	$('img.lazy').lazyload({
		// container: $('.product-list'), //
		// 对指定标签对象内的图片实现效果，表示在此标签中滚动时，触发加载（注意：如果容器未设置height和overfload:auto，那么会默认加载所有图片）
		threshold : 100, // 当图片顶部距离显示区域还有100像素时，就开始加载
		placeholder : "img/grey.gif", // 图片未加载时，占位
		effect : "slideDown", // 图片出现的效果，值有show(直接显示),fadeIn(淡入),slideDown(下拉)
		effect_speed : 1000, // 效果出现的时间
		event : 'scroll', // 滚动滚轮时触发，可以是：click、mouseover等
		data_attribute : 'original', // img标签中保存url的自定义属性，默认：data-original
		skip_invisible : true, // 是否跳过已经隐藏的图片（display:none）
		failure_limit : 2, // 由于延迟加载是根据Dom从上到下执行
		// 如果遇到Dom位置在上，但是图片定位在下导致看不到，那么会以为之后的图片不在应用延迟加载
		// 此处的failure_limit用于限制如果出现N个【Dom位置在上，但是图片定位在下】才终止
		appear : function() { // 当图片位置刚出现在视图时，触发此事件
			$(this).attr('src');
		},
		load : function() { // 当图片路径加载之后，触发此事件
			$(this).attr('src');
		}

	});
})