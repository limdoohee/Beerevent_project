<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Ǹ���ȸ��_���ü����</title>
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
				<h3>���ü ���</h3>
				<table>
					<tr>
						<td>���ü ��</td>
						<td><input type="text" name="s_name"></td>
					</tr>

					<tr>
						<td>���ü ��ȭ��ȣ</td>
						<td><input type="tel" name="s_phone"></td>
					</tr>

					<tr>
						<td>���ü �ּ�</td>
						<td><input type="text" name="s_location"></td>
					</tr>
					
					<tr>
						<td>����� ��ȣ</td>
						<td><input type="text" name="s_registent_no"
								id="li_number" maxlength="12" 
								placeholder="000-00-00000" ></td>
					</tr>
					
					<tr>
						<td>�����ð�</td>
						<td><input type="time" name="s_time">&nbsp;- <input
							type="time" name="s_time"></td>
					</tr>

					<tr>
						<td>���� ����</td>
						<td>
							<input type="checkbox" name="s_day" class="dayofweek"
								 value="��">�� 
							<input type="checkbox" name="s_day" class="dayofweek"
								 value="ȭ">ȭ
							<input type="checkbox" name="s_day"  class="dayofweek"
								 value="��">�� 
							<input type="checkbox" name="s_day"  class="dayofweek"
								 value="��">�� 
							<input type="checkbox" name="s_day" class="dayofweek"
								 value="��">��
							<input type="checkbox" name="s_day" class="dayofweek"
								  value="��">��
						    <input type="checkbox" name="s_day" class="dayofweek"
								 value="��">�� 
								<input type="checkbox" name="s_day" 
								id="all-check" value="����">����
								
					 	</td>
					</tr>

			<tr>
						<td>�ñ״�ó �޴�</td>
						<td>
					<a href=#none onclick=this.nextSibling.style.display=(this.nextSibling.style.display=='none')?'block':'none';> 
							Ŭ���Ͽ� �޴��� ������ �����ּ���
				
				</a><DIV style='display:none'> 
							<input type="text" name="s_menu" id="smg"
							placeholder="�޴��� �����ּ���">�������������������������� 
							<input type="text" name="s_money" placeholder="������ �����ּ���" class="list"><br>
							<input type="text" name="s_menu" placeholder="�޴��� �����ּ���" class="list">��������������������������
							<input type="text" name="s_money" placeholder="������ �����ּ���" class="list"><br>
							<input type="text" name="s_menu" placeholder="�޴��� �����ּ���" class="list">��������������������������
							<input type="text" name="s_money" placeholder="������ �����ּ���" class="list">
						</div>
						</td>
						
					
						
					</tr>

					<tr>
						<td><input type="submit" value="�����ϱ�" class="sub"> 
						<input type="reset" value="���" class="sub"></td>
					</tr>
				</table>
			</form>

		</div>
	</div>
</body>
</html>