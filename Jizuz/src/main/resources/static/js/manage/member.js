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
					$("input:radio[name='auth']").removeAttr("checked");
					if (data.role.rid == '1') {
						$("input:radio[name='auth'][id='adm']").prop("checked", "true");
					} else if (data.role.rid == '2') {
						$("input:radio[name='auth'][id='mbr']").prop("checked", "true");
					} else {
						$("input:radio[name='auth'][id='tur']").prop("checked", "true");
					}
				}
			},
			error : function(data, error) {
				alert("faild! " + error);
			}
		});
	});
	
	$("#mbrUpdate").click(function() {
		var rid = 3;
		var allRids = $("input:radio[name='auth']");
		for (var i=0; i<allRids.length; i++) {
			if (allRids[i].checked) {
				rid = i; 
			}
		}
		
		$.ajax({
			type : "post",
			url : "updateUserById",
			data : {
				"uid" : $("#uid").val(),
				"userName" : $("#nickName").val(),
				"tel" : $("#tel").val(),
				"email" : $("#email").val(),
				"company" : $("#company").val(),
				"rid" : rid
			},
			dataType : "json",
			async : false,
			success : function(data) {
				window.parent.location.reload();
			},
			error : function(data, error) {
				alert("faild! " + error);
			}
		});
	});
	/* ]]> */
});