<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>

<head>
<meta charset="UTF-8">
<title>공시사항 등록</title>
</head>
<body>


	<div class="d-flex">
		<div class="sub-menu">
			<div class="sub-menu-top">
				<h3>학사 정보</h3>
			</div>
			<table class="sub-menu-middle" border="1">
				<tbody>
					<tr>
						<td><a href="${pageContext.request.contextPath}/notice/notice" class="menu">공지사항</a></td>
					</tr>
					<tr>
						<td><a href="${pageContext.request.contextPath}/schedule/schedule" class="menu">학사일정</a></td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="container">
			<form action="${pageContext.request.contextPath}/notice/addregister" method="post">
				<h1>게시판</h1>
				<div class="input-form">
					<h2>글 작성하기</h2>
					<select id="category" name="category">
						<option value="&#91;일반&#93;" >일반</option>
						<option value="&#91;학사&#93;" >학사</option>
						<option value="&#91;장학&#93;" >장학</option>
					</select> 
					<label for="title">제목:</label> <input type="text" id="title" name="title" required>
					<label for="content">내용:</label> <input type="content" id="content" name="content" required>
					<textarea id="message" name="message" required></textarea>
					<button type="submit">등록</button>
					
				</div>
				<%@ include file="/WEB-INF/views/layout/footer.jsp"%>

			</form>
</body>
</html>