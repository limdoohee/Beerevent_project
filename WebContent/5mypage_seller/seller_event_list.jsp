<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="js/jquery-3.3.1.js" ></script>
<script type="text/javascript">
$('.btn0').click(function() {
	eventDetail.admin
});
</script>
<link href="css/seller_event_list.css" rel="stylesheet" type="text/css">


</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">
				<div id="key">
				<h2>이벤트 조회</h2>
				</div>
				
				<div id="event">
				<!-- 이벤트가 없을 때 -->
				<c:if test="${ empty eventlist }">
					등록된 이벤트가 없습니다.
				</c:if>
		
				<!-- 이벤트가 있을 때 -->
				<c:if test="${ !empty eventlist }">
					<!-- 가게별로 출력  -->
					<c:forEach var="s" items="${storelist}">
						<div id="store">
							<h3>가게 이름 : ${s.store_name}</h3>
							
							<!-- 가게에 해당하는 이벤트 출력  -->
							<c:forEach var="e" items="${eventlist}">
								<c:if test="${ e.store_no!=s.store_no}">
								등록된 이벤트가 없습니다.
								</c:if>
								<c:if test="${ e.store_no==s.store_no}">
									<div id="eventcontent">
									
									
										<div class="img"> <img src="upload/event/${e.event_file}"></div>
										
										
										<div class="text">
											<div class="type">타입 :${ e.event_categ }</div>
											<div><a href="EventDetail.event?event_no=${ e.event_no }">${ e.event_name }</a></div>
											
											
											<div class="price">₩${ e.event_price }</div>
											
											
											<div class="date">
												<div>
												<%-- ${ e.edate_date } --%>
						 						<c:forEach var="d" items="${ eventdate }">
													<c:if test="${ d.event_no ==e.event_no}">
														${ d.edate_date } [ ${ d.edate_num_of_pp }/20] <br>
													</c:if>
												</c:forEach>
											
											
												</div>
											</div>
										</div>
										<div><button class="btn0">이벤트 상세 보기</button></div>
									</div>
								</c:if>
							</c:forEach>
						</div>
						
					</c:forEach>
				</c:if>
			</div><!-- content끝 -->
			</div>
		</div>
	</div>
</div>
</body>