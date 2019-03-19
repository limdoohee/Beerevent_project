<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>사업체 조회</title>
<script src="js/jquery-3.3.1.js"></script>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/seller_store_view.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">
				<div id="key">
					<h2>사업체 조회</h2>
				</div>
				<div>
				<c:forEach var="store" items="${storelist}">
					<div id="view">
						<a>가게 이미지</a>
						<img src="upload/store/${store.store_file}"><br>
						<a>사업체 명</a>
						<input type="text" value="${store.store_name}"><br>
						<a>사업체 전화번호</a>
						<input type="text"  value="${store.store_tel}"><br>
						<a>사업체 주소</a>
						<input type="text"  value="${store.store_location}"><br>
						<input type="reset" id="detail" value="상세보기">
					</div>
				</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>