<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="js/jquery-3.3.1.js"></script>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/seller_event_register.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	$(document).ready(function(){
		$('#btn1').click(function(){
			var plusDate = "";
			plusDate += "<div id='plusDate'><input type='date' name='edate_date'><input type='button' class='btn2' value='지우기'></div>";
			$("#datediv").append(plusDate);
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
					<h2>이벤트 등록</h2>
				</div>
				<div>
				<form action="eventRegisterProcess.seller" method="post" enctype="multipart/form-data">
					<table>
						<tr>
							<td colspan=3>가게 명&nbsp;
							<select name="store_no" id="no">
								<option value="">이벤트를 진행하는 가게를 선택해주세요.</option>
								<c:forEach var="store" items="${storelist}">
									<option value="${store.store_no}">${store.store_name} [사업자등록번호:${store.store_register_no}]</option>
								</c:forEach>
							</select> </td>
						</tr>
						<tr>
							<td colspan=3>이벤트 명 &nbsp;
							<input type="text" name="name" id="name" placeholder="이벤트 명"> </td>
						</tr>
						
						<tr>
							<td colspan=3>이벤트 타입
								<select name="categ" id="categ">
									<option value="">===종류를 선택하세요===</option>
									<option value="시음회">시음회</option>
									<option value="클래스">클래스</option>
								</select>
							</td>
						</tr>
						
						<tr>
							<td>이벤트 날짜 
								<div id="datediv">
									<input type="date" id="date" name="edate_date">
									<input type="button" id="btn1" value="추가">
						<!-- &nbsp;&nbsp;<input type="button" id="btn2" value="x"> -->
								</div>
							</td>
						</tr>
						
						<tr>	
							<td>이벤트 시간
								<div>
									<input type="time" name="time1" onchange="checknum"  id="time1" > ~ 
										 <input type="time" name="time2"  id="time2" >
								</div></td>
								
								
							<td>가격 
								<div>
							<input type="number" name="price" id="price" 
											placeholder="가격을 정해주세요">
						</div></td>
						</tr>
						
						
						<tr>
						<td colspan="1">주소
							<input type="text" name="location" id="location">
						</td>
						<td colspan="2">스팟
							<div>
							<select name="spot" id="spot">
				            	<option value="">===가장 가까운 지역을 선택하세요===</option>
				            	<option value="강남구">강남구</option>
				            	<option value="강남구">강북구</option>
				            	<option value="강남구">관악구</option>
				            	<option value="강남구">구로구</option>
				            	<option value="강남구">금천구</option>
				            	<option value="강남구">노원구</option>
				            	<option value="강남구">동대문구</option>
				            	<option value="강남구">마포구</option>
				            	<option value="강남구">서대문구</option>
				            	<option value="강남구">서초구</option>
				            	<option value="강남구">성북구</option>
				            	<option value="강남구">송파구</option>
				            	<option value="강남구">영등포구</option>
				            	<option value="강남구">용산구</option>
				            	<option value="강남구">종로구</option>
				         </select>
				         </div>
				         </td>
						</tr>
						
						<tr>
							<td colspan=3>
							<textarea name="description" cols=140 rows=17  
								placeholder="&#13;&#10;&#13;&#10;&#13;&#10;&#13;&#10;&#13;&#10;
											 
									 이벤트 과정 간략 소개"></textarea>
							</td>
						</tr>
						
						<tr>
							<td colspan=3>이벤트 관련 이미지 첨부파일&nbsp;&nbsp;
							<input type="file" name="file" id="file">
							</td>
						</tr>
					</table>
					<br>
					
					<span>
					<input type="submit" value="등록" id="sub"></span>
					
					<span>
					<input type="reset" value="취소" id="sub"></span>
					
					
						 <!-- onclick="alert('등록되었습니다')"-->
				</form>	
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>