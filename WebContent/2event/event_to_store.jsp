<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="css/Wishlist.css" rel="stylesheet">
<link href="css/common.css" rel="stylesheet" type="text/css">

<!-- <script src="js/event_detail.js" ></script> -->
<style>
 #box1 {
 	background : rgba(255,255,255,.8);
 }
</style>
</head>
<body>
<div id="box1">
	<div class="image"><img src="upload/store/${ store.store_file }"></div>
	<div class="e_text">
		<ul class="event_ul">
			<li class="event_li"><span>가게 이름</span><input type="text" id="store_name" value="${ store.store_name }" required readonly></li>
			<li class="event_li"><span>가게 위치</span><input type="text" id="store_location" value="${ store.store_location }" required readonly></li>
			<li class="event_li"><span>가게 메뉴</span><input type="text" id="store_menu" value="${ store.store_menu }"  required readonly></li>
			<li class="event_li"><span>가게 휴무</span><input type="text" id="store_dayofweek" value="${ store.store_dayofweek }" required readonly></li>
			<li class="event_li"><span>가맹주 ID</span><input type="text" id="seller_id" value="${ store.seller_id }" required readonly></li>
		</ul>
	</div>
</div>
</body>
</html>