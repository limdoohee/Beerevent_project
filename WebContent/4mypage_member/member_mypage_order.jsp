<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문상세</title>
<script src="js/jquery-3.3.1.js"></script>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/Order.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
$(function() {
	$('.btn0').click(function() {
		var btn = $(this);
		var event_no = btn.closest("div").find(".event_PK").val();
		location.href="BoardWrite.board";
	});
});
</script>
</head>
<body>
<%-- <jsp:useBean class = "memberdb.PaymentBean" id="payment"/> --%>
	<div id="wrap">
		<div id="container">
		<jsp:include page="../header.jsp" />
        <div id="main">
			<div id="content">
                   <div class="layout-page-header mypage_modify">
						<h2>주문 내역</h2>
					</div>
			<c:if test="${empty paymentlist}">
			 <div id="box1">
                <div id="event1">
                주문 내역이 없습니다.
                </div>
		     </div>
			</c:if>
			<c:if test="${!empty paymentlist}">
				<c:forEach var="pay" items="${paymentlist}">
			        <div id="box1">
		                <div class="event1">
			                <div class="order">
			                          <p>주문번호 : ${pay.pay_no}</p>
			                </div>
			                <c:forEach var="e" items="${ eventlist }">
								<c:if test="${ e.event_no ==pay.event_no}">
									<div class="img"><img src="upload/event/${ e.event_file }"></div>
								</c:if>
							</c:forEach>
			                <div class="e_text" >
			                <br>
			                  <ul class="event_ul">
				                  <c:forEach var="e" items="${ eventlist }">
									<c:if test="${ e.event_no ==pay.event_no}">
										<li class="event_li"><p class="text">이벤트명</p><input type="text" name="event_name" placeholder="event_name" value="${e.event_name}" required readonly></li>
									</c:if>
								</c:forEach>
			                      <li class="event_li"><p class="text">날짜</p><input type="text" name="event_dayofweek" placeholder="date" value="${pay.pay_date}"required readonly></li>
			                      <li class="event_li"><p class="text">가격</p><input type="text" name="event_price" placeholder="price" value="${pay.pay_price}"required readonly></li>
			                      <li class="event_li"><p class="text">결제여부</p><input type="text" name="pay_yesorno" placeholder="count" value="${pay.pay_yesorno}" required readonly></li>
			               	   </ul>
			                </div>
		                </div>
		                <input type="hidden" name="event_no" class="event_PK" value="${pay.event_no}">
		                <button class="btn0">후기작성</button>
		             </div>
	             </c:forEach>
             </c:if>
		</div>
	</div>
	</div>
	</div>
	</body>
</html>