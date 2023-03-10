<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/signup.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/header.jsp" %>	<!--  (webapp이하생략)절대경로 -->
	<div class="cotainar">		
		<form class="signupForm"> <!-- form전송시 name으로 빼옴 -->
			<h3> 패스워드 찾기 </h3>
				<p> 아이디와 이메일 정보를 입력 해주세요. </p>
				
				
				<div class="stitle"> 아이디 </div>
				<input type="text" 	name="mid" 	class="mid">
				
				<div class="stitle"> 이메일 </div>
				<input type="text" 	name="memail" 	class="memail">
				<div class="checkconfirm" > </div> 
			
				
				<button class="signupbtn" type="button" onclick="findpw()" > 패스워드찾기 </button>

		</form>
	
	</div>
	
	
	<script src="/jspweb/js/member/login.js" type="text/javascript"></script>
</body>
</html>