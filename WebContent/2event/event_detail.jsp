<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="js/jquery-3.3.1.js" ></script>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/event_detail.css" rel="stylesheet" type="text/css">
<style>
#review{
	width: 65%;
    background: rgba(255,255,255,.8);
    min-width: 1024px;
    margin: 30px auto 70px;
    padding: 20px 0;
}
</style>
<script>
$(document).ready(function(){	
	$('#store_detail').click(function(){
		window.open(this.href, 'testWindow', 'width=1010, height=400, top=200, left=300', '_blank');
		return false;
	});
	$('#wish').click(function(){
		var login_type =  "<%=(String)session.getAttribute("login_type")%>";
		if(login_type == 'member'){
			var con = confirm('해당 상품을 찜목록에 추가하시겠습니까?');
			if(con == true){
				location.href="addBookmark.member?event_no=${event.event_no}";
			}
			else if(con == false){
				return;
			}
		} else if(login_type == 'seller' || login_type == 'admin') {
			alert("회원만 찜목록 이용이 가능합니다.");
		} else {
			alert("찜 하려면 로그인 후 이용해주세요.");
		}
	});
	$('#order').click(function(){
		var login_type =  "<%=(String)session.getAttribute("login_type")%>";
		if(login_type == 'member'){
			if($('#select-date').val() == "") 
				alert("결제 할 날짜를 선택하세요.");
			else
				$("form").submit();
		} else if(login_type == 'seller' || login_type == 'admin') {
			alert("회원만 결제할 수 있습니다.");
		} else {
			alert("결제는 로그인 후 이용해주세요.");
		}
	});
});
</script>
</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		
		<c:set var="e" value="${ event }" />
		<c:set var="d" value="${ eventdate }" />
		<div class="layout-page-header">
			<h3>이벤트 상세보기</h3>
		</div>
		<!-- 이벤트 정보 뽑아오는 div -->
		<div id="eventdetail">
			<!-- 이벤트가 없을 때 -->
			<c:if test="${ empty event }">
				<p>이벤트를 가져오는데 오류가 발생하였습니다.</p>
			</c:if>
			<c:if test="${ !empty event }">
			 <c:set var="e" value="${ event }" />
				<div id="box2">
				<form action="eventOrder.member">
					<div id="event1">
						<div class="img"><img src="upload/event/${ e.event_file }"><input type="hidden" name="event_file" value="${ e.event_file }"></div>
						<div class="e_text" >
								<input type="hidden" name="event_no" value="${ e.event_no }">
								<ul class="event">
									<li><span>스팟</span><input type="text" id="event_spot"  name="event_spot" value="${ e.event_spot }" required readonly></li>
									<li><span>이벤트타입</span><input type="text" id="event_name"  name="event_categ" value="${ e.event_categ }" required readonly></li>
									<li><span>이벤트명</span><input type="text" id="event_name" name="event_name" value="${ e.event_name }"required readonly></li>
									<li><span>이벤트 설명</span><input type="text" id="brand_name"  name="event_description" value="${ e.event_description }" required readonly></li>
									<li><span>가격</span><input type="text" id="price" name="event_price" value="${ e.event_price }" required readonly></li>
									<li><span>날짜</span><select name="e_date" id="select-date">
													<option value="">====회차를선택하세요====</option>
												<c:forEach  var="d" items="${ eventdate }"><option value="${ d.edate_unique_no }">
															${ d.edate_date } [ 신청인원: ${ d.edate_num_of_pp }/20 ]
														</option>
													</c:forEach>
												</select>
									</li>
								<li><span>가게정보</span><a id="store_detail" href="EventStoreView.event?store_no=${ event.store_no }"> ${ param.store_name } </a></li>
								</ul>
								<div class="btn_area">
									<input type="button" id="wish" value="찜">
									<input type="button" id="order" value="바로 구매">
								</div>
						</div>
		         
		      		</div>
		      	</form>
				</div>
				
			</c:if>
		</div>
		
		<!-- 후기...하...후기는 어케 뽑아오니? -->
		<div id="review">
<%-- 게시글이 있는 경우--%>
<c:if test="${list_total_count > 0 }">
<div class="review-title">
<h3>reveiw</h3>
</div>
<table id="table"> 
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
</table>
</c:if>
<c:if test="${list_total_count == 0 }">	
<table>	
	<!-- 레코드가 없으면 -->
	   <tr>
		<td colspan="5" style="text-align:right">
			등록된 글이 없습니다.
		</td>
	  </tr>
</table>
</c:if>
		</div> <!-- review div 끝 -->
</div>
</div>
</body>
</html>