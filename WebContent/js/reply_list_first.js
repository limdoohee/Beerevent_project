$(document).ready(function(){	
	$.ajax({
		type : "post",
		data : {"state" : "ajax",
			"reply_content" : $('#reply_content').val(),
			"board_no" : $('#board_no').val()},
		url : "./ReplyList.board" ,
		cache : false,
		success : function(data){
			$("#aaa").empty().append(data);
		},
		error : function(){
			alert ("error");
		}
	})
	/*alert ($('#board_no').val());*/
})

