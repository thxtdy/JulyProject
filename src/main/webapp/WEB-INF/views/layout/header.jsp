<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
	<div class="header_top">
		<ul>
			<li>(이름)님 id: 123123 들어갈 자리</li>
			<li style="margin: 0 15px;"></li>
			<li><a href="/logout">로그아웃</a></li>
		</ul>
	</div>	
	
	<nav class="main_menu">
		<a href="/six/main.jsp">로고이미지</a>
		<h1> -- 학생 접속 시 -- </h1>
		<ul>
			<li><a href="${pageContext.request.contextPath}/main.jsp">홈</a>
			<li><a href="${pageContext.request.contextPath}/info">MY</a>
			<li><a href="${pageContext.request.contextPath}/subject">수업</a>
			<li><a href="${pageContext.request.contextPath}/sugang">수강신청</a>
			<li><a href="${pageContext.request.contextPath}/thisSemester">성적</a>
			<li><a href="${pageContext.request.contextPath}/notice">학사정보</a>
		</ul>
		<h1> -- 교직원 접속 시 -- </h1>
		<ul>
			<li><a href="${pageContext.request.contextPath}/main.jsp">홈</a>
			<li><a href="${pageContext.request.contextPath}/info">MY</a>
			<li><a href="${pageContext.request.contextPath}/user">학사관리</a>
			<li><a href="${pageContext.request.contextPath}//admin">등록</a>
			<li><a href="${pageContext.request.contextPath}/notice">학사정보</a>
		</ul>
		<h1> -- 교사 접속 시 -- </h1>
		<ul>
			<li><a href="${pageContext.request.contextPath}/main.jsp">홈</a>
			<li><a href="${pageContext.request.contextPath}/info">MY</a>
			<li><a href="${pageContext.request.contextPath}/subject">수업</a>
			<li><a href="${pageContext.request.contextPath}/notice">학사정보</a>
		</ul>
	</nav>
	</header>
</body>
</html>