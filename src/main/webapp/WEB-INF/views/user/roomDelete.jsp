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
			<h1>단과 대학</h1>
			<div>
				<a href="${pageContext.request.contextPath}/admin/room">등록</a> <a
					href="${pageContext.request.contextPath}/admin/roomDelete">삭제</a> <br>
			</div>
			<div>
				<h2>삭제할 강의실을 클릭해주세요</h2>
			</div>
			<div>
				<table border="1">
					<thead>
						<tr>
							<th><a>강의실</a></th>
							<th><a>단과대ID</a></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="room" items="${roomList}">
							<tr>
								<td><a
									href="${pageContext.request.contextPath}/admin/roomProcess?roomId=${room.id}">${room.id}</a>
								<td>${room.collegeId}</td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
			</div>


		</main>
	</div>

</body>
</html>