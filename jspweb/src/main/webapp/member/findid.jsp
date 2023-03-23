<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%@ include file="/header.jsp" %>	<!--  (webapp이하생략)절대경로 -->
	<div class="cotainar">		
		<form class="signupForm"> <!-- form전송시 name으로 빼옴 -->
			<h3> 아이디찾기 </h3>
				<p> 가입하신 이메일을 입력 해주세요. </p>
				
				<div class="stitle"> 이메일 </div>
				<input type="text" 	name="memail" 	class="memail">
				<div class="checkconfirm" > </div> 
			
				
				<button class="signupbtn" type="button" onclick="findid()" > 아이디찾기 </button>

		</form>
	
	</div>
	
	
	<script src="/jspweb/js/member/login.js" type="text/javascript"></script>
</body>
</html>