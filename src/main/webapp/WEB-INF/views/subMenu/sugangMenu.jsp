<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="sub_menu_top">
			<h2>수강신청</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴 -->
		<div class="sub_menu_mid">
		<table class="sub_menu_table" border="1">
			<tbody>
				<tr>
					<td>
						<a href="${pageContext.request.contextPath}/sugang/subjectList">강의 시간표 조회</a>
					</td>
				</tr>
				<tr>
					<td>
					<a href="${pageContext.request.contextPath}/sugang/pre">예비 수강 신청</a>
					</td>
				</tr>
				<tr>
					<td>
					<a href="${pageContext.request.contextPath}/sugang/appList">수강 신청</a>
					</td>
				</tr>
				<tr>
					<td>
					<a href="${pageContext.request.contextPath}/sugang/appInfo">수강 신청 내역 조회</a>
					</td>
				</tr>
			</tbody>
		</table>
		</div>
</body>
</html>