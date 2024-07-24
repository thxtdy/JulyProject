<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<c:out value="${selectedLect}"/>
		<table border="1">
					<thead>
					<tr>
					<th>단과대학</th>
					<th>개설학과</th>
					<th>학수번호</th>
					<th>강의구분</th>
					<th style="width: 200px">강의명</th>
					<th>담당교수</th>
					<th>학점</th>
					<th>요일시간 (강의실)</th>
					<th>현재인원</th>
					<th>정원</th>
					<th>수강신청서</th>
					</tr>
					</thead>
					<tbody>
					
					<c:choose>
					<c:when test="${empty selectedLect}">
						<h1>수강신청 내역이 없습니다..?</h1>
					</c:when>
					<c:otherwise>
					<c:forEach var="selectedLect" items="${selectedLect}">
						<tr> 
							<td>${selectedLect.collegeName}</td>
							<td>${selectedLect.deptName}</td>
							<td>${selectedLect.subjectId}</td>
							<td>${selectedLect.type}</td>
							<td class="selected_subject_name" >${selectedLect.subjectName}</td>
							<td>${selectedLect.professorName}</td>
							<td>${selectedLect.grades}</td>
							<td>${selectedLect.subDay} ${selectedLect.startTime}:00 - ${selectedLect.endTime}:00 (${selectedLect.roomId})</td>
							<td>${selectedLect.numOfStudent}</td>
							<td>${selectedLect.capacity}</td>
							<td class="selected_sugang_btn">
							</td>
						</tr>
						</c:forEach>
						</c:otherwise>
						</c:choose>
					</tbody>
				</table>
		</div>
		</main>
	</div>
	</div>
</body>
</html>