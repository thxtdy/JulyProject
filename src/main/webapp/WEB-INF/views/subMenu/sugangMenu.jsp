<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.link-style {
        color: blue;
        text-decoration: underline;
        cursor: pointer;
        display: inline-block;
    }

    .hidden-form {
        display: inline;
    }

    .hidden-button {
        display: none;
    }
</style>
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
					 <form class="hidden-form" action="${pageContext.request.contextPath}/sugang/appList" method="get">
                        <input type="hidden" name="principal" value="${principal.id}">
                        <a class="link-style" href="#" onclick="this.parentNode.submit();">수강 신청</a>
                        <input type="submit" class="hidden-button" value="Submit">
                    </form>
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