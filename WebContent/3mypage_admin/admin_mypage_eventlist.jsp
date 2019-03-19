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
<script type="text/javascript">
	$(function() {
		$('#detail').on('click', function() {
			location.href="eventDetail.admin?${ elist.event_no }";
		});
		$('#delete').on('click', function() {
			location.href="";
		});
		$('.store_detail').click(function(){
			window.open(this.href, '가게 정보', 'width=1010, height=420, top=200, left=300', '_blank');
			return false;
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
					<h2>이벤트 전체 조회</h2>
				</div>
				<table id="table">
					<tr>
						<th>번호</th><th>이름</th><th>이벤트 타입</th><th>위치</th><th>가게 이름</th><th></th>
					</tr>
					<c:forEach var="elist" items="${ eventlist }">
					<tr>
						<td>${ elist.event_no }</td>
						<td>${ elist.event_name }</td>
						<td>${ elist.event_categ }</td>
						<td>${ elist.event_location }</td>
						<c:forEach var="slist" items="${ storelist }">
							<c:if test="${ elist.store_no ==slist.store_no}">
								<td><a class="store_detail" href="EventStoreView.event?store_no=${ slist.store_no }">${ slist.store_name }</a></td>
							</c:if>
						</c:forEach>
						<td><button id="store-detail"><a href="eventDetail.admin?event_no=${ elist.event_no }">상세보기</a></button><button id="delete">삭제</button></td>
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