<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/subject.css">

	<!-- 세부 메뉴 + 메인 -->
	<div class="registration_box" style="min-width: 100em">
		<!-- 세부 메뉴 div -->
		<div class="sub_menu">
			<%@ include file="/WEB-INF/views/subMenu/sugangMenu.jsp"%>
			<!-- 메인 div -->
		<main> 
			<h1>강의 시간표 조회</h1>
			<div class="sub_filter">
				<form action="${pageContext.request.contextPath}/sugang/preFilter" method="GET">
				<!-- 강의구분 콤보박스 -->
				<label for="type">강의구분</label>
				<select name="type" id="type">
					<option value="ALL">전체</option>
				<c:forEach var="sugangType" items="${sugangType}">
					<option value="${sugangType.type}">${sugangType.type}</option>
					</c:forEach>
				</select>
				<!-- 대상학과 콤보박스 -->
				<label for="deptId">개설학과</label>
				<select name="deptId" id="deptId">
				<option value="ALL">전체</option>
				<c:forEach var ="sugangDeptName" items="${sugangDeptName}">
				<option value="${sugangDeptName.deptName}">${sugangDeptName.deptName}</option>
				</c:forEach>
				</select>
					<!-- TODO DB 개설학과 가져오기 -->
				<!-- 강의 검색 -->
				<label for="subName">강의명</label>
				<input type="text" name="subName" list="subName">
				<datalist id="subName">
				<c:forEach var="sugangLectureName" items="${sugangLectureName}">
					<option value="${sugangLectureName.lectureName}"></option>
				</c:forEach>
				</datalist>
				<button type="submit">조회</button>
				</form>
				
				<a href="${pageContext.request.contextPath}/sugang/preAppList">
				<button>예비 수강 신청 내역</button>
				</a>
			</div>
			<div>
				<h1>강의목록</h1> [총 ${totalBoards}건]
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
					<c:when test="${empty sugangColumnList}">
						<h1>검색된 내용이 없습니다.</h1>
					</c:when>
					<c:otherwise>
					<c:forEach var="sugangColumnList" items="${sugangColumnList}">
						<tr> 
							<td>${sugangColumnList.collegeName}</td>
							<td>${sugangColumnList.deptName}</td>
							<td>${sugangColumnList.subjectId}</td>
							<td>${sugangColumnList.type}</td>
							<td class="selected_subject_name" >${sugangColumnList.subjectName}</td>
							<td>${sugangColumnList.professorName}</td>
							<td>${sugangColumnList.grades}</td>
							<td>${sugangColumnList.subDay} ${sugangColumnList.startTime}:00 - ${sugangColumnList.endTime}:00 (${sugangColumnList.roomId})</td>
							<td>${sugangColumnList.numOfStudent}</td>
							<td>${sugangColumnList.capacity}</td>
							<td class="selected_sugang_btn">
							<form action= "${pageContext.request.contextPath}/sugang/selectedList" method="POST">
							<button type="submit" name ="selectedList" value= "${sugangColumnList.subjectId}" onclick="return confirm('정말 선택할꺼야?');">신청</button>
							</form>
							</td>
						</tr>
						</c:forEach>
						</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
			<div class="pagination">
				<c:forEach begin="1" end="${totalPages}" var="i">
					<c:choose>
						<c:when test="${i == currentPage}">
							<span class="current-page">${i}</span>
							</c:when>
							<c:otherwise>
								<span><a href="${pageContext.request.contextPath}/sugang/pre?page=${i}">${i}</a></span>
							</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
		</main>

		</div>
		</div>
</body>
</html>