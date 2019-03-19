$(document).ready(function(){
	$("form").submit(function(){
		if($.trim($("#board_title").val())==""){
			alert("제목을 입력하세요.");
			$("#board_title").focus();
			return false;
		}
		if($.trim($("textarea").val())==""){
			alert("내용을 입력하세요.");
			$("textarea").focus();
			return false;
		}		
		if( !$('#event_no').val() ){
			alert("후기를 작성할 이벤트를 선택하세요.");
			return false;
		}
	})
	 $("input:eq(2)").change(function(){
		$("#filevalue").val("");
		/*alert($(this).val());*/
		var inputfile = $(this).val().split("\\");
		$("#filevalue").text(inputfile[inputfile.length-1])
	});
	
});