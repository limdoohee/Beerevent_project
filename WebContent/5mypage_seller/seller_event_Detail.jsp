<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<script src="js/jquery-3.3.1.js"></script>
<script>
</script>

<style>

#wrap{
    margin:0 auto;
}


.e_detail{  font-size:1em;
			width:1000px;
			height: 50px;
			padding-top:20px;
   			padding-left:41px;
			text-align:center
}
		   

</style>
</head>

<body>
    <div id="wrap">
            <%--    <jsp:include page="../header.jsp"/> --%>
		<table border="1" width="1000">
			<tr>
				<th align="center" colspan="10">이벤트 정보</th>
 	         </tr> 
 	         
 	        <tr class="e_detail">
 	        	<td>이벤트 번호</td>
 	        	<td>이벤트 이름</td>
 	        	<td>이벤트 종류</td>
 	        	<td>이벤트 가격</td>
 	        	<td>이벤트 시간</td>
 	        	<td>이벤트 장소</td>
 	        	<td>이벤트 스팟</td>
 	        	<td>이벤트 파일</td>
 	        	<td>이벤트 설명</td>
 	        </tr>
 	        <c:forEach items="${requestScope.list_all }" var ="list_all">
 	        	<tr align="center">
 	        		<td>${list.all.event_no}</td>
 	        		<td>${list.all.event_name}</td>
 	        		<td>${list.all.event_categ}</td>
 	        		<td>${list.all.event_price}</td>
 	        		<td>${list.all.event_time}</td>
 	        		<td>${list.all.event_location}</td>
 	        		<td>${list.all.event_spot}</td>
 	        		<td>${list.all.event_file}</td>
 	        		<td>${list.all.event_description}</td>
 	        
 	        </c:forEach>
 	        
 	</table>
        </div>
    
</body>
</html>