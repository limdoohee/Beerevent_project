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

<script src="jquery-3.3.1.js"></script>
<script src="js/REGISTENT_NO.js"></script>
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
</script>
</head>
<body>

	<div id="wrap">
		<div id="container">
			 <jsp:include page="../header.jsp" />
			<c:set var="s" value="${storedata }"/>
			
			<form action="Seller_mypage.jsp" method="post">
				<h3>���ü ����</h3>
				<table>
					<tr>
						<td>���ü ��</td>
						<td><input type="text" name="s_name" value="${s.store_name }"></td>
					</tr>

					<tr>
						<td>���ü ��ȭ��ȣ</td>
						<td><input type="tel" name="s_phone" value="${s.store_tel }"></td>
					</tr>

					<tr>
						<td>���ü �ּ�</td>
						<td><input type="text" name="s_location" value="${s.store_location }"></td>
					</tr>

					<tr>
						<td>�����ð�</td>
						<td><input type="time" name="s_time" value="${s.store_time }">&nbsp;- 
						<input type="time" name="s_time" value="${s.store_time }"></td>
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
							placeholder="�޴�">�������������������������� <input
							type="text" name="s_money" placeholder="����" class="list"><br>
							<input type="text" name="s_menu" placeholder="�޴�" class="list">��������������������������
							<input type="text" name="s_money" placeholder="����" class="list"><br>
							<input type="text" name="s_menu" placeholder="�޴�" class="list">��������������������������
							<input type="text" name="s_money" placeholder="����" class="list">
						</td>
						
					</div>
						
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