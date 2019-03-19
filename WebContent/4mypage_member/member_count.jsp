 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>결제</title>
<link href="css/Count.css" rel="stylesheet">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/payment.js"></script>
<script>
$(function() {
	$("#pay1").click(function() {
		alert('카드번호를 입력하세요');
	});

$(function() {
	$("#pay5").click(function() {
		alert('삭제되었습니다.1');
	});

$(function() {
	$("#btn0").click(function() {
		alert('상세보기2');
	});

$(function() {
	$("#btn1").click(function() {
		alert('삭제되었습니다.2');
	});
	
$(function(){
	$("#btn3").click(function(){
		alert('전체삭제하시겠습니까?');
	});	

$(function(){
	$("#btn4").click(function(){
		alert('결제하시겠습니까?');			
	});
		
	});
});
			});
		});
	});
});

</script>

</head>

<body>
	<form name="Mem_count" action="Mem_countProcess.member" method="post">
		<div id="wrap">
			<!-- 헤더부분 -->
			<jsp:include page="../header.jsp" />
			<div id="container">

				<div id="main">
					<div id="content">
						<div id="box1">
							<c:forEach var="b" items="${b}">
								<div id="event1">
									<div class="img">
										<img src="img/${a.store_file}" name="img">
									</div>
									<div class="e_text">
										<a>이벤트명</a><input type="text" name="event_name" placeholder="event_name" value="${b.event_name}"  required readonly><br>
										<a>주최브랜드명</a><input type="text" name="brand_name" placeholder="brand_name" value="${b.store_name}" required readonly><br>
										<a>가격</a><input type="text" id="price" placeholder="price" value="${b.pay_price}"required readonly>
									</div>
								</div>
							</c:forEach>
							
								<div id="event2">
									<a value="${b.mem_name}" name="mem_name">주문자명 : ${b.mem_name}</a><br>
									<a value="${b.mem_phone }" name="phone">휴대폰 번호 :${b.mem_name}</a><br>
								</div>

								<div id="count">
									<a>결제예정금액
										<hr>
									</a> <a>결제방법</a><br> <input type="radio" name="pay1" id="pay1">카드결제(신용/체크카드)
									<div id="div1" class="hide">
										<select style="display: none;" id="select">
											<option>현대카드</option>
											<option>신한카드</option>
											<option>국민카드</option>
											<option>농협카드</option>
											<option>하나카드</option>
											<option>비씨카드</option>
										</select>
									</div>
									<a>실시간 계좌이체</a><input type="radio" id="pay2" required>
									<a>무통장입금</a><input type="radio" id="pay3" required>
									<hr>
									<a>카드번호</a><input type="text" required id="pay4"><br>
									<a>주문자명</a><input type="text" required id="pay5"><br>
									<a>입금계좌번호</a><input type="text" required id="pay6"><br>
									<a>은행</a><input type="text" required id="pay7"><br>
									<a>입금금액</a><input type="text" required id="pay8"><br>
									<a>입금자명</a><input type="text" required id="pay9"><br>
								</div>


								<div id="btn">
									<button class="btn1" onclick="location.href='Mem_Count.member'">결제하기</button>

								</div>
							</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>