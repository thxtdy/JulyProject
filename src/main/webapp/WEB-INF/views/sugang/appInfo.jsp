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
						<h1>수강 신청 내역 조회</h1><span>[총 ${sumOfGrades}학점]</span>
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
							<c:choose>
								<c:when test="${empty selectedRealLect}">
									<h1>신청 내역이 없습니다</h1>
								</c:when>
								<c:otherwise>
									<c:forEach var="selectedRealLect" items="${selectedRealLect}">
										<tr>
											<td>${selectedRealLect.haksuNum}</td>
											<td>${selectedRealLect.lectureName}</td>
											<td>${selectedRealLect.professorName}</td>
											<td>${selectedRealLect.grades}</td>
											<td>${selectedRealLect.subDay}${selectedRealLect.startTime}:00-
												${selectedRealLect.endTime}:00 (${selectedRealLect.roomId})</td>
											<td>${selectedRealLect.numOfStudent}</td>
											<td>${selectedRealLect.capacity}</td>
											<td>
												<form
													action="${pageContext.request.contextPath}/sugang/cansleSugang"
													method="POST">
													<button type="submit" name="cansleSugang"
														
														onclick="return confirm('수강을 취소 하시겠습니까?');">취소</button>
													<input type="hidden" name="principal"
														value="${principal.id}">
													<input type="hidden" name="haksuNum"
														value="${selectedRealLect.haksuNum}">
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
	</div>
</body>
</html>