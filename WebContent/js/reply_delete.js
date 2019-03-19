$(document).ready(function(){	
	$('.reply_delete_button').click(function(){
		
		th=$(this);
		reply_no = th.closest("table").find('.reply_no').val();
		
		
		$.ajax({
			type : "post",
			data : {"state" : "ajax",
				/*"reply_content" : $('#reply_content').val(),*/
				"board_no" : $('#board_no').val(),
				"reply_no" : parseInt(reply_no)},
			url : "./ReplyDeleteAction.board" ,
			cache : false,
			success : function(data){
				th.closest("table").remove();
			},
			error : function(){
				alert ("error");
			}

		})
	})
})
