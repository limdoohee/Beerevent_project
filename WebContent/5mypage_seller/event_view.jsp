<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
<style>

#wrap{
    margin:0 auto;
}

#container{
    min-width:1280px;
    border:1px solid gray;
    width:1300px;
    height:830px;
    margin: 0 auto;
}

a {
    font-family: '나눔스퀘어OTF';
    font-size: 1em;
    font-weight: bold;
}

p {
    font-family: '나눔바른고딕';
    font-size: 1em;
}



img {
    width: 250px;
    height: 195px;
    float: left;
    margin-left:40px;
    margin-top:3%;
    padding-right:23px;
}

#box1, #box2{
    border:1px solid gray;
    width:1000px;
    height:303px;
    margin:0 auto;
    margin-top:30px;
}


#box1 input[type=text]{
    width:36%;
    height:32px;
    border:none;
    background:#f1f1f1; 
    float:right;
    margin-right:209px;
    margin-top:10px;
    text-align:center;
}


.e_text input[type=text]{
    width:36%;
    height:32px;
    border:none;
    background:#f1f1f1; 
    float:right;
    margin-right:209px;
    margin-top:20px;
    text-align:center;
}

.e_text{
    line-height:3;
    padding-top:34px;
}

.order{
    padding-top:20px;
    padding-left:41px;

}


.btn1{
   background:#3498DB;
    color:white;
    border:none;
    cursor:pointer;
    width:200px;
    height:50px;
    font-size:1em;
    margin-left:39%;
    margin-top:20px;
}

.btn0{
    background:#adadad;
    color:white;
    border:none;
    cursor:pointer;
    width:80px;
    height:60px;
    font-size:1em;
    margin:12px;
    margin-left:83%;
    position:relative;
    bottom:134px;
}


</style>
<script src="../js/jquery-3.3.1.js"></script>
<script>
   
</script>
</head>
<body>
   <div id="wrap">
      <div id="container">
         <!-- 헤더부분 -->
         <%--    <jsp:include page="../header.jsp"/>
        <jsp:include page="nav.jsp"/> --%>
      <form>    
           <div id="box1">
                   <div id="event1">
                   <div class="order">
                           <a>등록번호</a><br>
                    </div>
                     <div class="img"><img src="img/img1.png"></div>
                     <div class="e_text" >
                        <a>이벤트명</a>
                        	<input type="text" id="event_name" placeholder="event_name" required readonly><br>
                         <a>날짜</a>
                         	<input type="text" id="date" placeholder="date" required readonly><br>
                         <a>가격</a>
                         	<input type="text" id="price" placeholder="price" required readonly><br>
                         <a>결제여부</a>
                         	<input type="text" id="count" placeholder="count" required readonly>
                   </div>
                 </div>
                    <button class="btn0" onclick="location.href='event_Detail.jsp'">이벤트 상세보기</button>
             </div>
      </form>
      </div>
   </div>
</body>
</html>