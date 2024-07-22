<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/header.css">
</head>
<body>
<%
request.getAttribute("principal");
%>
	<header>
>>>>>>> f9fb528665f7e2d3c431fa86cdc49752de8eea15

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

>>>>>>> ebdbf330f5c3c8e759771b450707cde9ae3e9a06
>>>>>>> 58c4baee944a8ccbe952f644c66e9ab08bd80544
		<div class="header_top_box">
			<ul class="header_top_info_ul">
				<li class="header_top_info_li">${principal.name}님 id: ${principal.id}</li>
				<li class="header_top_info_li" style="margin: 0 15px;"></li>
				<li class="header_top_info_li"><a href="/logout">로그아웃</a></li>
			</ul>
		</div>

		<nav class="header_menu">
			<!-- <h1>-- 학생 접속 시 --</h1> -->
			<ul class="header_menu_bar">
<<<<<<< HEAD
				<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/subject.jsp">홈</a>
				<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/info/student">MY</a>
				<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/subject.jsp">수업</a>
				<li class="header_menu_bar_li"><a href="/six/subject.jsp"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="로고이미지"></a>
=======
				<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/header.jsp">홈</a>
				<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/info/student">MY</a>
				<li class="header_menu_bar_li"><a href="${pageContext.request.contextPath}/subject">수업</a>
				<li class="header_menu_bar_li"><a href="/six/header.jsp"><img src="${pageContext.request.contextPath}/resources/img/bazzi_front.png" alt="로고이미지"></a>
>>>>>>> 58c4baee944a8ccbe952f644c66e9ab08bd80544
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
				<li><a href="${pageContext.request.contextPath}/info/proffessor">MY</a>
				<li><a href="${pageContext.request.contextPath}/subject">수업</a>
				<li><a href="${pageContext.request.contextPath}/notice">학사정보</a>
			</ul> --%>
		</nav>
	</header>
</body>
</html>