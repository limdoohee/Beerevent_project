<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>판매자회원_사업체수정</title>
<style>
body {
	margin: 0;
}




</style>

<script src="../js/jquery-3.3.1.js"></script>
<script src="../js/REGISTENT_NO.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$('#all-check').change(function() {
			if($('#all-check').is(":checked"))
				$('.dayofweek').prop('checked', !$(this).is(":checked"));
		})
		$('.dayofweek').change(function() {
			if($('.dayofweek'
					).is(":checked"))
				$('#all-check').prop('checked', !$(this).is(":checked"));
		})
	});
	
	$(document).ready(function(){
		function licenseNum(str){
	          str = str.replace(/[^0-9]/g, '');
	          var tmp = '';
	          if(str.length < 4){
	              return str;
	          }else if(str.length < 7){
	              tmp += str.substr(0, 3);
	              tmp += '-';
	              tmp += str.substr(3);
	              return tmp;
	          }else{              
	              tmp += str.substr(0, 3);
	              tmp += '-';
	              tmp += str.substr(1, 2);
	              tmp += '-';
	              tmp += str.substr(5);
	              return tmp;
	          }
	          return str;
	      }
	 
	var li_number = document.getElementById("li_number");
	li_number.onkeyup = function(event){
	       event = event || window.event;
	       var _val = this.value.trim();
	       this.value = licenseNum(_val) ;
	}
	
	
	});
	

</script>
</head>
<body>

	<div id="wrap">
		<div id="container">
			<!-- <jsp:include page="../header.jsp" /> -->

			<form action="Seller_mypage.jsp" method="post">
				<h3>사업체 등록</h3>
				<table>
					<tr>
						<td>사업체 명</td>
						<td><input type="text" name="s_name"></td>
					</tr>

					<tr>
						<td>사업체 전화번호</td>
						<td><input type="tel" name="s_phone"></td>
					</tr>

					<tr>
						<td>사업체 주소</td>
						<td><input type="text" name="s_location"></td>
					</tr>
					
					<tr>
						<td>사업자 번호</td>
						<td><input type="text" name="s_registent_no"
								id="li_number" maxlength="12" 
								placeholder="000-00-00000" ></td>
					</tr>
					
					<tr>
						<td>영업시간</td>
						<td><input type="time" name="s_time">&nbsp;- <input
							type="time" name="s_time"></td>
					</tr>

					<tr>
						<td>휴점 요일</td>
						<td>
							<input type="checkbox" name="s_day" class="dayofweek"
								 value="월">월 
							<input type="checkbox" name="s_day" class="dayofweek"
								 value="화">화
							<input type="checkbox" name="s_day"  class="dayofweek"
								 value="수">수 
							<input type="checkbox" name="s_day"  class="dayofweek"
								 value="목">목 
							<input type="checkbox" name="s_day" class="dayofweek"
								 value="금">금
							<input type="checkbox" name="s_day" class="dayofweek"
								  value="토">토
						    <input type="checkbox" name="s_day" class="dayofweek"
								 value="일">일 
								<input type="checkbox" name="s_day" 
								id="all-check" value="없음">없음
								
					 	</td>
					</tr>

			<tr>
						<td>시그니처 메뉴</td>
						<td>
					<a href=#none onclick=this.nextSibling.style.display=(this.nextSibling.style.display=='none')?'block':'none';> 
							클릭하여 메뉴와 가격을 적어주세요
				
				</a><DIV style='display:none'> 
							<input type="text" name="s_menu" id="smg"
							placeholder="메뉴를 적어주세요">············· 
							<input type="text" name="s_money" placeholder="가격을 적어주세요" class="list"><br>
							<input type="text" name="s_menu" placeholder="메뉴를 적어주세요" class="list">·············
							<input type="text" name="s_money" placeholder="가격을 적어주세요" class="list"><br>
							<input type="text" name="s_menu" placeholder="메뉴를 적어주세요" class="list">·············
							<input type="text" name="s_money" placeholder="가격을 적어주세요" class="list">
						</div>
						</td>
						
					
						
					</tr>

					<tr>
						<td><input type="submit" value="수정하기" class="sub"> 
						<input type="reset" value="취소" class="sub"></td>
					</tr>
				</table>
			</form>

		</div>
	</div>
</body>
</html>