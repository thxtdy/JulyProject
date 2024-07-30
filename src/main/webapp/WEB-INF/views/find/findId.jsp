<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find My</title>
</head>
<body>
	
	<c:if test="${not empty requestScope.findMyId}">
		<a>${findMyId.id} 입니다.</a>
	</c:if>
	
	<c:if test="${empty requestScope.findMyId}">
	<div class="find-container">
		<div class="text-container">
			<form action="${pageContext.request.contextPath}/info/findId" method= "post">
				<input type="text" id="userName" name="userName" placeholder="이름을 입력해주세요">
				<input type="email" id="email" name="email" placeholder="이메일을 입력해주세요">
		
		<input type="radio" name="type" value="student" checked/>학생
		<input type="radio" name="type" value="staff"/>교직원
		<input type="radio" name="type" value="professor"/>교수
		<button type="submit">찾기</button>
			</form>
		</div>
	</div>
	</c:if>
</body>
</html>