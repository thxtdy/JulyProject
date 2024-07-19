<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/header.css">
</head>
<body>
	<header>
<<<<<<< HEAD
	<div class="header_top">
		<ul>
			<li>(이름)님 id: 123123 들어갈 자리</li>
			<li style="margin: 0 15px;"></li>
			<li><a href="/logout">로그아웃</a></li>
		</ul>
	</div>	
	
	<nav class="header_menu">
		<a href="/six/header.jsp">로고이미지</a>
		<h1> -- 학생 접속 시 -- </h1>
		<ul>
			<li><a href="${pageContext.request.contextPath}/header.jsp">홈</a>
			<li><a href="${pageContext.request.contextPath}/info/student">MY</a>
			<li><a href="${pageContext.request.contextPath}/subject">수업</a>
			<li><a href="${pageContext.request.contextPath}/sugang">수강신청</a>
			<li><a href="${pageContext.request.contextPath}/thisSemester">성적</a>
			<li><a href="${pageContext.request.contextPath}/notice">학사정보</a>
		</ul>
		<h1> -- 교직원 접속 시 -- </h1>
		<ul>
			<li><a href="${pageContext.request.contextPath}/header.jsp">홈</a>
			<li><a href="${pageContext.request.contextPath}/info/employee">MY</a>
			<li><a href="${pageContext.request.contextPath}/user">학사관리</a>
			<li><a href="${pageContext.request.contextPath}//admin">등록</a>
			<li><a href="${pageContext.request.contextPath}/notice">학사정보</a>
		</ul>
		<h1> -- 교사 접속 시 -- </h1>
		<ul>
			<li><a href="${pageContext.request.contextPath}/header.jsp">홈</a>
			<li><a href="${pageContext.request.contextPath}/info/professor">MY</a>
			<li><a href="${pageContext.request.contextPath}/subject">수업</a>
			<li><a href="${pageContext.request.contextPath}/notice">학사정보</a>
		</ul>
	</nav>
=======
		<div class="header_top_box">
			<ul class="header_top_info_ul">
				<li class="header_top_info_li">(변영준)님 id: 17510048</li>
				<li class="header_top_info_li" style="margin: 0 15px;"></li>
				<li class="header_top_info_li"><a href="/logout">로그아웃</a></li>
			</ul>
		</div>

		<nav class="header_menu">
			<!-- <h1>-- 학생 접속 시 --</h1> -->
			<ul class="header_menu_bar">
				<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/subject.jsp">홈</a>
				<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/info/student">MY</a>
				<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/subject.jsp">수업</a>
				<li class="header_menu_bar_li"><a href="/six/subject.jsp"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="로고이미지"></a>
				<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/sugang">수강신청</a>
				<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/thisSemester">성적</a>
				<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/notice">학사정보</a>
			</ul>
			<%-- <h1>-- 교직원 접속 시 --</h1>
			<ul>
				<li><a href="${pageContext.request.contextPath}/header.jsp">홈</a>
				<li><a href="${pageContext.request.contextPath}/info">MY</a>
				<li><a href="${pageContext.request.contextPath}/user">학사관리</a>
				<li><a href="${pageContext.request.contextPath}//admin">등록</a>
				<li><a href="${pageContext.request.contextPath}/notice">학사정보</a>
			</ul>
			<h1>-- 교사 접속 시 --</h1>
			<ul>
				<li><a href="${pageContext.request.contextPath}/header.jsp">홈</a>
				<li><a href="${pageContext.request.contextPath}/info">MY</a>
				<li><a href="${pageContext.request.contextPath}/subject">수업</a>
				<li><a href="${pageContext.request.contextPath}/notice">학사정보</a>
			</ul> --%>
		</nav>
>>>>>>> 619b75d0d1ad2f0c07f85035fcc5b895c1def2d2
	</header>
</body>
</html>