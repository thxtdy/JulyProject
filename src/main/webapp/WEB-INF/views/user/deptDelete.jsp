<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/subjectList.css">
<body>
	<div class="registration_box" style="min-width: 100em">
		<div class="sub_menu">
			<%@ include file="/WEB-INF/views/subMenu/registrationMenu.jsp"%>
		</div>
		<main>
			<h1>학과</h1>
			<div>
				<a href="${pageContext.request.contextPath}/admin/collegeUpdate">수정</a>
				<a href="${pageContext.request.contextPath}/admin/deptDelete">삭제</a>
				<br>
			</div>
			<div>
					<h1>삭제할 학과 이름을 클릭해주세용</h1>
			</div>
			<div>
				<table border="1">
					<thead>
						<tr>
							<th>ID</th>
							<th>학과명</th>
							<th>단과대ID</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach var="dept" items="${dept}">
							<tr>
								<td>${dept.id}</td>
								<td><a href="${pageContext.request.contextPath}/admin/departmentDelete?collegeName=${dept.name}">${dept.name}</a>
								<td>${dept.collegeId}</td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
			</div>


		</main>
	</div>

</body>
</html>