<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<!-- <script src="js/event_detail.js" ></script> -->
</head>
<body>
<div id="key">
	<h3>신청자 목록</h3>
</div>
<div id="orderlist">
	<table>
		<tr>
			<th>번호</th>
			<th>회원 아이디</th>
			<th>이름</th>
			<th>phone</th>
			<th>E-mail</th>
		</tr>
		<!-- 신청자가 아무도 없는 경우 -->
		<c:if test="${empty memberlist}">
		<tr>
			<td colspan="5">신청자가 없습니다.</td>
		</tr>
		</c:if>
		
		<!-- 신청자가 있는 경우 -->
		<c:if test="${!empty memberlist}">
		<c:forEach var="m" items="${memberlist}" varStatus="status">
		<tr>
			<td>${status.count}</td>
			<td>${m.mem_id}</td>
			<td>${m.mem_name}</td>
			<td>${m.mem_phone}</td>
			<td>${m.mem_email}</td>
		</tr>
		</c:forEach>
		</c:if>
	</table>
</div>
</body>
</html>