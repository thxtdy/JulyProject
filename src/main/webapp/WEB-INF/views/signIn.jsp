<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<div class="container">
	<h2> 로그인</h2>
	<%
		String success = (String)request.getParameter("message");
		if(success != null){
			
	
	%>
		<p class="success-message"><%=success %></p>
	<% } %>
	<from action="six/user/signIn" method="post">
		<label for="username">사용자 이름:</label>
		<input type="text" id="username" name="username" value="홍길동">
		
		<label for="password">비밀번호:</label>
		<input type="password" id="password" name="password" value="aaaa">
	
	
	<button type="submit">로그인</button>
	</from>



</div>


</body>
</html>