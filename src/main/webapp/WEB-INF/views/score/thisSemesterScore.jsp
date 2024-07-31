<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/subject.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/subjectList.css">
	
	<h2>금학기 성적 조회</h2>
	
	<c:if test="${not empty requestScope.score}">
	<table border="1">
		<thead>
			<tr>
				<th>학번</th>
				<th>과목</th>
				<th>결석</th>
				<th>지각</th>
				<th>과제</th>
				<th>중간시험</th>
				<th>기말시험</th>
				<th>성적</th>
			</tr>		
		</thead>
		<tbody>
			<tr>
			<c:forEach var="studentScore" items="${score}">
				<td>${studentScore.studentId}</td>
				<td>${studentScore.subjectName}</td>
				<td>${studentScore.absent}</td>
				<td>${studentScore.lateness}</td>
				<td>${studentScore.homework}</td>
				<td>${studentScore.midExam}</td>
				<td>${studentScore.finalExam}</td>
				<td>${studentScore.grade}</td>
			</c:forEach>
			</tr>
		</tbody>
	</table>
	</c:if>
</body>
</html>