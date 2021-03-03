<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
<%
Date nowTime = new Date();

%>
</script>
<form action="param2.do" method="get">
	<input type="text" name="code" value=""><br/>
	<input type="text" name="name" value=""><br/>
	<input type="text" name="price" value=""><br/>	
	<input type="text" name="color" value=""><br/>
	<input type="date" name="now_date" value="${nowTime}">
	<input type="submit">
</form>
</body>
</html>