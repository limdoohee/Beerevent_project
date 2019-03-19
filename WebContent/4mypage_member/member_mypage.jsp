<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="js/jquery-3.3.1.js"></script>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/mypage_mem_sel.css" rel="stylesheet" type="text/css">
<script>

	$(function(){
		$(".box1_1").onclick(function(){
		/* 	location.hrer="Mem_InfoProcess.member"; */
		});
		
	});
</script>
</head>
<body>
<form name="Mem_main" action="Mem_mainProcess.member" method="post">

	<div id="wrap">
	<!-- 헤더부분 -->
            <jsp:include page="../header.jsp"/>
		<div id="container">
			<div id="main">
				<div id="content">
				<div id="key">
					<h1>일반회원 마이페이지</h1>
				</div>
				<ul id="box2">
					<li><a href="mypageModify.member"><div class="box1">개인 정보 수정</div></a></li>
					<li><a href="myOrderList.member"><div class="box1">주문내역</div></a></li>
					<li><a href="MemberBoardList.board"><div class="box1">게시글</div></a></li>
					<li><a href="bookmark.member"><div class="box1">찜 목록</div></a></li>
				</ul>
		</div>
		</div>
		</div>
	</div>
	</form>
</body>
</html>