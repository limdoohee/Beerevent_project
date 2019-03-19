/**
 * 
 */


$(function() {
	// 관리자 마이페이지 - 승인대기자 "승인"처리
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
			success : function (data) {
				approval_btn.closest("tr").remove();
				$("#ajax").empty().append(data);
			},
			error : function () {
				alert("error");
			}
		});
	});
	
	// 관리자 마이페이지 - 회원 "삭제"
	$('.delete-member').on('click', function() {
		var delete_btn = $(this);
		var mem_id = delete_btn.closest("tr").find(".mem_PK").val();
		alert(mem_id);
		$.ajax({
			type : "post",
			data : {"state" : "ajax",
				"mem_id" : mem_id},
			url : "memberDelete.admin",
			cache : false,
			success : function (data) {
				$("#table").empty().append(data);
			},
			error : function () {
				alert("error");
			}
		});
	});
	
	
	// 관리자 마이페이지 - 판매자 "삭제"
	$('.delete-sel').on('click', function() {
		var delete_btn = $(this);
		var seller_id = delete_btn.closest("tr").find(".sel_PK").val();
		alert(seller_id);
		$.ajax({
			type : "post",
			data : {"state" : "ajax",
				"seller_id" : seller_id},
			url : "sellerDelete.admin",
			cache : false,
			success : function (data) {
				delete_btn.closest("tr").remove();
			},
			error : function () {
				alert("error");
			}
		});
	});
	
	// 관리자 마이페이지 - 승인대기자 "거부"
	$('.delete-temp').click( function() {
		//클릭한 버튼 변수 선언
		var approval_btn = $(this);
		var stemp_id = approval_btn.closest("tr").find(".stemp_PK").val();
		alert(stemp_id);
		$.ajax({
			type : "post",
			data : {"state" : "ajax",
					"stemp_id" : stemp_id},
			url : "stempDelete.admin",
			cache : false,
			success : function () {
				delete_btn.closest("tr").remove();
			},
			error : function () {
				alert("error");
			}
		});
	});
});