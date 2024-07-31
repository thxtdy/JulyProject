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
					href="${pageContext.request.contextPath}/admin/college?crud=insert">등록</a>
				<a
					href="${pageContext.request.contextPath}/admin/college?crud=delete">삭제</a>
				<br>
			</div>
			<h1>삭제할 단과 대학을 선택해주시오</h1>
			<c:if test="${not empty crudType}">
				<div>
					<c:out value="${crudType}" escapeXml="false" />
				</div>
			</c:if>
			<div>
				<table border="1">
					<thead>
						<tr>
							<th><a>ID</a></th>
							<th><a>이름</a></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="college" items="${collegeList}">
							<tr>
								<td>${college.id}</td>
								 <td><a href="${pageContext.request.contextPath}/admin/collegeDeletion?collegeName=${college.name}">${college.name}</a></td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
			</div>


		</main>
	</div>

</body>
</html>