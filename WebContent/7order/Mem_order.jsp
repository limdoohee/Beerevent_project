<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>결제</title>
<link href="css/Countlist.css" rel="stylesheet">
<script src="js/jquery-3.3.1.js"></script>
<link href="css/common.css" rel="stylesheet" type="text/css">
<style type="text/css">
/* #card, #account, #deposit {
	visibility: hidden;
} */
.img {
	width: 200px;
	height: 200px;
	display: table;
	float : left;
}
.img img {
	width: 100%;
	height: 100%;
}
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
		if($("input:radio[name='howPay']").is(":checked") == true){
			var check_val = $("input:radio[name='howPay']:checked").val();
			if(check_val=="1") {
          			if($('#pay_card_name').val() == "") {
          				alert("카드 명의자 이름을 입력하세요.");  
          				$('#pay_card_name').focus();  
						return false; 
          			};
          			if($('#pay_card_no').val() == "") {
          				alert("카드 번호를 입력하세요.");  
          				$('#pay_card_no').focus();  
						return false; 
          			};
          			if($('#pay_card_cvc').val() == "") {
          				alert("카드 cvc를 입력하세요.");  
          				$('#pay_card_cvc').focus();  
						return false; 
          			};
			}
			else if(check_val=="2") {
            		if($('#pay_account_no').val() == "") {
          				alert("계좌번호를 입력하세요.");  
          				$('#pay_account_no').focus();  
						return false; 
          			};
          			if($('#pay_account_pass').val() == "") {
          				alert("계좌 비밀번호를 입력하세요.");  
          				$('#pay_account_pass').focus();  
						return false; 
          			};
			}
			else if(check_val=="3") {
            		if($('#pay_deposit_name').val() == "") {
          				alert("입금자명을 입력하세요.");  
          				$('#pay_deposit_name').focus();  
						return false; 
          			};
			}
			var con = confirm('결제하시겠습니까?');
			if(con == true) {
				('form').submit();
			} else {
				return false;
			}
		}else{
			alert('결제 방법을 선택하세요.');
			$('#agree').focus();
			return false;
		}
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
					<h2>주문서</h2>
				</div>
            <div id="eventdetail">
	            <form action="orderProcess.member" method="post">
	            <input type="hidden" name="edate_unique_no" value="${edate_unique_no}">
	            <input type="hidden" name="event_no" value="${event_no}">
					<div id="event1">
						<div class="img"><img src="upload/event/${event_file}"></div>
						<div class="e_text" >
						<ul class="event">
						<li><span>이벤트 타입</span><input type="text" value="${event_categ}" required readonly></li>
							<li><span>이벤트명</span><input type="text" value="${event_name}" required readonly></li>
							<li><span>가격</span><input name="event_price" type="text" value="${event_price}" required readonly></li>
							<li><span>날짜</span><input type="text" value="${edate_date}" required readonly></li>
							
							<li><span>이벤트 주최지</span><input name="event_price" type="text" value="${event_spot}" required readonly></li>
							<li><span>이벤트 설명</span><input type="text" value="${edate_description}" required readonly></li>
						</ul>
						</div>
	             	</div>
	
	<%-- 	            <div id="event2">
		                <a>주문자명</a><br>
		                <c:set>입력값 받아오기
		                <a>휴대폰 번호</a><br>
		                <c:set>입력값 받아오기
		            </div> --%>
	
					<hr>
					
		            <div id="count">
		                <a>결제방법 : 카드이체 or 실시간 계좌이체 or 무통장 입금</a><br>
		                <div>
							<input type="radio" name="howPay" id="cardRadio" value="1"> 카드
							<input type="radio" name="howPay" id="accountRadio" value="2"> 실시간계좌이체
							<input type="radio" name="howPay" id="depositRadio" value="3"> 무통장입금
							<div id="card">
								이름: <input type="text"  name="pay_card_name" id="pay_card_name" size=5><br>
								카드번호: <input type="text"  name="pay_card_no" id="pay_card_no" size=20><br>
								cvc: <input type="text"  name="pay_card_cvc" id="pay_card_cvc" size=5>
							</div>
							<div id="account">
								계좌번호: <input type="text"  name="pay_account_no" id="pay_account_no" size=20><br>
								비밀번호: <input type="text"  name="pay_account_pass" id="pay_account_pass" size=5>
							</div>
							<div id="deposit">
								입금자명 : <input type="text"  name="pay_deposit_name" id="pay_deposit_name" size=9><br>
								입금은행 : KB국민은행 [ 669701-04-018846 / ????? ]
							</div>
						</div>
						<a>결제예정금액</a><br>
		            </div>
		            <div id="btn2">
		                <button class="btn1" id="order">결제하기</button>
		            </div>
		        </form>
        	</div>
    	</div>
	</div>
</div>
</div>
</body>
</html>