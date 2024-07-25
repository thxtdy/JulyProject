<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ include file="/WEB-INF/views/subMenu/subjectMenu.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/subject.css">
</head>
<body>
		<c:if test="${empty requestScope.myList}">
			<a>TEST</a>
		</c:if>
		<c:if test="${not empty requestScope.myList}">
	<table border="1">
		<thead>
			<tr>
				<th>학수 번호</th>
				<th>강의명</th>
				<th>강의 시간</th>
				<th>강의 계획서</th>
				<th>학생 목록</th>
			</tr>
		</thead>
	<c:forEach var="subject" items="${myList}">
		<tbody>
		    <td>${subject.id}</td>
		    <td>${subject.name}</td>
		    <td>${subject.subDay}  ${subject.startTime}:00 - ${subject.endTime}:00 (${subject.roomId})</td>
		</tbody>
</c:forEach>
	</table>
	</c:if>
	
</body>
</html>