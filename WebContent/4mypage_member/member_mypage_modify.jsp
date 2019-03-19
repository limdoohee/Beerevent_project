<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인정보 수정</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="css/join.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/jquery-1.12.4.min.js"></script>
<script>
$(function() {
	$("#delete").click(function() {
		var con = confirm('탈퇴하시겠습니까?');
		if(con == true){
		  location.href="Mem_DeletProcess.member?id=${sessionScope.id}";
		}
		else if(con == false){
		  return;
		}
	});
});
</script>
</head>
<body>
	<div id="wrap">
	<div id="container">
	  <!-- 헤더부분 -->
            <jsp:include page="../header.jsp"/>
        <div id="main">
			<div id="content">
			<div class="layout-page-header mypage_modify">
					<h2>개인정보수정</h2>
				</div>
			<form method=post action="Mem_ModifyProcess.member" name=join_member>
				<div class="joinWrite">
					<table>
						<tr>
							<td class="memberCols1">아이디</td>
							<td class="memberCols2"><input type=text name=mem_id size=15 maxlength=15 value="${meminfo.mem_id}" required readonly>
							</td>
						</tr>
						<tr>
							<td class="memberCols1">비밀번호</td>
							<td class="memberCols2">
							<input type=password name=mem_pass id=pass size=20 maxlength=20 placeholder="비밀번호를 입력해주세요.">
							<p class="txt_guide">
								<span class="txt txt_case1">10자 이상 입력</span>
								<span class="txt txt_case2">영문/숫자 조합</span>
							</p>
							</td>
						</tr>
						<tr>
							<td class="memberCols1">비밀번호 확인</td>
							<td class="memberCols2">
							<input type=password id=mem_pass_con name=mem_pass_con size=20 maxlength=20 placeholder="비밀번호를 한번 더 입력해주세요"  required>
							<p class="txt_guide">
								<span class="txt txt_case1">10자 이상 입력</span>
								<span class="txt txt_case2">영문/숫자 조합</span>
							</p>
							</td>
						</tr>
						<tr>
							<td class="memberCols1">이름</td>
							<td class="memberCols2">
							<input type=text id=name name=mem_name size=7 maxlength=7 value="${meminfo.mem_name}" required  readonly>
							</td>
						</tr>
						<tr>
							<td class="memberCols1">주민번호</td>
							<td class="memberCols2">
							<input type=text id=jumin1 name=mem_jumin1 size=6 maxlength=6 required value="${fn:split(meminfo.mem_jumin,'-')[0]}" readonly>
							&ndash;
							<input type=text id=jumin2 name=mem_jumin2 size=1 maxlength=1 required value="${fn:split(meminfo.mem_jumin,'-')[1]}" readonly> ××××××
							</td>
						</tr>
						<tr>
							<td class="memberCols1">휴대폰</td>
							<td class="memberCols2">
							<input type=text id=mobile1 name=mem_phone1 size=4 maxlength=3 value="${fn:split(meminfo.mem_phone,'-')[0]}" required>	&ndash;
							<input type=text id=mobile2 name=mem_phone2 size=4 maxlength=4 value="${fn:split(meminfo.mem_phone,'-')[1]}" required>	&ndash;
							<input type=text id=mobile3 name=mem_phone3 size=4 maxlength=4 value="${fn:split(meminfo.mem_phone,'-')[2]}" required>
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
							<input type=text id=email name=mem_email size= 20 maxlength=20 value="${fn:split(meminfo.mem_email,'@')[0]}" required>	@
							<input type=text name=mem_domain id=domain size= 20 maxlength=20 value="${fn:split(meminfo.mem_email,'@')[1]}" required>
							<select name=domain_sel id=domain_sel>
					             <option value="">직접입력</option>
					             <option value="naver.com">naver.com</option>
					             <option value="daum.net">daum.net</option>
					             <option value="nate.com">nate.com</option>
					             <option value="gmail.com">gmail.com</option>
					         </select>
							</td>
						</tr>
					</table>
				</div>
				<div class="btn_area">
			         <input type=submit id="submit" value="수정하기">
			         <input type=button id="delete" value="탈퇴하기">
			    	<input type=reset value="취소">
		    	</div>
			</form>
		</div>
		</div>
		</div>
</div>

</body>
</html>