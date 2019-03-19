<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <script src="js/jquery-3.3.1.js"></script>
 <script src="js/list.js"></script>
  <link href="css/common.css" rel="stylesheet" type="text/css">
 <link href="css/board_list.css" rel="stylesheet" type="text/css">
<script>
	$(function(){
		$("#viewcount").val("${limit}").prop("selected", true);
	})
 </script>
<table id="list2">
<%-- 게시글이 있는 경우--%> 
<c:if test="${list_total_count > 0 }">
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
		<div>${b.event_name}</div>	
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
		<td colspan=6  id="page_list">			
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