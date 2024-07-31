<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<meta charset="UTF-8">
</head>
<body>
	<main>
		<div class="sub_menu">
			<%@ include file="/WEB-INF/views/subMenu/subMenuMY.jsp"%>
		</div>
		<h1>개인 정보 수정</h1>
		<div class="splite--div"></div>
		<form action="${pageContext.request.contextPath}/info/updateStudent" method="post" class="info--update--form">
			<input type="hidden" name="userId" value="${principal.id}">
			<input type="hidden" name="userRole" value = "${principal.userRole}">
			<table class="update--table">
				<tbody>

					<tr>
						<td><label for=address>주소</label></td>
						<td><input type="text" name="address" id="address" class="input-box"></td>
					</tr>

					<tr>
						<td><label for=tel>전화번호</label></td>
						<td><input type="number" name="tel" id="phoneNum" class="input-box" maxlength="11"></td>
					</tr>

					<tr>
						<td><label for=email>이메일</label></td>
						<td><input type="text" name="email" id="email" class="input-box"></td>
					</tr>

					<tr>
						<td><label for=checkPassword>비밀번호 확인</label></td>
						<td><input type="number" name="checkPassword" id="checkPassword" class="input-box" maxlength="4">
							<button type="submit">수정하기</button></td>
					</tr>
				</tbody>
			</table>
		</form>
	</main>
</body>
</html>