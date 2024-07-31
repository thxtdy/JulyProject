<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/subjectList.css">


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
		<h1>비밀번호 변경</h1>
		<div class="split--div"></div>
		<form
			action="${pageContext.request.contextPath}/info/professorPassword"
			method="post" class="form--container">
			<input type="hidden" name="_method" value="put">
			<table class="table--container">
				<tbody>

					<tr>
						<td><label for="beforePW">현재 비밀번호</label></td>
						<td><input type="password" name="current_password"
							class="input--box" id="beforePW"></td>
					</tr>

					<tr>
						<td><label for="afterPW">변경할 비밀번호</label></td>
						<td><input type="password" name="change_password"
							class="input--box" id="afterPW"></td>
					</tr>

				</tbody>
			</table>

			<br> <input type="submit" value="수정하기"
				class="btn btn-green update--button">

		</form>

	</main>


</div>
</body>
</html>