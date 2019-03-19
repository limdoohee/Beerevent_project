<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>결제확인</title>
<link href="css/Countlist.css" rel="stylesheet">
<script src="js/jquery-3.3.1.js"></script>
<style>
</style>

</head>
<body>
<form name="Mem_countlist" action="Mem_countlistProcess.member" method="post">
    <div id="wrap">
    <!-- 헤더부분 -->
            <jsp:include page="../header.jsp"/>
        <div id="container">
	<div id="main">
			<div id="content">
            <div id="box1">
                <div id="event1">
                  <div class="img"><img src="img/img1.png"></div>
                  <div class="e_text" >
                  <a>이벤트명</a><input type="text" id="event_name" placeholder="event_name" required readonly><br>
                  <a>주최브랜드명</a><input type="text" id="brand_name" placeholder="brand_name" required readonly><br>
                  <a>가격</a><input type="text" id="price" placeholder="price" required readonly>
                </div>
           
             </div>

            <div id="event2">
                <a>주문자명</a><br>
                <%-- <c:set>입력값 받아오기 --%>
                <a>휴대폰 번호</a><br>
                <%-- <c:set>입력값 받아오기 --%>
            </div>


            <div id="count">
                <a>결제예정금액</a><br>
                <a>결제방법 : 카드이체 or 실시간 계좌이체 or 무통장 입금</a>
                <hr>
                <a>카드번호</a><input type="text" required readonly name="cardnum1"><br>
                <a>주문자명</a><input type="text" required readonly><br>
                <a>입금계좌번호</a><input type="text" required readonly><br>
                <a>은행</a><input type="text" required readonly><br>
                <a>입금금액</a><input type="text" required readonly><br>
                <a>입금자명</a><input type="text" required readonly><br>
            </div>
            <div id="btn2">
                <button class="btn1">주문 내역 확인하기</button>
                <button class="btn1">메인으로 이동</button>
            </div>
        </div>
    </div>
    </div>
    </div>
</div>
</form>
</body>
</html>