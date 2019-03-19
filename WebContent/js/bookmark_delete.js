$(document).ready(function(){	
	$('.btn_1').click(function(){
		
		th=$(this);
		event_no = th.closest("table").find(".event_no").val();
		/*alert(event_no);*/
		$.ajax({
			type : "post",
			data : {"state" : "ajax",
					"event_no" : parseInt(event_no)},
			url : "./BookmarkDeleteAction.member" ,
			cache : false,
			success : function(data){
				th.closest("table").remove();
				alert ("삭제되었습니다.");
			},
			error : function(){
				alert ("error");
			}

		})
	})
})
