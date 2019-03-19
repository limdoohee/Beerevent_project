<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문상세</title>
<%-- <jsp:useBean class = "memberdb.PaymentBean" id="payment"/> --%>
<form name="Order" action="Mem_OrderProcess.member" method="post">
	<div id="wrap">
	<!-- 헤더부분 -->
           <%-- <jsp:include page="../header1.jsp" /> --%>
		<div id="container">
        <div id="main">
			<div id="content">
                    <h1>주문내역</h1>
			<%-- <c:forEach var ="c" items="${c}"> --%>
	        <div id="box1">
	                <div id="event1">
	                <div class="order">
                           <p>주문번호</p>
                    </div>
	                  <div class="img"><img src="img/img1.png"></div>
	                  <div class="e_text">
	                 <%--   value="${c.event_no}" --%><br>
	                  <ul class="event_ul">
	                     <li class="event_li"><p class="text">이벤트명</p><input type="text" name="event_name" placeholder="event_name" value="${c.event_name}" required readonly></li>
	                      <li class="event_li"><p class="text">날짜</p><input type="text" name="event_dayofweek" placeholder="date" value="${c.event_dayofweek}"required readonly></li>
	                      <li class="event_li"><p class="text">가격</p><input type="text" name="event_price" placeholder="price" value="${c.event_price}"required readonly></li>
	                      <li class="event_li"><p class="text">결제여부</p><input type="text" name="pay_yesorno" placeholder="count" value="${c.pay_yesorno}" required readonly></li>
	               	   </ul>
	                </div>
                 </div>
                    <button class="btn0" onclick="location.href='#'">후기작성</button>
             </div>
             
             <%-- </c:forEach> --%>
		</div>
	</div>
	</div>
	</div>
	</form>
</body>
</html>