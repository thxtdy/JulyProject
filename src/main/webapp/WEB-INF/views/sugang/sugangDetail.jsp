<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>강의 계획서 조회</title>
    <style>
        table {
            width: 70%;
            border-collapse: collapse;
            margin: 20px auto;
            border: 1px solid black;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        h1 {
            text-align: center;
        }
        .short-width {
            width: 30%;
        }
    </style>
</head>
<body>
    <h1>강의 계획서 조회</h1>
    <table>
        <tr>
            <th rowspan="4">교과목 정보</th>
            <th>수업 번호</th>
            <td colspan="2">${details.subjectId}</td>
            <th>교과목 명</th>
            <td colspan="2">${details.subName}</td>
        </tr>
        <tr>
            <th>수업 연도</th>
            <td colspan="2">${details.subYear}</td>
            <th>수업 학기</th>
            <td colspan="2">${details.semester}</td>
        </tr>
        <tr>
            <th>학점</th>
            <td colspan="2">${details.grades}</td>
            <th>이수 구분</th>
            <td colspan="2">${details.type}</td>
        </tr>
        <tr>
            <th>강의 시간</th>
            <td colspan="2">${details.subDay} ${details.startTime}:00 - ${details.endTime}:00</td>
            <th>강의실</th>
            <td colspan="2">${details.roomId}(${details.collegeName})</td>
        </tr>
    </table>
    <table>
        <tr>
            <th rowspan="2">교강사 정보</th>
            <th>소속</th>
            <td colspan="2">${details.deptName}</td>
            <th>성명</th>
            <td colspan="2">${details.professorName}</td>
        </tr>
        <tr>
            <th>연락처</th>
            <td colspan="2">${details.tel}</td>
            <th>email</th>
            <td>${details.email}</td>
        </tr>
    </table>
    <table>
        <tr>
            <th class="short-width">강의 개요</th>
            <td colspan="2"></td>
        </tr>
        <tr>
            <th class="short-width">강의 목표</th>
            <td colspan="2"></td>
        </tr>
        <tr>
            <th class="short-width">교재 정보</th>
            <td colspan="2"></td>
        </tr>
        <tr>
            <th class="short-width">주간 계획</th>
            <td colspan="2"></td>
        </tr>
    </table>
</body>
</html>
