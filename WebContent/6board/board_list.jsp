<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>후기 게시판</title>
 <script src="js/jquery-3.3.1.js"></script>
 <script src="js/list.js"></script>
	<script>
	$(function(){
		$("#viewcount").val("${limit}").prop("selected", true);
	
		$('#onlyMember').click(function(){
			if($('#login_type').val()==""){
				alert("회원 가입 후 글쓰기가 가능합니다.");
				return false;
			}else{
				location.href="./BoardWrite.board";
			}
			});
	});
	
	
 </script>
 <link href="css/common.css" rel="stylesheet" type="text/css">
 <link href="css/board_list.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">
	<input type="hidden" id = "login_type" name="login_type" value="${login_type}">		
<table id="table">
<%-- 게시글이 있는 경우--%> 
<c:if test="${list_total_count > 0 }">
	<tr>
		<td colspan="6">
			글 개수 : ${list_total_count}
		</td>
	</tr>
	<tr>
		<td width="10%"><div>글번호</div></td>
		<td width="25%"><div>이벤트명</div></td>
		<td width="30%"><div>제목</div></td>
		<td width="10%"><div>작성자</div></td>
		<td width="15%"><div>작성일</div></td>
		<td width="10%"><div>조회수</div></td>
		<td colspan="6">
		</td>
	</tr>		
		<c:set var="no" value="${list_total_count-(page-1)*limit}"/>	
	
		<c:forEach var="b" items="${board_bean_list}">	
	<tr>
	  
	  <td>
		<c:out value="${no}"/>	
		<c:set var="no" value="${no-1}"/>	
	  </td>
	  
	  <td>
		<div>
		<a href="EventDetail.event?event_no=${b.event_no}">${b.event_name} </a></div>	
	  </td>
	  
	  <td>     
			<div>
				<a href="./BoardDetailAction.board?no=${b.board_no}">
				${b.board_title}
				</a>
			</div>
	  </td>

	  
	  <td>
			<div>${b.mem_id}</div>
			<input type="hidden" id = "mem_id" name="mem_id" value="${b.mem_id}">
	  </td>	
		
		<td>
			<div>${b.board_date}</div>
		</td>
		<td>
			<div>${b.board_readcount}</div>
		</td>
	</tr>
	</c:forEach>

	<tr>
		<td colspan=6>			
			<c:if test="${page <= 1 }">
				이전&nbsp;
			</c:if>
			<c:if test="${page > 1 }">			
				 <a href="./BoardList.board?page=${page-1}">이전</a>&nbsp;
			</c:if>
					
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<c:if test="${a == page }">
					${a}
				</c:if>
				<c:if test="${a != page }">
					<a href="./BoardList.board?page=${a}">${a}</a>
				</c:if>
			</c:forEach>
			
			<c:if test="${page >= maxpage }">
				&nbsp;다음 
			</c:if>
			<c:if test="${page < maxpage }">
		
				<a href="./BoardList.board?page=${page+1}">&nbsp;다음</a>
			</c:if>
		</td>
	</tr>
</c:if>
</table>


<table>
	<c:if test="${list_total_count == 0 }">		
	<!-- 레코드가 없으면 -->
	   <tr>
		<td colspan="5" style="text-align:right">
			등록된 글이 없습니다.
		</td>
	  </tr>
	</c:if>
	
	  <tr>
		<td colspan="5">
		<!-- <a href =./BoardWrite.board>[글쓰기]</a> -->
	   		<button id="onlyMember">[글쓰기]</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<select id="viewcount">
				<option value="3">3줄 보기</option>
				<option value="5">5줄 보기</option>
				<option value="7">7줄 보기</option>
				<option value="10" selected>10줄 보기</option>
			</select>
		</td>
	</tr>
</table>
</div>
			</div>
		</div>
	</div>
</body>
</html>