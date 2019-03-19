<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/mypage_mem_sel.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/seller_mypage.js"></script>


<title>마이페이지</title>

</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content_sel">
				<div id="key_sel">
					<h1>판매자 마이페이지</h1>
				</div>
				<div id="box2">
				<ul id="inner1">
					<li><a href="sellerModify.seller"><div class="box1">개인 정보 수정</div></a></li>
					<li><a href="storeRegister.seller"><div class="box1" >사업체 등록</div></a></li>
					<li><a href="storeList.seller"><div class="box1" id="s_view">사업체 조회</div></a></li>
				</ul>
				<ul id="inner2">
					<li><a href="eventRegister.seller"><div class="box1">이벤트 등록</div></a></li>
					<li><a href="eventList.seller"><div class="box1" id="e_view">이벤트 조회</div></a></li>
				</ul>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>