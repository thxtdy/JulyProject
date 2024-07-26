<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ include file="/WEB-INF/views/subMenu/subjectMenu.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/subject.css">
</head>
<body>
	<!-- 조회 버튼을 눌렀을때 나오는 페이지이다.  -->
<c:if test="${empty requestScope.studentList}">
			<a>TEST</a>
		</c:if>
		<c:if test="${not empty requestScope.studentList}">
	<table border="1">
		<thead>
			<tr>
				<th>학생 번호</th>
				<th>이름</th>
				<th>소속</th>
				<th>결석</th>
				<th>지각</th>
				<th>과제점수</th>
				<th>중간 시험</th>
				<th>기말 시험</th>
				<th>환산 점수</th>
				<th>점수 기입</th>
			</tr>
		</thead>
	<c:forEach var="student" items="${studentList}">
		<tbody>
		    <td>${student.studentId}</td>
		    <td>${student.studentName}</td>
		    <td>${student.department}</td>
		    <td>${student.absent}</td>
		    <td>${student.lateness}</td>
		    <td>${student.homework}</td>
		    <td>${student.midExam}</td>
		    <td>${student.finalExam}</td>
		    <td>${student.convertedMark}</td>
		    <form action ="${pageContext.request.contextPath}/professor/evaluationStudent" method="get">
		    	<td><button type="submit">기입</button></td>
				<input type="hidden" name ="studentId" value ="${student.studentId}">		    	
		    </form>
		</tbody>
</c:forEach>
	</table>
	</c:if>
	
</body>
</html>