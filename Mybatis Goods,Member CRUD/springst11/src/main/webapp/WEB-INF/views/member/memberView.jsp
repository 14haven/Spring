<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="memberUpdate.do" method="get">
	<table>
		<tr><td>아이디</td><td><input type="text" name="id" value="${member.id}" readonly="readonly"></td></tr>
		<tr><td>패스워드</td><td><input type="password" name="passwd" value="${member.passwd}"></td></tr>	
		<tr><td>이름</td><td><input type="text" name="name" value="${member.name}"></td></tr>
		<tr><td>이메일</td><td><input type="email" name="email" value="${member.email}"></td></tr>
		<tr><td>성별</td><td>남<input type="radio" name="gender" value="M" ${member.gender == 'M' ? 'checked':''}> 
		여<input type="radio" name="gender" value="F"  ${member.gender == 'F' ? 'checked':''}></td></tr>
		<tr><td>나이</td><td><input type="text" name="age" value="${member.age}"></td></tr>
		<tr><td>번호</td><td><input type="text" name="phone" value="${member.phone}"></td></tr>
		<tr><td>주소</td><td><input type="text" name="address" value="${member.address}"></td></tr>
		<tr><td colspan="2"><input type="submit" value="수정"></td></tr>
	</table>
</form>
</body>
</html>