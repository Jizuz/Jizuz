$(function() {
	var _uid = null;

	/* <![CDATA[ */
	$('.mbrEdit').click(function() {
		_uid = $(this).attr('value');
	});

	$('#modalInfo').on('shown.bs.modal', function() {
		// var uid = /*[[${user.uid}]]*/ '10001';
		$.ajax({
			type : "post",
			url : "getUserById",
			data : {
				"uid" : _uid
			},
			dataType : "json",
			async : false,
			success : function(data) {
				if (data != null) {
					$("#uid").val(data.uid);
					$("#nickName").val(data.userName);
					$("#fullName").val(data.fullName);
					$("#tel").val(data.tel);
					$("#email").val(data.email);
					$("#company").val(data.company);
				}
			},
			error : function(data, error) {
				alert("faild! " + error);
			}
		});
	});
	/* ]]> */
});