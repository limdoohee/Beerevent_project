<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>결제</title>
<link href="css/Countlist.css" rel="stylesheet">
<script src="js/jquery-3.3.1.js"></script>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/Countlist.css" rel="stylesheet">
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

/* function checkRadio()  
{ 
     var howPay = document.getElementsByName("howPay"), howCheck = null; 
     for(var i = 0; i < howPay.length; i++) { 
            if(howPay[i].checked) { 
                   howCheck = i; 
            } 
     } 
     if(howCheck === null) { 
            alert("결제방법을 체크하시고 결제 정보를 입력해주세요."); 
            howPay[0].focus(); 
            return false; 
        } else { 
            switch(howCheck) { 
                   case 0: 
                       if (newMem.muName.value == "") {  
                          alert("입금자명을 입력하세요.");  
                          newMem.muName.focus();  
                          return false; 
                   } 
                       break; 
                   case 1: 
                        if (newMem.cardNo.value == "") {  
                           alert("카드번호를 입력하세요.");  
                           newMem.cardNo.focus();  
                           return false;  
                     }  
                     if (newMem.cardPwd.value == "") {  
                           alert("카드 비밀번호를 입력하세요.");  
                           newMem.cardPwd.focus();  
                           return false;  
                     }  
                       break; 
                   case 2: 
                       if (newMem.passNo.value == "") {  
                               alert("계좌번호를 입력하세요.");  
                               newMem.passNo.focus();  
                               return false;  
                         }  
                         if (newMem.passPwd.value == "") {  
                               alert("계좌 비밀번호를 입력하세요.");  
                               newMem.passPwd.focus();  
                               return false;  
                         }  
                       break; 
                   default: 
                       //에러 
                       break; 
            } 
            newMem.submit();
     }  
}   */
</script>
</head>
<body>
    <div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">
			<div id="key">
				<h2>주문</h2>
			</div>
            <div id="box1">
	            <form action="orderProcess.member" method="post">
	            <input type="hidden" value="${edate_unique_no}">
	            <input type="hidden" value="${event_no}">
					<div id="event1">
						<div class="img"><img src="img/img1.png"></div>
						<div class="e_text" >
							<a>이벤트명</a><input type="text" value="${event_name}" required readonly><br>
							<a>가격</a><input type="text" value="${event_price}" required readonly><br>
							<a>날짜</a><input type="text" value="${edate_date}" required readonly>
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
							<input type="radio" name="howPay" id="cardRadio"> 카드
							<input type="radio" name="howPay" id="accountRadio"> 실시간계좌이체
							<input type="radio" name="howPay" id="depositRadio"> 무통장입금
							<div id="card">
								이름: <input type="text"  name="pay_card_name" size=5><br>
								카드번호: <input type="text"  name="pay_card_no" size=20><br>
								cvc: <input type="text"  name="pay_card_cvc" size=5>
							</div>
							<div id="account">
								계좌번호: <input type="text"  name="pay_account_no" size=20><br>
								비밀번호: <input type="text"  name="pay_account_pass" size=5>
							</div>
							<div id="deposit">
								입금자명 : <input type="text"  name="pay_deposit_name" size=9><br>
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