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
				<a
					href="${pageContext.request.contextPath}/admin/room">등록</a>
				<a
					href="${pageContext.request.contextPath}/admin/roomDelete">삭제</a>
				<br>
			</div>
			<div>
			<h2>등록하기</h2>
			<form action="${pageContext.request.contextPath}/admin/roomRegister" method="POST">
			<input type="text" name="roomId" placeholder="등록할 강의실을 입력하세요">
			<input type="text" name="collegeId" placeholder="단과대 번호를 입력하세요">
			<button type="submit">입력</button>
			</form>
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
								<td>${room.id}</td>
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