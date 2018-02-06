$(function() {
	var editor = CKEDITOR.replace('newContent');

	// 选择下拉框
	$("#articleType").select2({
		placeholder : "请选择",
		dropdownParent : $("#modalAddArticle"),
		allowClear : true
	});

	$('#addArticle').click(function() {
		$.ajax({
			type : "post",
			url : "addArticle",
			data : {
				'artcType' : $('#articType').val(),
				'artcTitle' : $('#newTitle').val(),
				'artcContent' : editor.document.getBody().getHtml()
			},
			dataType : "json",
			async : false,
			success : function(data) {
				if (data.code == '200') {
					$('#modalAddArticle').modal('hide');
				} else {
					alert(data.content, {skin : 'layui-layer-molv'});
				}
			},
			error : function(data, error) {
				alert("faild! " + error);
			}
		});
	});

})