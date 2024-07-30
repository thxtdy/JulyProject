<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find My</title>
</head>
<body>
	
	<c:if test="${not empty requestScope.findMyPw}">
		<a>${findMyPw.password} 입니다.</a>
	</c:if>
	
	<c:if test="${empty requestScope.findMyPw}">
	<div class="find-container">
		<div class="text-container">
			<form action="${pageContext.request.contextPath}/info/findPw" method= "post">
				<input type="number" id="userId" name="userId" placeholder="아이디를 입력해주세요">
			<button type="submit">찾기</button>
			</form>
		</div>
	</div>
	</c:if>
</body>
</html>