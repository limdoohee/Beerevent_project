<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>판매자회원_사업체등록</title>
<script src="js/jquery-3.3.1.js"></script>
<link href="css/common.css" rel="stylesheet" type="text/css">
<link href="css/seller_store_register.css" rel="stylesheet" type="text/css">
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
	
	$(document).ready(function(){
		function register(){
			var reg = confirm("등록하시겠습니까??");
			document.location.href="/sellerMypage.seller";
		}
	});
</script>
</head>
<body>

	<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp" />
		<div id="main">
			<div id="content">
			<div class="layout-page-header mypage_modify">
					<h2>사업체 등록</h2>
				</div>
				<form action="storeWriteProcess.seller" method="post" enctype="multipart/form-data">
				<div class="Write">
					<table>
						<tr>
							<td class="Cols1">사업체 명</td>
							<td class="Cols2"><input type="text" name="s_name"></td>
						</tr>
						<tr>
							<td class="Cols1">사업자 등록 번호</td>
							<td class="Cols2"><input type="text" name="s_register"
								 id="li_number" maxlength="12" 
								placeholder="000-00-00000"></td>
						</tr>
						<tr>
							<td class="Cols1">전화번호</td>
							<td class="Cols2"><input type="text" name="s_phone1"  id=mobile1> &ndash;
								<input type="text" name="s_phone2"  id=mobile2> &ndash;
								<input type="text" name="s_phone3"  id=mobile3>
							</td>
						</tr>
	
						<tr>
							<td class="Cols1">사업체 위치</td>
							<td class="Cols2"><input type="text" name="s_location"></td>
						</tr>
	
						<tr>
							<td class="Cols1">휴점 요일</td>
							<td class="Cols2" style="padding-top: 29px;">
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
									<input type="checkbox" name="s_day" id="all-check" value="없음">없음
									
						 	</td>
						</tr>
	
						<tr>
							<td class="Cols1">대표 메뉴 등록</td>
							<td class="Cols2">
								<input type="text" name="s_menu1" id="smg" placeholder="메뉴">
								·············
								<input type="text" name="s_money1" placeholder="가격" id="list">
								<br>
								<input type="text" name="s_menu2" placeholder="메뉴" id="smg">
								·············
								<input type="text" name="s_money2" placeholder="가격" id="list">
								<br>
								<input type="text" name="s_menu3" placeholder="메뉴" id="smg">
								·············
								<input type="text" name="s_money3" placeholder="가격" id="list">
							</td>

							
						</tr>
						<tr>
							<td class="Cols1">파일 등록</td>
							<td class="Cols2" style="padding-top: 29px;"><input type="file" name="Store_file"></td>
						</tr>
					</table>
					</div>
						<div class="btn_area">
							<input type="submit" value="등록하기" onclick="alert('등록되었습니다')" class="sub"> 
							<input type="reset" value="취소" class="sub"></td>
						</div>
				</form>
		</div>
	</div>
	</div>
	</div>
</body>
</html>