$(function() {
$('.approval-temp').click( function() {
		
	//클릭한 버튼 변수 선언
	var approval_btn = $(this);
	var stemp_id = approval_btn.closest("tr").find(".stemp_PK").val();
	alert(stemp_id);
	$.ajax({
		type : "post",
		data : {"state" : "ajax",
				"stemp_id" : stemp_id},
		url : "AddsellerFromStemp.admin",
		cache : false,
		succes : function () {
			approval_btn.closest("tr").remove();
			$("#ajax").emty().append(data);
		},
		error : function () {
			alert("error");
		}
	});
});
});