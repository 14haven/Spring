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
<tr><th>코드</th><th>이름</th><th>가격</th><th>색상</th><th>삭제</th></tr>

<c:forEach var="goods" items="${goodsList}">	
	<tr>
		<td><a href="goodsUpt.do?code=${goods.code}">${goods.code}</a></td><td>${goods.name}</td><td>${goods.price}</td><td>${goods.color}</td>
		<td><a href="goodsDel.do?code=${goods.code}">삭제</a></td>
	</tr>
</c:forEach>
</table>
<a href="goodsIns.do">상품 등록</a>

</body>
</html>