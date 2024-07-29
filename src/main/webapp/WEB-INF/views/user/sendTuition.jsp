<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/subject.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/subjectList.css">
<div class="registration_box" style="min-width: 100em">
	<!-- 세부 메뉴 div -->
	<main>
	<div class="sub_menu">
		<%@ include file="/WEB-INF/views/subMenu/staffManagement.jsp"%>
	</div>

	<form
		action="${pageContext.request.contextPath}/management/sendTuition"
		method="post">
		<input type="submit" value="등록금 고지서 발송">
	</form>
	</main>
</div>
</body>
</html>