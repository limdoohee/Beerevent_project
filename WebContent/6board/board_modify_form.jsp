<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>후기 수정</title>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/board_modify_form.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.3.1.js"></script>
<script src= "js/writeform.js"></script>
</head>

<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">
			
<form action="./BoardModifyAction.board" method="post" name="modifyForm">
	<input type="hidden" name="no" value="${board_bean.board_no}">
	<table>
		<tr>
		<td>글쓴이</td><td>${board_bean.mem_id}</td>
		</tr>
		<tr>
		<td>제목</td>
		<td><input name="board_title" id="board_title" type="text" size="68" maxlength="100" value="${board_bean.board_title}"></td>
		</tr>
		<tr>
		<td>내용</td>
		<td><textarea name="board_content" id="board_content" cols="70" rows="15">${board_bean.board_content}</textarea></td>
		</tr>
		<c:if test="${!empty board_bean.board_file}">
		<tr>
		<td>이미지 첨부</td>
		<td>
		${board_bean.board_file}
		</td>
		</tr>
		</c:if>
		<tr>
			<td colspan = "2">
				<input type =submit value="수정" class="right">
				<input type=button value="취소" onClick="history.go(-1)" class="right">
			</td>
		</tr>
	</table>
</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>