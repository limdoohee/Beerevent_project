<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/mypage_common.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/ajax.js"></script>
<script type="text/javascript">
$(function() {
	$('.modify-member').on('click', function() {
		var modify_btn = $(this);
		var mem_id = modify_btn.closest("tr").find(".mem_PK").val();
		location.href="mypageModify.member?mem_id="+mem_id;
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
				<div id="key">
					<h2>회원 정보 조회</h2>
				</div>
				<table id="table" style="width:70%;">
					<tr>
						<th>번호</th><th>아이디</th><th>이름</th><th>주민번호</th><th></th>
					</tr>
					<c:forEach var="mlist" items="${ memlist }" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${ mlist.mem_id }<input type="hidden" class="mem_PK" value="${ mlist.mem_id }"></td>
						<td>${ mlist.mem_name }</td>
						<td>${ mlist.mem_jumin }</td>
						<td>
						<button class="modify-member">수정</button>
						<button class="delete-member">삭제</button>
						</td>
					</tr>
					</c:forEach>
				</table>
				<%-- <c:forEach var="mlist" items="${ memlist }">
					회원 아이디 : ${ mlist.mem_id } <br>
				</c:forEach> --%>
			</div>
		</div>
	</div>
</div>
</body>
</html>