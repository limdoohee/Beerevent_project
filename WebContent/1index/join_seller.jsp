<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>판매자회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/join.css" rel="stylesheet" type="text/css">
<link href="css/common.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/jquery-1.12.4.min.js"></script>
</head>
<body>
<div id="wrap">
	<div id="container">
		<jsp:include page="../header.jsp"/>
		<div id="main">
			<div id="content">
				<div class="page_location">
					<a href="/">홈</a>
					&gt;
					<strong class="current">판매자회원가입</strong>
				</div>
				<div class="layout-page-header">
					<h2>판매자 회원가입</h2>
				</div>
				<form method=post action=join_seller_process.net name=join_seller>
					<div class="joinWrite">
					<table>
						<tr>
							<td class="memberCols1">아이디</td>
							<td class="memberCols2"><input type=text name=seller_id size=15 maxlength=15 required placeholder=예:abc123>
								<input type=button id=idcheck name=idcheck  value=중복확인>
								<p class="txt_guide">
									<span class="txt txt_case1 good">6자 이상의 영문 혹은 영문과 숫자를 조합</span>
									<span class="txt txt_case2 bad">아이디 중복확인</span>
								</p>
							</td>
						</tr>
						<tr>
							<td class="memberCols1">비밀번호</td>
							<td class="memberCols2">
								<input type=password name=seller_pass id=pass size=20 maxlength=20 placeholder="비밀번호를 입력해주세요.">
								<p class="txt_guide">
									<span class="txt txt_case1">10자 이상 입력</span>
									<span class="txt txt_case2">영문/숫자 조합</span>
								</p>
							</td>
						</tr>
						<tr>
							<td class="memberCols1">비밀번호 확인</td>
							<td class="memberCols2">
								<input type=password id=seller_pass_con name=seller_pass_con size=20 maxlength=20 placeholder="비밀번호를 한번 더 입력해주세요"  required>
								<p class="txt_guide">
									<span class="txt txt_case1">10자 이상 입력</span>
									<span class="txt txt_case2">영문/숫자 조합</span>
								</p>
							</td>
						</tr>
						<tr>
							<td class="memberCols1">이름</td>
							<td class="memberCols2">
								<input type=text id=name name=seller_name size=7 maxlength=7 required placeholder="이름을 입력해주세요">
							</td>
						</tr>
						<tr>
							<td class="memberCols1">주민번호</td>
							<td class="memberCols2">
								<input type=text id=jumin1 name=seller_jumin1 size=6 maxlength=6 required placeholder="예:801201">
								&ndash;
								<input type=text id=jumin2 name=seller_jumin2 size=1 maxlength=1 required> ××××××
							</td>
						</tr>
						<tr>
							<td class="memberCols1">휴대폰</td>
							<td class="memberCols2">
								<input type=text id=mobile1 name=seller_phone1 size=4 maxlength=3 required placeholder="010">	&ndash;
								<input type=text id=mobile2 name=seller_phone2 size=4 maxlength=4 required>	&ndash;
								<input type=text id=mobile3 name=seller_phone3 size=4 maxlength=4 required>
								<input type=button id=mobilecheck name=mobilecheck  value=인증번호받기>
								<div class="cert_confirm_row">
									<input type=text name=check_code id=check_code size=6 maxlength=6 disabled>
									<input type=button id=cert_button name=cert_button  value=인증번호확인 disabled>
								</div>
							</td>
						</tr>
						<tr>
							<td class="memberCols1">이메일</td>
							<td class="memberCols2">
								<input type=text id=email name=seller_email size= 20 maxlength=20 required>	@
								<input type=text name=seller_domain id=domain size= 20 maxlength=20 required>
								<select name=domain_sel id=domain_sel>
					   	          <option value="">직접입력</option>
					    	      <option value="naver.com">naver.com</option>
					    	      <option value="daum.net">daum.net</option>
					    	      <option value="nate.com">nate.com</option>
					   	          <option value="gmail.com">gmail.com</option>
					   	      </select>
							</td>
						</tr>
						<tr>
							<td class="memberCols1">사업자등록번호</td>
							<td class="memberCols2">
								<input type=text id=bsno1 name=bsno1 size=4 maxlength=3 required>	&ndash;
								<input type=text id=bsno2 name=bsno2 size=4 maxlength=2 required>	&ndash;
								<input type=text id=bsno3 name=bsno3 size=4 maxlength=5 required>
							</td>
						</tr>
					</table>
				</div> <!--<div class="joinWrite">  -->
				
				<div class="field_agree">
					<h3>이용약관동의*</h3>
				</div>
				<div class="reg_agree"> <!-- 이용약관 -->
					<div class="check">
						<label class="all_check">
							<input type="checkbox" class="styled-checkbox-black" name="agree_allcheck">
						<span class="txt_checkbox">전체동의</span>
						</label>
					</div>
					
					<div class="check_view">
						<label class="select_check check_agree checked">
							<input type="checkbox" value="y" name="agree" required class="styled-checkbox-black">
							<span class="txt_checkbox">이용약관 <span class="sub">(필수)</span></span>
						</label>
						<a href="#none" class="link btn_link btn_agreement">약관보기 &gt;</a>
					</div>
					
					<div class="check_view">
						<label class="select_check check_agree">
							<input type="checkbox" id="private1" name="private1" value="n" required class="styled-checkbox-black">
							<span class="txt_checkbox">개인정보처리방침 <span class="sub">(필수)</span></span>
						</label>
						<a href="#none" class="link btn_link btn_link2 btn_essential">약관보기 &gt;</a>
					</div>
					
					<div class="check_view">
						<label class="select_check check_agree">
							<input type="checkbox" name="marketing" class="styled-checkbox-black"  value="n">
							<span class="txt_checkbox no_pd">이벤트 및 혜택 알림 수신 <span class="sub">(선택)</span></span>
						</label>
						<div class="check_event email_sms">
							<label class="select_check check_agree">
								<input type="checkbox" name="sms" class="styled-checkbox-black" value="n">
								<span class="txt_checkbox no_pd">SMS</span>
							</label>
							<label class="select_check check_agree">
								<input type="checkbox" name="mailling" class="styled-checkbox-black" value="n">
								<span class="txt_checkbox no_pd">이메일</span>
							</label>
						</div>
					</div>
				</div> <!-- <div id=""reg_agree""> -->
				
				<div class="btn_area">
			         <input type=submit value="가입하기">
			    	<input type=reset value="취소">
		    	</div>
		    	
				</form>
			</div> <!-- <div id=""content""> -->
		</div> <!-- <div id="main"> -->
	</div> <!-- <div id="container"> -->
</div> <!-- <div id="wrap"> -->
</body>
</html>