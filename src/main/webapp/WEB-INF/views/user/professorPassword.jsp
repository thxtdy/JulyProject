<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main>
		<h1>비밀번호 변경</h1>
		<div class="split--div"></div>
<<<<<<<< HEAD:src/main/webapp/WEB-INF/views/user/professorPassword.jsp
		<form action="${pageContext.request.contextPath}/info/professorPassword" method="post" class="form--container">
========
		<form action="${pageContext.request.contextPath}/professor/pwd" method="POST" class="form--container">
>>>>>>>> 4ef0af0d87a6eb645ebcd792c25fb9c2db1e4f43:src/main/webapp/WEB-INF/views/user/professerPassword.jsp
			<input type="hidden" name="_method" value="put">
			<table class="table--container">
				<tbody>

					<tr>
						<td><label for="beforePW">현재 비밀번호</label></td>
						<td><input type="password" name="current_password" class="input--box"
							id="beforePW"></td>
					</tr>

					<tr>
						<td><label for="afterPW">변경할 비밀번호</label></td>
						<td><input type="password" name="change_password" class="input--box"
							id="afterPW"></td>
					</tr>

				</tbody>
			</table>

			<br> <input type="submit" value="수정하기"
				class="btn btn-green update--button">

		</form>

	</main>



</body>
</html>