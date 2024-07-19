<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<div class="container">
	<h2> 로그인</h2>

	<form action="${pageContext.request.contextPath}/user/signIn" method="post">
		<div>
		<label for="username">사용자 이름:</label>
		<input type="text" id="username" name="username" value="2023000001">
		<label for="password">비밀번호:</label>
		<input type="password" id="password" name="password" value="0000">
		<button type="submit">로그인</button>
	</div>
	</form>



</div>


	
</body>
</html>