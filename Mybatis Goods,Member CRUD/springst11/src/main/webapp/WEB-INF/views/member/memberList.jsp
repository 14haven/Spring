<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="1">
	<tr><th>아이디</th><th>이름</th><th>이메일</th><th>삭제</th>
	<tr>
<c:forEach var="member" items="${memberList}">
	<tr>
	 <td><a href="memberView.do?id=${member.id}">${member.id}</a></td><td>${member.name}</td><td>${member.email}</td>
	 <td><a href="memberDel.do?id=${member.id}">삭제</a></td> 
	</tr>
</c:forEach>
</table>
<a type="button" href="memberForm.do">멤버 추가</a>
</body>
</html>