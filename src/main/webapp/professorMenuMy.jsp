<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="alltable">
	<div class="sub-bar">
		<div class="sub-bar-top">
			<table class="sub-bar-list" border="1">
				<tbody>
				
					<tr>
						<td><a href="${pageContext.request.contextPath}/info/professor" class="seleted-menu">내 정보 조회</a></td>
					</tr>
					
					<tr>
						<td><a href="${pageContext.request.contextPath}/info/professorPassword">비밀번호 변경</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>