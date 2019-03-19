<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<!-- <script src="js/event_detail.js" ></script> -->
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/mypage_admin.css" rel="stylesheet" type="text/css">
</head>
<body>


<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">
				<div id="key">
					<h1>관리자 마이페이지</h1>
				</div>
				<ul id="box2">
					<li><a href="member.admin"><div class="box1">일반 회원 관리</div></a></li>
					<li><a href="seller.admin"><div class="box1">판매자 회원 관리</div></a></li>
					<li><a href="event.admin"><div class="box1">이벤트 일정 & 주문내역 관리</div></a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
</body>
</html>