<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>주문상세내역</title>
<link href="css/Orderlist.css" rel="stylesheet">
<script src="js/jquery-3.3.1.js"></script>
<!-- <link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/Countlist.css" rel="stylesheet"> -->
<style type="text/css">
/* #card, #account, #deposit {
	visibility: hidden;
} */
</style>
<script>
$(document).ready(function(){
	
	$('#card').hide();
	$('#account').hide();
	$('#deposit').hide();
	$('#cardRadio').click(function() {
		$('#card').show();
		$('#account').hide();
		$('#deposit').hide();
	});
	$('#accountRadio').click(function() {
		$('#card').hide();
		$('#account').show();
		$('#deposit').hide();
	});
	$('#depositRadio').click(function() {
		$('#card').hide();
		$('#account').hide();
		$('#deposit').show();
	});
	
	$('#order').click(function() {
		var con = confirm('결제하시겠습니까?');
		if(conn == true) {
			('form').submit();
		} else {
			return false;
		}
	});
	
});

<script src="../js/jquery-3.3.1.js"></script>
<link href="../css/common3.css" rel="stylesheet" type="text/css">
<link href="../css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
	<div id="usermenu">
		<c:if test="${ id !=null && !id.equals('') }">
			<ul>
				<li>${id}님</li>
				<li><a href="mypagecheck.net">마이페이지</a></li>
				<li><a href="logout.net">로그아웃</a></li>
			</ul>			
		</c:if>
		
		<c:if test="${ id==null || id.equals('') }">
			<ul>
				<li><a href="login.net">로그인</a></li>
				<li><a href="join_select.net">회원가입</a></li>
			</ul>			
		</c:if>
	</div>
	
	<div id="nav">
		<ul>
			<li><a href="#">사이트소개</a></li>
			<li>│</li>
			<li><a href="store_map.do">스토어찾기</a></li>
			<li>│</li>
			<li><a href="BoardList.board">후기게시판</a></li>
			<li>│</li>
			<li><a href="#">소셜네트워크</a></li>
		</ul>
	</div>
</div>
<div></div>



</head>
<body>
    <div id="wrap">
	<div id="container">
		<%-- <jsp:include page="../header.jsp" /> --%>
		<div id="main">
			<div id="content">
			<div id="key">
				<h1>주문상세내역</h1>
			</div>
            <div id="box1">
	            <form action="orderProcess.member" method="post">
	           <%--  <input type="hidden" value="${edate_unique_no}"> --%>
	           <%--  <input type="hidden" value="${event_no}"> --%>
					<div id="event1">
						<div class="img"><img src="img/img1.png"></div>
						<div class="e_text" >
							<ul>
								<li class="event_li"><p class="text">이벤트명</p><input type="text" value="${event_name}" required readonly></li>
								<li class="event_li"><p class="text">가격</p><input type="text" value="${event_price}" required readonly></li>
								<li class="event_li"><p class="text">날짜</p><input type="text" value="${edate_date}" required readonly></li>
							</ul>
						</div>
	             	</div>
	
	<%-- 	            <div id="event2">
		                <a>주문자명</a><br>
		                <c:set>입력값 받아오기
		                <a>휴대폰 번호</a><br>
		                <c:set>입력값 받아오기
		            </div> --%>
	
					
		            <div id="count">
		                <p>결제방법 : 카드이체 or 실시간 계좌이체 or 무통장 입금<br>
	                	<ul class="tp_1">
							<li><p><input type="radio" name="howPay" id="cardRadio">카드결제(신용/체크카드)</li>
							<li><p><input type="radio" name="howPay" id="accountRadio">실시간계좌이체</li>
							<li><p><input type="radio" name="howPay" id="depositRadio">무통장입금</li>
						</ul>
					</div>
					
						<div id= "total">
							<div id="card">
							<ul>
								<li class="card_li"><p>이름 </p><input type="text"  name="pay_card_name" size=5></li>
								<li class="card_li"><p>카드번호</p><input type="text"  name="pay_card_no" size=20></li>
								<li class="card_li"><p>CVC번호</p><input type="text"  name="pay_card_cvc" size=5></li>
							</ul>
							</div>
							<div id="account">
							<ul>
								<li class="account_li"><p>계좌번호</p><input type="text"  name="pay_account_no" size=20></li>
								<li class="account_li"><p>비밀번호</p><input type="text"  name="pay_account_pass" size=5></li>
							</ul>
							</div>
							<div id="deposit">
							<ul>
								<li class="deposit_li"><p>입금자명</p><input type="text"  name="pay_deposit_name" size=9></li>
								<li class="deposit_li"><p>입금은행</p><input type="text" placeholder="국민은행 [ 669701-04-018846 / ????? ]"></li>
								<li class="deposit_li"><p>결제예정금액</p><input type="text" name="pay_countli_count"></li>
							</ul>
							</div>
						</div>
						
						
		            </div>
		            <div id="btn2">
		                <button class="btn1" id="order">주문목록보기</button>
		            </div>
		            </div>
		        </form>
        	</div>
    	</div>
	</div>
</body>
</html>