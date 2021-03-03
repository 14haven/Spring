<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="goodsUpt.do" method="POST">
	<table>
	<tr><td>코드</td><td><input type="text" name="code" value="${goods.code}" readonly="readonly"></td></tr>
	<tr><td>상품명</td><td><input type="text" name="name" value="${goods.name}"></td></tr>
	<tr><td>가격</td><td><input type="text" name="price" value="${goods.price}"></td></tr>
	<tr><td>색상</td>
		<td>
			<select name="color">
				<option value="">--선택--</option>
				<option value="red" ${goods.color == 'red'? 'selected' : '' }>red</option> 
				<option value="black" ${goods.color == 'black'? 'selected' : '' }>black</option>
				<option value="blue" ${goods.color == 'blue'? 'selected' : '' }>blue</option>
				<option value="green" ${goods.color == 'green'? 'selected' : '' }>green</option>
			</select>
		</td>
	</tr>
	<tr><td colspan="2"><input type="submit" value="수정"></td></tr>
	</table>
</form>

</body>
</html>