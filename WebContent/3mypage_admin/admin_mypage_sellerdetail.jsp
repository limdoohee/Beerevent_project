<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/event_detail2.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.3.1.js"></script>
</head>
<body>

<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">
				<div id="key">
					<h2>판매자 정보 조회</h2>
				</div>
				<div id="seller-box">
					<table>
						<tr>
							<td>이름</td>
							<td>${ seller.seller_name }</td>
						</tr>
						<tr>
							<td>사업자등록번호</td>
							<td>${ seller.seller_bs_no }</td>
						</tr>
						<tr>
							<td>아이디</td>
							<td>${ seller.seller_id }</td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td>${ seller.seller_pass }</td>
						</tr>
						<tr>
							<td>주민번호</td>
							<td>${ seller.seller_jumin }</td>
						</tr>
						<tr>
							<td>핸드폰번호</td>
							<td>${ seller.seller_phone }</td>
						</tr>
						<tr>
							<td>이메일</td>
							<td>${ seller.seller_email }</td>
						</tr>
					</table>
				</div>
				
				<div id="store-box">
				<c:forEach var="s"  items="${ storelist }">
					<table>
						<tr>
							<td>가게 번호</td>
							<td>${ s.store_no }</td>
						</tr>
						<tr>
							<td>사업자등록번호</td>
							<td>${ s.store_registent_no }</td>
						</tr>
						<tr>
							<td>가게 이름</td>
							<td>${ s.store_name }</td>
						</tr>
						<tr>
							<td>가게 위치</td>
							<td>${ s.store_location }</td>
						</tr>
						<tr>
							<td>메뉴</td>
							<td>${ s.store_menu }</td>
						</tr>
						<tr>
							<td>휴점 요일</td>
							<td>${ s.store_dayofweek }</td>
						</tr>
						<tr>
							<td>사진띠</td>
							<td>${ s.store_file }</td>
						</tr>
					</table>
				</c:forEach>
				</div>

			</div>
		</div>
	</div>
</div>
</body>
</html>