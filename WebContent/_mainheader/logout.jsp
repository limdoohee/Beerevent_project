<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>logout.jsp</title>
</head>
<body>
    <% session.invalidate(); %>
    <script>
      alert("�α׾ƿ� �Ǿ����ϴ�.");
      
      //�α׾ƿ� �� �̵��� �ּ� ������ �˴ϴ�.
      location.href = "///�ּҸ� ����///";
      
    </script>
</body>
</html>