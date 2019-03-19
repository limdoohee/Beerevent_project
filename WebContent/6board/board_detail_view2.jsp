<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="js/reply_delete.js"></script>

<c:forEach var="r" items="${reply_bean_list}">
<table class="reply_table">
<%-- <tr><td>reply_no</td><td class="reply_no">${r.reply_no}</td></tr> --%>	
<tr>
<td><span>${r.reply_content}<input type="hidden" class="reply_no" value="${r.reply_no}"></span>
<span class="right">-${r.mem_id}-${r.reply_date}&nbsp;<button class="reply_delete_button">삭제</button>
</span></td>
</tr>
</table>
</c:forEach>