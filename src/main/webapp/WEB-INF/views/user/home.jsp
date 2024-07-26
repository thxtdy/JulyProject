<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>


<%-- <%
request.getAttribute("principal");
%> --%>
	<div class="background">
	<img alt="메인이미지" src="${pageContext.request.contextPath}/resources/img/mainBackground.jpg">
	</div>
	<div class="notice_bar">
		<div>
		<h1>공지사항</h1>
		
		<section class="notice">
			<div class="page-title">
				<div class="container">
					<h3>공지사항</h3>
				</div>
			</div>

			<div id="board-search">
				<div class="container">
					<div class="search-window">
						<form action="">
							<div class="search-wrap">
							</div>
						</form>
					</div>
				</div>
			</div>

			<!-- board list area -->
			<div id="board-list">
				<div class="container">
					<table class="board-table">
						<thead>
							<tr>
								<th scope="col" class="th-num">번호</th>
								<th scope="col" class="th-category">말머리</th>
								<th scope="col" class="th-title">제목</th>
								<th scope="col" class="th-date">등록일</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${noticelist}" var="notice">
								<tr>
									<td>${notice.id}</td>
									<td>${notice.category}</td>
									<td><a href="#!">${notice.title}</a></td>
									<td>${notice.createdTime}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</section>
	</div>
		
		</div>
		<div>
			<h1>학사일정</h1>
		</div>
			<h1>${principal.name}님, 환영합니다</h1>  	
	</div>
	
</body>
</html>