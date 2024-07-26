<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/WEB-INF/views/layout/header.jsp"%>
	<%@ include file="/WEB-INF/views/subMenu/professorMenuMy.jsp"%>
	
<meta charset="UTF-8">
</head>
<body>
<main>
	<h1>개인 정보 수정</h1>
	<div class ="splite--div" ></div>
	<form action="/update" method="post" class="info--update--form">
		<input type="hidden" name="_method" value="put">
		<table class="update--table">
		<tbody>
		
		<tr>
		<td>
		<label for= address>주소</label>
		</td>
		<td>
		<input type="text" name="address" id="address" class="input-box" value="부산시 남구">
		</td>
		</tr>
		
		<tr>
		<td>
		<label for= phoneNum>전화번호</label>
		</td>
		<td>
		<input type="number" name="phoneNum" id="phoneNum" class="input-box" value="010-5267-1815">
		</td>
		</tr>
		
		<tr>
		<td>
		<label for= email>이메일</label>
		</td>
		<td>
		<input type="text" name="email" id="email" class="input-box" value="psw1@green.com">
		</td>
		</tr>
		
		<tr>
		<td>
		<label for= checkPW>비밀번호 확인</label>
		</td>
		<td>
		<input type="number" name="checkPW" id="checkPW" class="input-box">
		<button type="submit">수정하기</button>
		</td>
		</tr>
		</tbody>
		</table>
	</form>
</main>
</body>
</html>