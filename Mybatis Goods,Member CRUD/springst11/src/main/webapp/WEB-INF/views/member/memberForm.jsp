<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
$('#idDup').on('click', function(){
	var idStr = $('#id').val();
	
	$.ajax({
		url : 'memberData.do',
		data: {'userid' : idStr},
		dataType:'json',
		success: function(data){
			if(data.idDup == 'dup'){
				alert('중복된 아이디입니다');
			}else{
				alert('사용 가능한 아이디입니다.');
			}
		},
		error: function(data){
			alert('전송 오류');
		}
		
		});
	});
});
</script>
</head>
<body>
<form action="memberInsert.do" method="get">
	<table>
		<tr><td>아이디</td><td><input type="text" name="id" id="id"><input type="button" value="중복확인" id="idDup"/></td></tr>
		<tr><td>패스워드</td><td><input type="password" name="passwd"></td></tr>	
		<tr><td>이름</td><td><input type="text" name="name"></td></tr>
		<tr><td>이메일</td><td><input type="email" name="email"></td></tr>
		<tr><td>성별</td><td>남<input type="radio" name="gender" value="M"> 여<input type="radio" name="gender" value="F"></td></tr>
		<tr><td>나이</td><td><input type="text" name="age"></td></tr>
		<tr><td>번호</td><td><input type="text" name="phone"></td></tr>
		<tr><td>주소</td><td><input type="text" name="address"></td></tr>
		<tr><td colspan="2"><input type="submit" value="등록"></td></tr>
	</table>
</form>
</body>
</html>