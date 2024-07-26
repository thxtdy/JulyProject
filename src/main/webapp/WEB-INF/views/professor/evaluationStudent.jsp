<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ include file="/WEB-INF/views/subMenu/subjectMenu.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/subject.css">
</head>
<body>
<!-- stu_sub_detail 에 SELECT문 던져주기  -->
	<table border="1">
		<thead>
			<tr>
				<th>학생 번호</th>
				<th>이름</th>
			</tr>
		</thead>
	<c:forEach var="student" items="${studentId}">
		<tbody>
			<td>${student.studentId}</td>
		    <td>${student.studentName} + ${student.subjectId}</td>
		    </td>
		</tbody>

	</table>
		
	<form action="${pageContext.request.contextPath}/professor/evaluationStudent" method="POST">
				<input type="hidden" name ="studentId" value ="${student.studentId}">
				<input type="hidden" name ="subjectId" value ="${student.subjectId}">
</c:forEach>						    			
	<div>
		<label for="absent">결석 </label>
			<input type="number" id="absent" name="absent">
			
		<label for="lateness">지각 </label>
			<input type="number" id="lateness" name="lateness">
			
		<label for="homework">과제 점수 </label>
			<input type="number" id="homework" name="homework">
			
		<label for="midExam">중간 시험 </label>
			<input type="number" id="midExam" name="midExam">
			
		<label for="finalExam">기말 시험 </label>
			<input type="number" id="finalExam" name="finalExam">
			
		<label for="converted">환산 점수 </label>
			<input type="number" id="converted" name="converted">
			
		<select name = "grade">
			<option value = "A+">A+</option>
			<option value = "A0">A0</option>
			<option value = "B+">B+</option>
			<option value = "B0">B0</option>
			<option value = "C+">C+</option>
			<option value = "C0">C0</option>
			<option value = "D+">D+</option>
			<option value = "D0">D0</option>
			<option value = "F">F</option>
		</select>		
			
		<button>변경하기</button>
	</div>
	</form>
	
	
</body>
</html>