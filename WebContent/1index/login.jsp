<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/login.css" rel="stylesheet" type="text/css">
<link href="css/common.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/login.js"></script>
</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp"/>
		<div id="main">
			<div id="content">
				<div class="page_location">
					<a href="/">홈</a>
					&gt;
					<strong class="current">로그인</strong>
				</div>
				
				<div class="layout-page-header">
					<h2>로그인</h2>
				</div>
				
				<div class="indiv">
					<div class="layout-bg">
						<div class="layout-wrapper">
						<form method="post" name="login" action="login_member.net">
						<div class="login_wrap ">
							<div class="login_select">
								<label class="container_radio">일반회원
								  <input type=radio name=login id=member checked=checked>
								  <span class="checkmark"></span>
								</label>
								<label class="container_radio">판매자회원
								  <input type=radio name=login id=seller>
								  <span class="checkmark"></span>
								  </label>
							</div>
							<div class="login">
								<ul class="text">
									<li><span>아이디</span></li>
									<li><span>비밀번호</span></li>
								</ul>
								<ul class="input">
									<li><input style="width:180px" id="id" type="text" name="id" size="20" tabindex="1"></li>
									<li><input style="width:180px" id="pass" type="password" name="pass" size="20" tabindex="2"></li>
								</ul>
								<ul class="button">
									<li class="button"><input type="submit" value="회원 로그인" class="bhs_button" style="width:auto; padding:20px 20px;height:86px" tabindex="4"></li>
								</ul>
							</div> <%--<div class="login"> --%>
							
							<div class="login_button">
								<ul>
									<li><a href="#"><span class="bhs_button">아이디 찾기</span></a></li>
									<li><a href="#"><span class="bhs_button">비밀번호 찾기</span></a></li>
									<li><a href="#"><span class="bhs_button" id="join">회원가입</span></a></li>
								</ul>
							</div> <%--<div class="login_button"> --%>
						</div> <%--<div class="login_wrap"> --%>
						</form>
						</div> <%--<div class="layout-wrapper"> --%>
					</div> <%--<div class="layout-bg"> --%>
				</div> <%--<div class="indiv"> --%>
			
		</div> <%--<div class="content"> --%>
	</div><%--<div class="main"> --%>
</div> <%--<div class="container"> --%>
</div> <%--<div class="wrap"> --%>
</body>
</html>