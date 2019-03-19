<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<script src="js/event_search_1.js" ></script>
<link href="css/search.css" rel="stylesheet" type="text/css">
<script>
$(function(){
	$("select , #toDate, #fromDate").click(function(){
		$(this).css({"background":"#fff","color":"#000"});
		})
})
</script>

</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">
			
				<div id="key">
					<img src="./img/fireworks.png">
					<h1>이벤트 검색</h1>
				</div>
				
				<div id="formdiv">
					<form action="searchResult.event" method="post">
						<div id="search_form">
							<!-- 위치검색 -->
							<div>
								<p id="event_loca">위치</p>
								<!-- <input type="text" name="spot" id="spot"
								placeholder="ex) 이태원, 잠실, 청담 등"> -->
								<select name="spot" id="spot">
									<option value="">(선택사항) 지역</option>
									<option value="강남구">강남구</option>
									<option value="강북구">강북구</option>
									<option value="관악구">관악구</option>
									<option value="구로구">구로구</option>
									<option value="금천구">금천구</option>
									<option value="노원구">노원구</option>
									<option value="동대문구">동대문구</option>
									<option value="마포구">마포구</option>
									<option value="서대문구">서대문구</option>
									<option value="서초구">서초구</option>
									<option value="성북구">성북구</option>
									<option value="송파구">송파구</option>
									<option value="영등포구">영등포구</option>
									<option value="용산구">용산구</option>
									<option value="종로구">종로구</option>
								</select>
							</div>
							
							<div id="list"></div>
							<!-- 날짜검색 -->
							<div id="event_detail_search">
								<ul>
									<li>
										<p>시작일 </p>
										<input type="text" name="fromDate" id="fromDate" class="date">
									</li>
									<li>
										<p>종료일 </p>
										<input type="text" name="toDate" id="toDate"  class="date">
									</li>
									<!-- <div id="output"></div> -->
									<li>
										<select name="eventType" id="eventType">
											<option value="">이벤트 종류</option>
											<option value="클래스">클래스</option>
											<option value="시음회">시음회</option>
										</select>
									</li>
									<li>
										<button type="submit">검색</button>
									</li>
								</ul>
							</div>

						</div>
					</form>
				</div>
			
			</div>
		</div>
	</div>
</div>

</body>
</html>