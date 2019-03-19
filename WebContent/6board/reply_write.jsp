<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
table, tr{border:1px solid black;}
</style>
</head>
<body>
<form action="./ReplyAddAction.board" method="post" name="replyForm">
<input type="hidden" value="${board_bean.board_no}" name="board_no">
<table>
<tr>
<td>댓글</td>
</tr>
<tr>
	<td><textarea name="reply_content" id="reply_content" rows="3" cols="50"></textarea></td>
</tr>
<tr>
	<td>
	<input type=submit value="등록">
	</td>
</tr>
</table>
</form>
</body>
<%
  request.setAttribute("board_bean","board_bean");              
%>
</html>