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
	$('#codeDup').on('click', function(){
		var codeStr = $('#code').val();
		
		$.ajax({
			
			url : 'codeData.do',
			data : {'goodsCode': codeStr},
			dataType : 'json',
			success : function(data){
				if(data.codeDup == 'dup'){
					alert('중복된 코드입니다.');
				}else{
					alert('사용 가능한 코드입니다.');
				}
			},
			error : function(data){
				alert('전송 오류입니다.');
			}
			
			
		});
	});
});

</script>
</head>
<body>

<form action="goodsIns.do" method="POST">
	<table>
	<tr><td>코드</td><td><input type="text" name="code" id="code"><input type="button" value="중복확인" id="codeDup"></td></tr>
	<tr><td>상품명</td><td><input type="text" name="name"></td></tr>
	<tr><td>가격</td><td><input type="text" name="price"></td></tr>
	<tr><td>색상</td>
		<td>
			<select name="color">
				<option value="">--선택--</option>
				<option value="red">red</option> 
				<option value="black">black</option>
				<option value="blue">blue</option>
				<option value="green">green</option>
			</select>
		</td>
	</tr>
	<tr><td colspan="2"><input type="submit" value="등록"></td></tr>
	</table>
</form>

</body>
</html>