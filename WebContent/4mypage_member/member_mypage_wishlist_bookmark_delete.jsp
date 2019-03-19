<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="css/Wishlist.css" rel="stylesheet">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/bookmark_delete.js"></script>
<script src="js/delete_all.js"></script>

<c:forEach var="e" items="${elist}">
					<table>
					<tr>
					<td>
						<div id="box1">
							<div id="event1">
							<div class="img"><img src="img/${e.event_file}"></div>
		  						<div class="e_text" >
		          					<a>이벤트명</a><input type="text" id="event_name" value="${e.event_name}" required readonly><br>
		          					<a>타입</a><input type="text" id="event_name" value="${e.event_categ}" required readonly><br>
		          					<a>주최브랜드명</a><input type="text" id="brand_name" value="${a.store_name}"  required readonly><br>
		          					<a>가격</a><input type="text" id="price" placeholder="price" value="${e.event_price}" required readonly>
		  						</div>		   
		      					<button id="btn_0">상세보기</button><br>
		      					<button type="reset" class="btn_1">삭제</button>
							</div>
    					</div>
    					</td>
    					</tr>
    				</table>
</c:forEach>
	