<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>후기 작성</title>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/board_write.css" rel="stylesheet" type="text/css">
<script src ="js/jquery-3.3.1.js"></script>
<script src= "js/writeform.js"></script>
<!-- <script>alert("${event_no}")</script> -->
</head>

<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">
				<div class="layout-page-header">
					<h2>후기 작성</h2>
				</div>
<form action="./BoardAddAction.board" method="post" enctype="multipart/form-data" name="boardform">
<input type="hidden" name="event_no" value="${event_no}">
<div id="table_wrap">
<table>
	<tr>
		<td>글쓴이</td>
		<td><input name="mem_id" id="mem_id" readonly type="text" size="68" maxlength="30" value="${sessionScope.id}"></td>
	</tr>
	<tr>
		<td>이벤트명</td>
		<td>
			<select name="event_no" id="event_no">
							<option value="">--후기를 작성할 이벤트를 선택하세요--</option>
				<c:forEach var="pay" items="${ paymentlist }">
					<c:forEach var="event" items="${ eventnamelist }">
						<c:if test="${pay.event_no==event.event_no}">
							<option value="${event.event_no}">${event.event_name}</option>
						</c:if>
					</c:forEach>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input name="board_title" id="board_title" type="text" size="68" maxlength="100" value=""></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><textarea  name="board_content" id="board_content" cols="90" rows="15"></textarea>
		</td>
	</tr>
	<tr>
		<td>이미지 첨부</td>
		<td>
		
		<input type="file" id="upfile" name="board_file" value="이미지 첨부">
		<input type="hidden" id="filevalue">
		</td>
	</tr>
	<tr>
		<td colspan = "2">
			<input type=submit value="등록" class="right">
			<input type=reset value="취소" class="right" onClick="history.go(-1)">
		</td>
	</tr>
</table>
</div>
</form>

			</div>
		</div>
	</div>
</div>
</body>
</html>