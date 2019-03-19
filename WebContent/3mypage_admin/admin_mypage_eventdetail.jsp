<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="js/jquery-3.3.1.js" ></script>
<script src="js/event_detail.js" ></script>
<link href="css/admin_event_detail.css" rel="stylesheet" type="text/css">
<!-- <link href="css/event_detail2.css" rel="stylesheet" type="text/css">  -->
<script>
$(document).ready(function(){
	$('#store_detail').click(function(){
		window.open(this.href, '가게 정보', 'width=700, height=350, top=200, left=300', '_blank');
		return false;
	});
	
	$('.orderlist').click(function(){
		var list_btn = $(this);
		var edate_PK = list_btn.closest('tr').find('.edate_PK').val();
		alert(edate_PK);
		window.open('EventOrderList.admin?edate_unique_no='+edate_PK, '이벤트 신청자 리스트', 'width=800, height=600, top=100, left=300', '_blank');
		return false;
	});
});
</script>
</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		
		<c:set var="e" value="${ event }" />
		<%-- <c:set var="d" value="${ eventdate }" /> --%>
		<div class="layout-page-header">
			<h2>이벤트 상세조회</h2>
		</div>
		<!-- 이벤트 정보 뽑아오는 div -->
		<div id="eventdetail">
			<!-- 이벤트가 없을 때 -->
			<c:if test="${ empty event }">
				이벤트를 가져오는데 오류가 발생하였습니다.
			</c:if>
			<c:if test="${ !empty event }">
			<%-- <c:set var="d" value=""> --%>
				<div id="box2">
					<table id="table1">
						<tr>
							<th>가게 이름</th>	<td>${ param.store_name }</td>
							<th>번호</th><td>${ event.event_no }</td>
						</tr>
						<tr>
							<th>판매자 아이디</th><td>${ param.seller_id }</td>
							<th>이벤트 타입</th>	<td>${ event.event_categ }</td>
						</tr>
						<tr>
							<th>이벤트 이름</th><td>${ event.event_name }</td>
							<th>가격</th><td>${ event.event_price }</td>
						</tr>
						<tr>
							<th rowspan="4">이벤트 이미지</th><td rowspan="4"><img src="upload/event/${ event.event_file }"></td>
							<th>시간</th><td>${ event.event_time }</td>
						</tr>
						<tr>
							<th>위치</th><td>${ event.event_location }</td>
						</tr>
						<tr>
							<th>주소</th><td>${ event.event_spot }</td>
						</tr>
						<tr>
							<th>설명</th><td>${ event.event_description }</td>
						</tr>
					</table>
<!-- 					<br><br>* 날짜 조회<br> -->
					<table id="table2">
						<tr>
							<th>번호</th>
							<th>날짜</th>
							<th>신청인원</th>
							<th></th>
						</tr>
						<c:forEach  var="d" items="${ eventdate }">
						<tr>
							<td>${ d.edate_unique_no }<input type="hidden" class="edate_PK" value="${ d.edate_unique_no }"></td>
							<td>${ d.edate_date }</td>
							<td>${ d.edate_num_of_pp }</td>
							<td><button class="orderlist">신청자 리스트</button></td>
						</tr>
						</c:forEach>
					</table>
<!-- 					<button class="btn1">수정</button> -->
<!-- 					<button class="btn1">삭제</button><br> -->
<%-- 					<a href="EventModifyPage.event?event_no=${ event.event_no }">[ 수정 ]</a> --%>
				</div>
				
			</c:if>
		</div>
		
</div>
</div>
</body>
</html>