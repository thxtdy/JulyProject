<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>전체 일정</title>
</head>
<body>
    <h1>전체 일정</h1>
    <table border="1">
        <tr>
            <th>번호</th>
            <th>카테고리</th>
            <th>제목</th>
            <th>조회수</th>
        </tr>
        <c:forEach items="${scheduleList}" var="schedule">
            <tr>
                <td>${schedule.id}</td>
                <td>${schedule.category}</td>
                <td>${schedule.title}</td>
                <td>${schedule.views}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>