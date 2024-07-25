<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
</head>
<body>
	<div class="registration_box" style="min-width: 100em">
		<!-- 세부 메뉴 div -->
		<div class="sub_menu">
			<%@ include file="/WEB-INF/views/subMenu/sugangMenu.jsp"%>
			<!-- 메인 div -->
			<main>
				<div>
					<h1>수강신청</h1>
				</div>
				<div><h2>신청 미완료 강의 목록</h2>
				<div><h2>신청 내역 [총0 학점]</h2></div>
				
				</div>
			</main>
		</div>
	</div>
</body>
</html>