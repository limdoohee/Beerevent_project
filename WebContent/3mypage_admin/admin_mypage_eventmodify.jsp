<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="js/jquery-3.3.1.js" ></script>

<script src="js/event_detail.js" ></script>
<!-- <link href="css/event_detail2.css" rel="stylesheet" type="text/css">  -->

<style type="text/css">
body {
	margin : 0;
	text-align : center;
}
#key {
	height:250px;
}
h2 {
	padding: 100px;
	color : #fff;
}
#eventdetail {
	width: 100%;
	background-color: white;
	padding: 10px;
}
img {
    width: 380px;
    height: 250px;
    float: left;
    margin-left:40px;
    margin-top:4%;
    padding-right:23px;
}
#box2 {
	margin:0 auto;
}
table {
	margin: 0 auto;
	border: 1px solid black;
	text-align: center;
}
tr {
	height: 50px;
}
th {
	color: white;
	background-color: gray;
}
td {
	border: 1px solid black;
	width:300px;
}
#box1, #box2{
    border:1px solid gray;
    width:1000px;
    height:1200px;
    margin:0 auto;
    margin-top:30px;
}
.btn1{
   background:#3498DB;
    color:white;
    border:none;
    cursor:pointer;
    width:200px;
    height:50px;
    font-size:1em;
    
}
</style>
</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		
		<c:set var="e" value="${ event }" />
		<%-- <c:set var="d" value="${ eventdate }" /> --%>
		<div id="key">
		<h2>이벤트 상세조회</h2>
		</div>
		<!-- 이벤트 정보 뽑아오는 div -->
		<div id="eventdetail">
			<!-- 이벤트가 없을 때 -->
			<c:if test="${ empty event }">
				이벤트를 가져오는데 오류가 발생하였습니다.
			</c:if>
			<c:if test="${ !empty event }">
			<%-- <c:set var="d" value=""> --%>
				<div id="box2">
					<br><br>* 이벤트 조회<br>
					<form>
						<table>
							<tr>
								<th colspan="2">이벤트 이름</th>
								<td colspan="2"><input type="text" name="event_name" value="${ event.event_name }"></td>
							</tr>
							<tr>
								<td colspan="2"><input type="text" name="event_file" value="${ event.event_file }"></td>
								<th>번호</th>
								<td>${ event.event_no }</td>
							</tr>
							<tr>
								<th>이벤트 타입</th>
								<td>
									<select name="evet_categ">
										<option value="">★스크립트로 값 뽑아오기</option>
										<option value="클래스">클래스</option>
										<option value="시음회">시음회</option>
									</select>
									${ event.event_categ }
								</td>
								<th>가격</th>
								<td><input type="text" name="event_price" value="${ event.event_price }"></td>
							</tr>
							<tr>
								<th>시간</th>
								<td><input type="text" name="event_time" value="${ event.event_time }"></td>
								<th>위치</th>
								<td><input type="text" name="event_location" value="${ event.event_location }"></td>
							</tr>
							<tr>
								<th>스팟</th>
								<td>
									<select name="event_spot">
										<option value="">★스크립트로 값 뽑아오기/select복붙해오기</option>
									</select>
									${ event.event_spot }
								</td>
								<th>설명</th>
								<td>
									<textarea rows="10" cols="50" name="event_description" value="${ event.event_description }">
									</textarea>
									${ event.event_description }
								</td>
							</tr>
						</table>
						<br><br>* 날짜 조회<br>
						<%-- <table>
							<tr>
								<th>번호</th>
								<th>날짜</th>
								<th>신청인원</th>
							</tr>
							<c:forEach  var="d" items="${ eventdate }">
							<tr>
								<td>${ d.edate_unique_no }</td>
								<td>${ d.edate_date }</td>
								<td>${ d.edate_num_of_pp }</td>
							</tr>
							</c:forEach>
						</table> --%>
						<br><br>
						<input type="submit" value="수정"><br>
					</form>
					
					
					<form>
   <table border="1">
      <tr>
         <td colspan=3>이벤트 명 &nbsp;
         <input type="text" name="name" id="in1" value="${ event.event_name }"> </td>
      </tr>
      
      <tr>
         <td colspan=3>이벤트 타입  ★(스크립트처리)
            <select name="categ" id="categ">
            <option value="">★스크립트로 값 뽑아오기</option>
               <option value="시음회">시음회</option>
               <option value="클래스">클래스</option>
            </select>${ event.event_categ }
         </td>
      </tr>
      
      <tr>
         <td>이벤트 날짜 ★(어케뽑아올지..)
            <div id="datediv">
               <input type="date" id="in2">
               <input type="button" id="btn1" value="+">
      <!-- &nbsp;&nbsp;<input type="button" id="btn2" value="x"> -->
            </div>
         </td>
         
         <td>이벤트 시간
            <div>
               <input type="time" name="price" onchange="checknum" > ~ 
                   <input type="time" name="price" id="in3" >
            </div></td>
            
            
         <td>가격 
            <div>
         <input type="number" name="price" id="in3" 
                     value="${ event.event_price }">
      </div></td>
      </tr>
      
      
      <tr>
      <td colspan="2">주소
         <input type="text" name="location" value="${ event.event_location }">
      </td>
      <td colspan="1">스팟 ★(스크립트처리)
         <div>
         <select name="spot" id="spot">
               <option value="">(선택사항) 지역</option>
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
         <textarea name="description" cols=125 rows=15 id="in4">${ event.event_description }</textarea>
         </td>
      </tr>
      
      <tr>
         <td>이벤트 관련 이미지 첨부파일★(얘는 어케하지..?)&nbsp;&nbsp;
         <input type="file" name="file" value="${ event.event_file }">
         </td>
      </tr>
   </table>
         <br>
         <span style="float:right">
         <input type="reset" value="취소"></span>
         
         <span style="float:right">
         <input type="submit" value="등록" onclick="alert('등록되었습니다')"></span>
      </form>   
					
				</div>
				
			</c:if>
		</div>
		
</div>
</div>
</body>
</html>