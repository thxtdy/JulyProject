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
			<h1>단과 대학</h1>
			<div>
				<a href="${pageContext.request.contextPath}/admin/college?crud=insert">등록</a> <a href="${pageContext.request.contextPath}/admin/college?crud=delete">삭제</a> <br>
			</div>
			<c:if test="${not empty crudType}">
				<div>
					<c:out value="${crudType}" escapeXml="false" />
				</div>
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
									<td>${college.name}</td>
								</tr>

							</c:forEach>

						</tbody>
					</table>
				</div>
			</c:if>
			<c:if test="${not empty crudType}">
				<span class="delete">삭제할 단과대학 이름을 클릭해주세요</span>
			<div class="total--container">
				<table class="table--container">
						<tr class="first--tr">
							<td>ID</td>
							<td>이름</td>
						</tr>
						<c:forEach var="college" items="${collegeList}">
							<tr>
								<td>${college.id}</td>
								<td><a href="/admin/collegeDelete?id=${college.id}">${college.name}</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>
			
			
		</main>
	</div>

</body>
</html>