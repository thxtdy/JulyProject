<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<%@ include file="/WEB-INF/views/subMenu/staffManagement.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/subject.css">

	<h1>휴학 신청 목록</h1>
	<div class = "split--div">
		<table border="1" class="sub--list--table">
		<thead>
			<tr>
				<th>신청일자</th>
				<th>신청자 학번</th>
				<th>구분</th>
				<th>시작학기</th>
				<th>종료학기</th>
				<th>신청서 확인</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="breakList" items="${breakList}">
                <tr>
                    <td>${breakList.appDate}</td>
                    <td>${breakList.studentId}</td>
                    <td>${breakList.type}</td>
                    <td>${breakList.fromSemester}</td>
                    <td>${breakList.toSemester}</td>
                    <form action="${pageContext.request.contextPath}/management/processBreak" method="post">
                    <td><button type="submit" name="clickButton" value="${breakList.studentId}">Click</button></td>
                    </form>
                </tr>
            </c:forEach>
					</tbody>
				</table>

			<div class="pagination">
				<c:forEach begin="1" end="${totalPages}" var="i">
					<c:choose>
						<c:when test="${i == currentPage}">
							<span class="current-page">${i}</span>
							</c:when>
							<c:otherwise>
								<span><a href="${pageContext.request.contextPath}/management/breakList?page=${i}">${i}</a></span>
							</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
	</div>
	
</body>
</html>