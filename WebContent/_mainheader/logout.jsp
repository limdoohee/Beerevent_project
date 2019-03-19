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
      alert("로그아웃 되었습니다.");
      
      //로그아웃 후 이동할 주소 넣으면 됩니다.
      location.href = "///주소를 넣자///";
      
    </script>
</body>
</html>