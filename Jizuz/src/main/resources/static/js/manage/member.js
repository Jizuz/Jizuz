$(function() {
	$('#modalInfo').on('shown.bs.modal', function () {
		var uid = $('#mbrEdit').attr('value');
		$.ajax({
			type:"post",
			url:"getUserById",
//			data:{"uid":"10001"},
			data:{"uid":uid},
			dataType:"json",
			success:function(data) {
				if (data != null) {
					$("#nickName").val(data.userName);
					$("#fullName").val(data.fullName);
					$("#birth").val(data.birthday);
					$("#tel").val(data.tel);
					$("#email").val(data.email);
					$("#home").val(data.homeAddr);
					$("#current").val(data.nowAddr);
					$("#company").val(data.company);
				}
			},
			error:function(data, error) {
				alert("faild! " + error);
			}
		});
	});
});