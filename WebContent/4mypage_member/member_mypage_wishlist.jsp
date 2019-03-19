<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>찜목록</title>
<link href="css/Wishlist.css" rel="stylesheet">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/bookmark_delete.js"></script>
<script src="js/delete_all.js"></script>
<script>
	$(function() {
		$(".btn_0").click(function() {
			var event_no = $(".btn_0").closest('.btn_area').find('.event_PK').val();
			location.href="EventDetail.event?event_no="+event_no;
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
			<div class="layout-page-header">
				<h2>찜 목록</h2>
			</div>
			<div id="wishlist">
				<c:if test="${empty elist}">
					찜 목록이 없습니다.
				</c:if>	
				
				<c:if test="${!empty elist}">
					<c:forEach var="e" items="${elist}">
						<div id="box1">
							<div id="event1">
								<div class="img"><img src="upload/event/${e.event_file}"></div>
		  						<div class="e_text" >
		  							<ul class="event_ul">
		  								<li class="event_li"><span>이벤트명</span><input type="text" id="event_name" value="${e.event_name}" required readonly></li>
		  								<li class="event_li"><span>타입</span><input type="text" id="event_name" value="${e.event_categ}" required readonly></li>
		  								<li class="event_li"><span>시간</span><input type="text" id="brand_name" value="${e.event_time}"  required readonly></li>
		  								<li class="event_li"><span>가격</span><input type="text" id="price" placeholder="price" value="${e.event_price}" required readonly></li>
		  							</ul>
		  						</div>
		  						<div class="btn_area">
		  							<input type="hidden" class="event_PK" value="${e.event_no}">
		  							<button class="btn_0">상세보기</button>
		  						</div>
							</div>
    					</div>
					</c:forEach>
				</c:if>	
			</div>	
	</div>
	</div>
		</div>
	</div>

</body>
</html>