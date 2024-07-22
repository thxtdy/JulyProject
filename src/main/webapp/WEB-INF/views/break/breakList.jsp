
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ include file="/WEB-INF/views/student/subMenuMY.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>여기는 휴학 신청서를 보는 JSP입니다</h2>
<h1>휴학 내역 조회</h1>
<div class="split--div"></div>



<table border="1" class="list--table">
	<thead>
		<tr>
			<th>신청일자</th>
			<th>구분</th>
			<th>시작학기</th>
			<th>종료학기</th>
			<th>신청서 확인</th>
			<th>상태</th>
		</tr>
	</thead>

	<tbody>

		<tr>
			<td>2024-07-22</td>
			<td>일반휴학</td>
			<td>2023년도&nbsp;1학기</td>
			<td>2023년도&nbsp;2학기</td>
			<td><a href="/break/detail/1">Click</a></td>
			<td><span style="color: #767676; font-weight: 600">처리중</span></td>
		</tr>

	</tbody>
</table>


</body>
</html>