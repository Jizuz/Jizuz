$(function() {
	// 选择下拉框
	$("#articleType").select2({
        placeholder: "请选择",
        dropdownParent: $("#modalAddArticle"),
        allowClear: true
    });
})