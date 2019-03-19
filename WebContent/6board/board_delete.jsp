<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>board_delete</title>
<script src="js/jquery-3.3.1.js"></script>
</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">
<form name="deleteForm" action="BoardDeleteAction.board" method="post">
<input type="hidden" name="no" value="${param.no}">

	정말 삭제하시겠습니까?
	<input type=submit value="삭제">
	<input type=button value="취소" onclick="history.go(-1)">

</form>
</div>
		</div>
	</div>
</div>
</body>
</html>