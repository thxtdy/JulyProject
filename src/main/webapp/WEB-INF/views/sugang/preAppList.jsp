<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="registration_box" style="min-width: 100em">
		<!-- 세부 메뉴 div -->
		<div class="sub_menu">
		<%@ include file="/WEB-INF/views/subMenu/sugangMenu.jsp"%>
			<!-- 메인 div -->
		<main> 
		<c:choose>
		<c:when test="">
		<h1>여기는 preAppList입니다</h1>
		</c:when>
		</c:choose>
		</main>
	</div>
	</div>
</body>
</html>