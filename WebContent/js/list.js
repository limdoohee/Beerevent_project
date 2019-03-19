$(document).ready(function(){
	$('#viewcount').change(function(){
		var limit = $('#viewcount option:selected').val();
		$.ajax({
			type : "post",
			data : {"limit" : limit, "state" : "ajax"},
			url : "./BoardList.board" ,
			cache : false,
			success : function(data){
				$("table:first").empty().prepend(data);
			},
			error : function(){
				alert ("error");
			}
		})
	})
	
	$("#viewcount").val("${limit}").prop("selected", true);
})