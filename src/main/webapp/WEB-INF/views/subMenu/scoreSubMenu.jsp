<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="sub-bar">
		<div class="sub-bar-top">
			<table class="sub-bar-list" border="1">
				<tbody>
					<tr>
						<td><a href="${pageContext.request.contextPath}/score/thisSemester" class="seleted-menu">금학기 성적</a></td>
					</tr>
					
					<tr>
						<td><a href="${pageContext.request.contextPath}/score/bySemester" class="seleted-menu">학기별 성적</a></td>
					</tr>
					
					<tr>
						<td><a href="${pageContext.request.contextPath}/score/cumulative" class="seleted-menu">누계 성적</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>