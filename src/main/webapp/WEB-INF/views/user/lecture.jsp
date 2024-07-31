<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/subjectList.css">
<body>
	<div class="registration_box" style="min-width: 100em">
		<div class="sub_menu">
			<%@ include file="/WEB-INF/views/subMenu/registrationMenu.jsp"%>
		</div>
		<main>
			<h1>강의</h1>
			<div>
				<a href="${pageContext.request.contextPath}/admin/collegeUpdate">등록</a> <a href="${pageContext.request.contextPath}/admin/collegeUpdate">수정</a> <a
					href="${pageContext.request.contextPath}/admin/deptDelete">삭제</a> <br>
			</div>
			<div>
				<form action="${pageContext.request.contextPath}/admin/lectureRegister" method="POST">
					<h1>등록하기</h1>
					<!-- 강의구분 콤보박스 -->
					<!-- 대상학과 콤보박스 -->
					<!-- TODO DB 개설학과 가져오기 -->
					<!-- 강의 검색 -->
					<input type="text" name="subName" placeholder="강의명을 입력하세요"> <input type="text" name="professorId" placeholder="교수ID를 입력하세요"><br> <input type="text"
						name="room" placeholder="강의실을 입력하세요"><br> <input type="text" name="deptId" placeholder="학과ID를 입력하세요"><br> <select name="type" id="type">
						<option value="전공">전공</option>
						<option value="교양">교양</option>
					</select> <br> <input type="text" name="year" placeholder="연도를 입력하세요"> <br> <input type="text" name="semester" placeholder="학점을 입력하세요"> <br> <input
						type="text" name="capacity" placeholder="정원을 입력하세요"> <br> <select name="type" id="type">
						<option value="월">월</option>
						<option value="화">화</option>
						<option value="수">수</option>
						<option value="목">목</option>
						<option value="금">금</option>
					</select> <input type="text" name="subName" list="subName" placeholder="시작시간을 입력하세요"> <input type="text" name="subName" list="subName" placeholder="종료시간을 입력하세요"> <input
						type="text" name="subName" list="subName" placeholder="학점을 입력하세요"> <input type="text" name="subName" list="subName" placeholder="정원 입력하세요">
					<button type="submit">입력</button>
					<c:if test="${not empty message}">
						<script type="text/javascript">
							alert("${message}");
						</script>
					</c:if>
				</form>
			</div>
			<div>
				<table border="1">
					<thead>
						<tr>
							<th>ID</th>
							<th>강의명</th>
							<th>교수</th>
							<th>강의실</th>
							<th>학과ID</th>
							<th>구분</th>
							<th>연도</th>
							<th>학기</th>
							<th>월</th>
							<th>시작 시간</th>
							<th>끝난 시간</th>
							<th>학점</th>
							<th>인원수</th>
							<th>수강인원수</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="subject" items="${subjectList}">
							<tr>
								<td>${subject.id}</td>
								<td>${subject.name}</td>
								<td>${subject.professorId}</td>
								<td>${subject.roomId}</td>
								<td>${subject.deptId}</td>
								<td>${subject.type}</td>
								<td>${subject.subYear}</td>
								<td>${subject.semester}</td>
								<td>${subject.subDay}</td>
								<td>${subject.startTime}</td>
								<td>${subject.endTime}</td>
								<td>${subject.grades}</td>
								<td>${subject.capacity}</td>
								<td>${subject.numOfStudent}</td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
			</div>


		</main>
	</div>

</body>
</html>