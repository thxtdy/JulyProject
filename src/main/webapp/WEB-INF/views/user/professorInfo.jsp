<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/subject.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/subjectList.css">
<%
request.getAttribute("principal");
session.getAttribute("professorInfo");
%>

<div class="registration_box" style="min-width: 100em">
	<div class="sub_menu">
		<table class="sub-bar-list" border="1">
			<tbody>
				<tr>
					<td><a
						href="${pageContext.request.contextPath}/info/professor"
						class="seleted-menu">내 정보 조회</a></td>
				</tr>
				<tr>
					<td><a
						href="${pageContext.request.contextPath}/info/professorPassword">비밀번호
							변경</a></td>
				</tr>

			</tbody>
		</table>
	</div>
	<main>
		<h1>내 정보 조회</h1>
		<div class="main"></div>
		<table class="idtable">
			<colgroup>
				<col class="col1">
				<col class="col2">
				<col class="col3">
				<col class="col4">
			</colgroup>
			<tbody>
				<tr>
					<th>ID</th>
					<td>${principal.id}</td>
					<th>소속</th>
					<td>${professorInfo.college}${professorInfo.department}</td>
				</tr>
			</tbody>
		</table>
		<table class="infotable">
			<colgroup>
				<col class="col1">
				<col class="col2">
				<col class="col3">
				<col class="col4">
			</colgroup>
			<tbody>
				<tr>
					<th>이름</th>
					<td>${professorInfo.name}</td>
					<th>생년월일</th>
					<td>${professorInfo.birthDate}</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>${professorInfo.gender}</td>
					<th>주소</th>
					<td>${professorInfo.address}</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${professorInfo.tel}</td>
					<th>email</th>
					<td>${professorInfo.email}</td>
				</tr>
			</tbody>
		</table>
		<button type="button">수정하기</button>
	</main>
</div>


</body>
</html>