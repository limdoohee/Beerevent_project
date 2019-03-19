<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="js/header.js" ></script>
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/common.css" rel="stylesheet" type="text/css">
<div id="header">
	<div id="topmenu">
		<div id="logo">
			<h1><a href="index.jsp">A G O B</a></h1>
		</div>
		<div id="usermenu">
			<c:if test="${ id !=null && !id.equals('') }">
				<ul>
					<li>${id}님</li>
					<li><a href="mypagecheck.net">마이페이지</a></li>
					<li><a href="logout.net">로그아웃</a></li>
				</ul>			
			</c:if>
			
			<c:if test="${ id==null || id.equals('') }">
				<ul>
					<li><a href="login.net">로그인</a></li>
					<li><a href="join_select.net">회원가입</a></li>
				</ul>			
			</c:if>
		</div>
	</div>
	
	<div id="nav">
		<ul>
			<li><a href="company.net">사이트소개</a></li>
			<li><a href="store_map.do">스토어찾기</a></li>
			<li><a href="BoardList.board">후기게시판</a></li>
			<li><a href="sns.net">소셜네트워크</a></li>
		</ul>
	</div>
</div>
<div></div>