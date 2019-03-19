<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/mypage_common.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/ajax.js"></script>
<script type="text/javascript">
	$(function() {
		
		//탭 바뀌는 거
		$('ul.tabs li').click(function () {
			var tab_id = $(this).attr('data-tab');
			
			$('ul.tabs li').removeClass('current');
			$('.tab-content').removeClass('current');
			
			$(this).addClass('current');
			$("#"+tab_id).addClass('current');
		});
		
		
		//각 버튼별로 페이지 이동
		//혜림언니 수정, 삭제 폼 만들면 링크달기
		$('#modify').on('click', function() {
			location.href="";
		});
		$('#delete_sel').on('click', function() {
			location.href="";
		});
		$('#delete-temp').on('click', function() {
			location.href="";
		});
		
		
	});
</script>
</head>
<body>

<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">
				<div id="key">
					<h2>판매자 정보 조회</h2>
				</div>
				<div id="tap-all">
				
				<ul class="tabs">
					<li class="tab-link current" data-tab="tab-1">판매자 회원</li>
					<li class="tab-link" data-tab="tab-2">판매자 신청리스트</li>
				</ul>
				<div id="tab-1" class="tab-content current">
					<div id="ajax">
						<table id="table">
							<tr>
								<th>번호</th><th>아이디</th><th>이름</th><th>사업자등록번호</th><th></th>
							</tr>
							<c:forEach var="slist" items="${ sellerList }"  varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td>${ slist.seller_id }<input type="hidden" value="${ slist.seller_id }" class="sel_PK"></td>
								<td>${ slist.seller_name }</td>
								<td>${ slist.seller_bs_no }</td>
								<td><button id="store-detail"><a href="sellerDetail.admin?seller_id=${ slist.seller_id }" >상세정보</a></button><button class="delete-sel">삭제</button></td>
							</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				
				
				<div id="tab-2" class="tab-content">
						<table id="table">
							<tr>
								<th>번호</th><th>아이디</th><th>이름</th><th>사업자등록번호</th><th></th>
							</tr>
							<c:forEach var="st" items="${ stempList }" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td>${ st.stemp_id }<input type="hidden" value="${ st.stemp_id }" class="stemp_PK"></td>
								<td>${ st.stemp_name }</td>
								<td>${ st.stemp_bs_no }</td>
								<td><button class="approval-temp">승인</button><button class="delete-temp">거부</button></td>
							</tr>
							</c:forEach>
						</table>
				</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>