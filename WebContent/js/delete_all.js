$(document).ready(function(){	
	$('#btn3').click(function(){
				$.ajax({
					type : "post",
					data : {"state" : "ajax"},
					url : "./DeleteAll.member",
					cache : false,
					success : function(data){
						$(".e_text").remove();
						alert ("삭제되었습니다.");
						},
					error : function(){
						alert ("error");
						}		
				});
		});
	});
