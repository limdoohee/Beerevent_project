<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>후기 읽기</title>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/board_detail_view.css" rel="stylesheet" type="text/css">

<script src="js/jquery-3.3.1.js"></script>
<script src="js/reply_list.js"></script>
<script src="js/reply_delete.js"></script>
<script>
$(function(){
	$("#boardDelete").click(function(){
		var con = confirm("삭제하시겠습니까?");
		if(con==true){
			location.href="BoardDeleteAction.board?no=${board_bean.board_no}";
		}else if(con==false){
			return;
		}
	});
	$("#boardEdit").click(function(){
			location.href="BoardModifyForm.board?no=${board_bean.board_no}";
	});
	$("#boardList").click(function(){
		location.href="BoardList.board";
	});
});
</script>
</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">


<table>
	<tr>
	<td>작성자</td> <td>${board_bean.mem_id}</td>
	<td>작성일</td> <td>${board_bean.board_date}</td>
	<td>조회수</td> <td>${board_bean.board_readcount}</td>
	<tr>
	
	<tr>
		<td>이벤트명</td><td colspan="5">${board_bean.event_name}</td>
	</tr>
	
	<tr>
		<td>후기 제목</td><td colspan="5">${board_bean.board_title}</td>
	</tr>
	
	<c:if test= "${!empty board_bean.board_file}">
	
		<tr>
			<td colspan="6"><img src= "upload/board/${board_bean.board_file}" height="300"></td>
		</tr>
	</c:if>
	
	<tr>
		<td colspan="6"><pre>${board_bean.board_content}</pre></td>
	</tr>
		
	<tr>
		<td colspan="6">
<%--<c:if test="${board_bean.mem_id == sessionScope.id || sessionScope.id=='admin'}"> --%>
			<button id="boardEdit">수정</button>&nbsp;&nbsp;
			<button id="boardDelete">삭제</button>&nbsp;&nbsp;
<%--</c:if> --%>	
			<button id="boardList">목록</button>&nbsp;&nbsp;				
		</td>
	</tr>
	
</table>

	<input type="hidden" value="${board_bean.board_no}" id="board_no" name="board_no">
	<!-- <script>alert("${board_bean.board_no}");</script>  -->
	<br>
	<br>
	
<!-- <table> -->

	<%-- ${sessionScope.id} --%>
	<div>
	<textarea name="reply_content" id="reply_content" rows="3" cols="150"></textarea>
		<input type="hidden" value="${sessionScope.id}" id="mem_id" name="mem_id">
	</div>
	
	<div id="button">
	<button> 댓글등록 </button>
	</div>
	<br>
	<br>
	<br>
	


<div id="aaa">
<c:forEach var="r" items="${reply_bean_list}">
<table class="reply_table">
<%-- <tr><td>reply_no</td><td class="reply_no">${r.reply_no}</td></tr> --%>	
<tr>
<td><span>${r.reply_content}<input type="hidden" class="reply_no" value="${r.reply_no}"></span>
<span class="right">-${r.mem_id}-${r.reply_date}&nbsp;<button class="reply_delete_button">삭제</button>
</span></td>
</tr>
</table>
</c:forEach>
</div>


			</div>
		</div>
	</div>
</div>
</body>
</html>