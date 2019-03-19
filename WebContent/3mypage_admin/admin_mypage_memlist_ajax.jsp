<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="js/ajax.js"></script>

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
				