<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="sub_menu_top">
		<h2>등록</h2>
	</div>
	<!-- 메뉴 -->
	<!-- 선택된 메뉴 -->
	<div class="sub_menu_mid">
		<table class="sub_menu_table" border="1">
			<tbody>
				<tr>
					<td><a href="${pageContext.request.contextPath}/admin/college">단과대학</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/admin/deptRegistration">학과</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/admin/room">강의실</a></td>
				</tr>
				<tr>
					<td><a href="${pageContext.request.contextPath}/admin/lecture">강의</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>