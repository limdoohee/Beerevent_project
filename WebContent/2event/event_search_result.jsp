<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script src="js/jquery-3.3.1.js" ></script>
<link href="css/search_result.css" rel="stylesheet" type="text/css">
<!-- <script>

function moreList(){
    $.ajax({
        url : "./eventmorelist.event",
        type : "POST",
        cache : false,
        dataType: 'json',
        data : {},
        success : function(data){
            //console.log(data);
            var content="";
            for(var i=0; i<data.hashMapList.length; i++){
                content +=
                "<tr>"+
                    "<td>"+data.hashMapList[i].area+"</td>"+
                    "<td>"+data.hashMapList[i].name+"</td>"+
                    "<td>"+data.hashMapList[i].gubun+"</td>"+
                    "<td>"+data.hashMapList[i].cnt+"</td>"+
                "</tr>";
            }
            content+="<tr id='addbtn'><td colspan='5'><div class='btns'><a href='javascript:moreList();' class='btn'>더보기</a></div>  </td></tr>";
            $('#addbtn').remove();//remove btn
            $(content).appendTo("#table");
        }, error:function(request,status,error){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
           }
    });
};

</script> -->
</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">
				<div class="layout-page-header">
					<h2>이벤트 검색 결과</h2>
				</div>
				<div id="event">
				<p>검색 조건 <br></p>
				<hr>
				<div id="text">
				<c:if test="${ spot != '' || spot ne null }">
					위치 : ${ spot }<br>
				</c:if>
				날짜 : ${ fromDate } ~ ${ toDate } <br>
				이벤트 타입 : ${ eventType } <br>
				</div>
				<!-- 이벤트가 없을 때 -->
				<c:if test="${ empty eventlist }">
					이벤트가 없습니다.
				</c:if>
		
				<!-- 이벤트가 있을 때 -->
				<c:if test="${ !empty eventlist }">
					<!--  -->
					<c:forEach var="e" items="${eventlist}">
						<div id="eventcontent">
							<div class="img"> <img src="upload/event/${e.event_file}"></div>
							<div class="text">
								<div class="price">₩${ e.event_price }</div>
								<div>타입 :${ e.event_categ }</div>
								<div><a href="EventDetail.event?event_no=${ e.event_no }">${ e.event_name }</a></div>
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
						</div>
					</c:forEach>
				</c:if>
			</div><!-- content끝 -->
			</div>
		</div>
	</div>
</div>
</body>