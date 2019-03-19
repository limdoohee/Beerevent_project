<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="../js/jquery-3.3.1.js"></script>
<link href="../css/common.css" rel="stylesheet" type="text/css">
<div id="header">
	<div id="usermenu">
		<c:if test="${ id !=null && !id.equals('') }">
			<ul>
				<li><a href="#">${id}님</a></li>
				<li><a href="logout.jsp?id=${id}">마이페이지</a></li>
				<li><a href="logout.jsp">로그아웃</a></li>
			</ul>
			
		</c:if>
		<c:if test="${ id==null || id.equals('') }">
			<ul>
				<li>${id}님</li>
				<li><a href="login.net">로그인</a></li>
				<li><a href="join.net">회원가입</a></li>
			</ul>
			
		</c:if>
	</div>
	
	<div id="nav">
		<ul>
			<li><a href="#">사이트소개</a></li>
			<li><a href="#">스토어찾기</a></li>
			<li><a href="#">후기게시판</a></li>
			<li><a href="#">소셜네트워크</a></li>
		</ul>
	</div>
</div>
