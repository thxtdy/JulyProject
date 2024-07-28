<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/subjectList.css">
</head>
<body>
	<div class="registration_box" style="min-width: 100em">
		<!-- 세부 메뉴 div -->
		<div class="sub_menu">
			<%@ include file="/WEB-INF/views/subMenu/sugangMenu.jsp"%>
			</div>
			<!-- 메인 div -->
			<main>
				<div>
					<table border="1">
						<thead>
							<tr>
								<th>학수번호</th>
								<th>강의명</th>
								<th>담당교수</th>
								<th>학점</th>
								<th style="width: 200px">요일시간 (강의실)</th>
								<th>현재인원</th>
								<th>정원</th>
								<th>수강신청</th>
							</tr>
						</thead>
						<tbody>
							<h1>예비 수강 신청</h1>
							
							<h2>신청 내역</h2>
							<h3>[총 ${preGradeSum}학점]</h3>
							<c:choose>
								<c:when test="${empty selectedLect}">
									<h1>수강신청 내역이 없습니다..?</h1>
								</c:when>
								<c:otherwise>
									<c:forEach var="selectedLect" items="${selectedLect}">
										<tr>
											<td>${selectedLect.haksuNum}</td>
											<td>${selectedLect.lectureName}</td>
											<td>${selectedLect.professorName}</td>
											<td>${selectedLect.grades}</td>
											<td>${selectedLect.subDay}${selectedLect.startTime}:00 - ${selectedLect.endTime}:00 (${selectedLect.roomId})</td>
											<td>${selectedLect.numOfStudent}</td>
											<td>${selectedLect.capacity}</td>
											<td>
												<form action="${pageContext.request.contextPath}/sugang/deleteApp" method="POST">
													<button type="submit" name="selectedList" value="${selectedLect.haksuNum}" onclick="return confirm('정말 삭제할꺼야??');">삭제!</button>
													<input type="hidden" name="principal" value="${principal.id}">
													<input type="hidden" name="numOfStudent" value="${selectedLect.numOfStudent}">
												</form>
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
</body>
</html>