<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="js/ajax.js"></script>

<!-- ajax가 실행되고 id="ajax"인 div를 지우고 삽입할 table -->
	<table id="table">
		<tr>
			<th>번호</th><th>아이디</th><th>이름</th><th>사업자등록번호</th><th></th>
		</tr>
		<c:forEach var="slist" items="${ sellerList }">
		<tr>
			<td>1</td>
			<td>${ slist.seller_id }<input type="hidden" class="sel_PK" value="${ slist.seller_id }"></td>
			<td>${ slist.seller_name }</td>
			<td>${ slist.seller_bs_no }</td>
			<td><button id="store-detail"><a href="sellerDetail.admin?seller_id=${ slist.seller_id }" >상세정보</a></button><button class="delete-sel">삭제</button></td>
		</tr>
		</c:forEach>
	</table>
