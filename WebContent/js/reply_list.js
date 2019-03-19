$(document).ready(function(){	
	$('#button').click(function(){
		if($.trim($("#reply_content").val())==""){
			alert("댓글을 입력하세요.");
			return false;
		}
		$.ajax({
			type : "post",
			data : {"state" : "ajax",
				"mem_id" : $('#mem_id').val(),
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
		$('#reply_content').val('');
	})
})
